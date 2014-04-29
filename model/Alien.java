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
	private int tamanhoX; //tamanho em X do alien
	private int tamanhoY; //tamanho em Y do alien
        private int cont;
        private Random cdTiro = new Random();
	
	private Image alienImagem; //Imagem
	private ImageIcon alienIcone; //Icone da imagem
	
	private boolean chegouDireita; //pergunta se chegou no canto da tela
	
	private ArrayList<Tiro> tiros;
	
	public Alien(int tipo, int vida, int forca, int posX, int posY, int limX, int limY){
		super(posX, posY, limX, limY);
		
		//Subtrai 1 para que os aliens n�o comecem com status com valor 0, assim somando 1 + 1 e subtraindo 1, o valor ser� 1.
		int soma = vida + forca - 1;
		
		//Criando as imagens do alien, efetua a soma para saber qual dos aliens �, e depois pega o tipo, referente ao tamanho do sprite
		alienIcone = new ImageIcon("imagens/alien_" + soma + "_" + tipo + ".png");
		alienImagem = alienIcone.getImage();
		
		//Definindo tamanho do alien;
		this.tamanhoX = alienIcone.getIconWidth();
		this.tamanhoY = alienIcone.getIconHeight();
		
		this.chegouDireita = true;
		this.vidaTotal = vida;
		vidaAtual = vida;
		this.forca = forca;
		
		tiros = new ArrayList<Tiro>();
                cont = cdTiro.nextInt();
	}

	public void IA(int nivel){
		if(nivel == 1){
                       
			movimento();
                        
                        if((cont % 1200) == 0){
                            atira();
                            cont = 0;
                        }
                        cont++;
			
		}
	}
	
	public void movimento(){
		if(getX() <= getLimX() - tamanhoX && chegouDireita) {
			setX(getX() + 1);
		}
		else if (getX() > 0 && !chegouDireita) {
			chegouDireita = false;
			setX(getX() - 1);
		}
		else if(getX() + tamanhoX >= getLimX()){
			chegouDireita = false;
		}
		else if(getX() <= 0){
			chegouDireita = true;
		}
	}
	
	private void atira(){
		tiros.add(new Tiro(getX() + (tamanhoX/2)-2, getY(), getLimX(), getLimY(), -1));
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
	 * M�todo que define se ele foi atingido e decrementa sua vida
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

	public int getTamanhoY() {
		return tamanhoY;
	}

	public void setTamanhoY(int tamanhoY) {
		this.tamanhoY = tamanhoY;
	}

	public int getTamanhoX() {
		return tamanhoX;
	}

	public void setTamanhoX(int tamanhoX) {
		this.tamanhoX = tamanhoX;
	}
	
	public Image getAlienImagem() {
		return alienImagem;
	}

	public void setAlienImagem(Image alienImagem) {
		this.alienImagem = alienImagem;
	}
	
	/**
	 * M�todo que verifica a quantia de vida do alien para verificar se o mesmo est� vivo
	 * @return true se ele estiver vivo
	 * @return false se ele estiver morto
	 */
	public boolean estaVivo(){
		if(vidaAtual <= 0){
			return false;
		}
		return true;
	}
	
	/**
	 * M�todo que retorna quantos pontos o alien vale
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
        
       public void zeraLista(){
           while (!tiros.isEmpty()){
               tiros.remove(0);
           }
       }

}
