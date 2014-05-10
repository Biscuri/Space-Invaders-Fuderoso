package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import util.Colidivel;

public class Alien extends Colidivel {
	private int tipo; //limite 2, referente ao tamanho do sprite
	private final int vidaTotal; //limite 5
	private int vidaAtual;
	private int forca; //limite 5
	private int tempoTiro; //delay do tiro
	
	private Image alienImagem; //Imagem
	private ImageIcon alienIcone; //Icone da imagem
	
	private boolean chegouDireita; //pergunta se chegou no canto da tela
	private boolean possoAtirarNemPergunte; //auto Explicativa
	
	private ArrayList<Tiro> tiros;
	private ArrayList<Alien> brodinhos;

	public Alien(int tipo, int vida, int forca, int posX, int posY, int limX, int limY){
		super(posX, posY, limX, limY);
		
		//Subtrai 1 para que os aliens não comecem com status com valor 0, assim somando 1 + 1 e subtraindo 1, o valor será 1.
		int soma = vida + forca - 1;
		
		//Criando as imagens do alien, efetua a soma para saber qual dos aliens é, e depois pega o tipo, referente ao tamanho do sprite
		alienIcone = new ImageIcon("imagens/alien_" + soma + "_" + tipo + ".png");
		alienImagem = alienIcone.getImage();
		
		//Definindo tamanho do alien;
		super.setTamanhoX(alienIcone.getIconWidth());
		super.setTamanhoY(alienIcone.getIconHeight());
			
		this.chegouDireita = true;
		this.forca = forca;
		this.vidaTotal = vida;
		vidaAtual = vida;	
		tiros = new ArrayList<Tiro>();
		
		Random cdTiro = new Random();
		tempoTiro = cdTiro.nextInt(1000);
	}

	public void IA(int nivel){
		movimento();
		if ((tempoTiro % (1200 / nivel)) == 0) {
			atira();
			tempoTiro = 0;
		}
		tempoTiro++;
	}
	
	private void movimento(){
		if(getX() <= getLimX() - getTamanhoX() && chegouDireita) {
			setX(getX() + 1);
		}
		else if (getX() > 0 && !chegouDireita) {
			chegouDireita = false;
			setX(getX() - 1);
		}
		else if(getX() + getTamanhoX() >= getLimX()){
			chegouDireita = false;
		}
		else if(getX() <= 0){
			chegouDireita = true;
		}
	}
	
	private void atira() {
		if (podeAtirar() || possoAtirarNemPergunte) {
			tiros.add(new Tiro(getX() + (int) (getTamanhoX() * 0.45), getY()	+ getTamanhoY(), getLimX(), getLimY(), -1));
		}
	}

	// Verificação de poder atirar
	private boolean podeAtirar() {
		if (brodinhos.indexOf(this) == brodinhos.size() - 1) {
			possoAtirarNemPergunte = true;
			return true;
		} 
		else {
			return false;
		}
	}

	public void zeraLista() {
		while (!tiros.isEmpty()) {
			tiros.remove(0);
		}
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getVidaTotal() {
		return vidaTotal;
	}

	/** 
	 * Método que define se ele foi atingido e decrementa sua vida
	 * @param vida
	 */
	public void setVidaAtual(int vida) {
		this.vidaAtual += vida;
	}

	public int getVidaAtual() {
		return vidaAtual;
	}
	
	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}
	
	public Image getAlienImagem() {
		return alienImagem;
	}

	public void setAlienImagem(Image alienImagem) {
		this.alienImagem = alienImagem;
	}
	
	/**
	 * Método que verifica a quantia de vida do alien para verificar se o mesmo está vivo
	 * @return true se ele estiver vivo
	 * @return false se ele estiver morto
	 */
	public boolean estaVivo(){
		if(vidaAtual <= 0){
			brodinhos.remove(this);
			return false;
		}
		return true;
	}
	
	/**
	 * Método que retorna quantos pontos o alien vale
	 * @return soma da vida mais a forca multiplicado por 10 (vida+forca)*10
	 */
	public int getPontuacao(){
		return (vidaTotal+forca)*10;
	}

	public ArrayList<Tiro> getTiros() {
		return tiros;
	}

	public void setTiros(ArrayList<Tiro> tiros) {
		this.tiros = tiros;
	}
	
	public ArrayList<Alien> getBrodinhos() {
		return brodinhos;
	}

	public void setBrodinhos(ArrayList<Alien> brodinhos) {
		this.brodinhos = brodinhos;
	}
}
