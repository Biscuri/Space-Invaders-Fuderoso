package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import util.Colidivel;
/**
 * Classe que implementa os Aliens do jogo.
 * @author Alberto Junior, Lucas do Carmo, Leno Oliveira.
 */
public class Alien extends Colidivel {
	private int tipo; //limite 2, referente ao tamanho do sprite
	private final int vidaTotal; //limite 5
	private int vidaAtual;
	private int velocidadeAtira; //limite 5
	private int tempoTiro; //delay do tiro
	
	private Image alienImagem; //Imagem
	private ImageIcon alienIcone; //Icone da imagem
	
	private boolean chegouDireita; //pergunta se chegou no canto da tela
	private boolean possoAtirarNemPergunte; //auto Explicativa
	
	private ArrayList<Tiro> tiros;
	private ArrayList<Alien> brodinhos;

	public Alien(int tipo, int velocidadeAtira, int forca, int posX, int posY, int limX, int limY){
		super(posX, posY, limX, limY);
		
		//Subtrai 1 para que os aliens n�o comecem com status com valor 0, assim somando 1 + 1 e subtraindo 1, o valor ser� 1.
		int soma = velocidadeAtira + forca - 1;
		
		//Criando as imagens do alien, efetua a soma para saber qual dos aliens �, e depois pega o tipo, referente ao tamanho do sprite
		alienIcone = new ImageIcon("imagens/alien_" + soma + "_" + tipo + ".png");
		alienImagem = alienIcone.getImage();
		
		//Definindo tamanho do alien;
		super.setTamanhoX(alienIcone.getIconWidth());
		super.setTamanhoY(alienIcone.getIconHeight());
			
		this.chegouDireita = true;
		this.velocidadeAtira = forca;
		this.vidaTotal = velocidadeAtira;
		vidaAtual = velocidadeAtira;	
		tiros = new ArrayList<Tiro>();
		
		Random cdTiro = new Random();
		tempoTiro = cdTiro.nextInt(1000);
                brodinhos = new ArrayList();

	}

        public Alien(int posX, int posY, int limX, int limY){
            super(posX, posY, limX, limY); 
            vidaTotal = 5;
            vidaAtual = 5;
            chegouDireita = true;
        }
        /**
         * Metodo da Inteligencia Artifical do Alien
         * @param nivel 
         */
	public void IA(int nivel){
		movimento(nivel);
		if ((tempoTiro % (1200 / (nivel*velocidadeAtira))) == 0) {
			atira();
			tempoTiro = 0;
		}
		tempoTiro++;
	}
	/**
         * Metodo que faz o movimento do Alien
         */
	private void movimento(int speed){
                if (speed > 2){
                        speed = 2;
                            }
		if(getX() <= getLimX() - getTamanhoX() && chegouDireita) {
                        
			setX(getX() + speed);
		}
		else if (getX() > 0 && !chegouDireita) {
			chegouDireita = false;
			setX(getX() - speed);
		}
		else if(getX() + getTamanhoX() >= getLimX()){
			chegouDireita = false;
		}
		else if(getX() <= 0){
			chegouDireita = true;
		}
	}
	/**
         * Metodo que faz o Alien atirar
         */
	private void atira() {
		if (podeAtirar() || possoAtirarNemPergunte) {
			tiros.add(new Tiro(getX() + (int) (getTamanhoX() * 0.45), getY()	+ getTamanhoY(), getLimX(), getLimY(), -1));
		}
	}

	// Verificacao de poder atirar
	private boolean podeAtirar() {
		if (brodinhos.indexOf(this) == brodinhos.size() - 1) {
			possoAtirarNemPergunte = true;
			return true;
		} 
		else {
			return false;
		}
	}
        /**
         * Metodo que limpa a lista de tiros
         */
	public void zeraLista() {
		tiros.clear();
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
	 * Metodo que define se ele foi atingido e decrementa sua vida
	 * @param vida
	 */
	public void setVidaAtual(int vida) {
		this.vidaAtual += vida;
	}

	public int getVidaAtual() {
		return vidaAtual;
	}
	
	public int getForca() {
		return velocidadeAtira;
	}

	public void setForca(int forca) {
		this.velocidadeAtira = forca;
	}
	
	public Image getAlienImagem() {
		return alienImagem;
	}

	public void setAlienImagem(Image alienImagem) {
		this.alienImagem = alienImagem;
	}
	
	/**
	 * Metodo que verifica a quantia de vida do alien para verificar se o mesmo est� vivo
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
	 * Metodo que retorna quantos pontos o alien vale
	 * @return soma da vida mais a forca multiplicado por 10 (vida+forca)*10
	 */
	public int getPontuacao(){
		return (vidaTotal+velocidadeAtira)*10;
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
         /**
         * Metodo que faz o Alien Atirar
         * @deprecated Metodo utilizado apenas para teste , não deve ser utilizado.
         */
        public void atiraTest(){
                tiros.add(new Tiro(getX() + (int) (getTamanhoX() * 0.45), getY()	+ getTamanhoY(), getLimX(), getLimY(), -1));
        }
        
        public void alienDown(){
            ImageIcon alienIcone = new ImageIcon("Imagens/Explosao.gif");
            this.setAlienImagem(alienIcone.getImage());
        }


        
        
}
