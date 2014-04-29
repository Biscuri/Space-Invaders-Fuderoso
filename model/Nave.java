package model;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import util.Colidivel;
import controller.NaveKeyListener;

public class Nave extends Colidivel{
	private final int tamanhoX;
	private final int tamanhoY;
	private int tipo;
	private int forcaTiro;
	private int qtdArmas;
	
	private Image naveImagem;
	private ImageIcon naveIcone;
	
	private NaveKeyListener naveEvento;
	
	private ArrayList<Tiro> tiros;
	private boolean atirou;
	
	/**
	 * Construtor do objeto Nave
	 * @param tipo referente ao tipo da resolucao
	 * @param vidas quantidade de vidas
	 * @param posX posicaoo atual em X
	 * @param posY posicao atual em Y
	 * @param limX limite da tela em X
	 * @param limY limite da tela em Y
	 */
	public Nave(int tipo, int posX, int posY, int limX, int limY){
		super(posX, posY, limX, limY);

		//Definindo tipo da Nave
		this.tipo = tipo;
		
		//Criando as imagens da Nave
		naveIcone = new ImageIcon("imagens/nave_" + tipo + ".png");
		naveImagem = naveIcone.getImage();
		
		//Definindo tamanho da Nave;
		tamanhoX = naveIcone.getIconWidth();
		tamanhoY = naveIcone.getIconHeight();
		
		//Criando conjunto de tiros
		tiros = new ArrayList<Tiro>();
		
		//Criando espectador de eventos
		naveEvento = new NaveKeyListener(this);
		
		//definindo pot�ncia do tiro
		forcaTiro = 2;
		qtdArmas = 1;
	}
	
	/**
	 * M�todo que faz a movimenta��o da nave, utilizando os atributos da super classe
	 * Colidivel
	 */
	public void moveNave(){
		setX(getX() + getMoveX());
		setY(getY() + getMoveY());
	}
	
	/**
	 * M�todo que da o comando de atirar
	 */
	public void atira(){
		if(!(atirou)){
			//Definindo quantos tiros a nave dispara por vez
			if(qtdArmas == 3){
				tiros.add(new Tiro(getX() + (tamanhoX/4), getY() + (tamanhoY/2), getLimX(), getLimY(), 1));

				tiros.add(new Tiro(getX() + (int)(tamanhoX*0.48), getY(), getLimX(), getLimY(), 1));

				tiros.add(new Tiro(getX() + (int)(tamanhoX*0.72), getY() + (tamanhoY/2), getLimX(), getLimY(), 1));
			}
			else if(qtdArmas == 2){
				tiros.add(new Tiro(getX() + (tamanhoX/4), getY() + (tamanhoY/2), getLimX(), getLimY(), 1));
				
				tiros.add(new Tiro(getX() + (int)(tamanhoX*0.72), getY() + (tamanhoY/2), getLimX(), getLimY(), 1));
			}
			else{
				tiros.add(new Tiro(getX() + (int)(tamanhoX*0.48), getY(), getLimX(), getLimY(), 1));
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		naveEvento.keyReleased(e);
	}
	
	public void keyPressed(KeyEvent e){
		naveEvento.keyPressed(e);
	}

	public ArrayList<Tiro> getTiro() {
		return tiros;
	}

	public int getTamanhoX() {
		return tamanhoX;
	}

	public int getTamanhoY() {
		return tamanhoY;
	}

	public Image getNaveImagem() {
		return naveImagem;
	}

	public void setNaveImagem(Image naveImagem) {
		this.naveImagem = naveImagem;
	}

	public boolean isAtirou() {
		return atirou;
	}

	public void setAtirou(boolean atirou) {
		this.atirou = atirou;
	}
	
	public int getTipo(){
		return tipo;
	}
	
	public void setForcaTiro(int forcaTiro){
		this.forcaTiro = forcaTiro;
	}
	
	public int getForcaTiro(){
		return forcaTiro;
	}
	
	public void setQtdArmas(int qtdArmas){
		this.qtdArmas = qtdArmas;
	}
	
}
