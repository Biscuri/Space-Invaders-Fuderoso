package model;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import util.Colidivel;
import util.EstadoIdle;
import util.EstadoMov;
import util.EstadoTiros;
import controller.NaveKeyListener;

/**
 * Classe que implementa a Nave (Player) do jogo.
 * @author Alberto Junior, Leno Oliveira, Lucas do Carmo
 */
public class Nave extends Colidivel{
	private int tipo;
	private int forcaTiro;
	private int qtdArmas;
	
	private Image naveImagem;
	private ImageIcon naveIcone;
	
	private NaveKeyListener naveEvento;
	
	private EstadoMov estadoMov;
	private EstadoTiros estadoTiros;
	
	/**
	 * Construtor do objeto Nave
	 * @param tipo referente ao tipo da resolucao
	 * @param vidas quantidade de vidas
	 * @param posX posicao atual em X
	 * @param posY posicao atual em Y
	 * @param limX limite da tela em X
	 * @param limY limite da tela em Y
	 */
	public Nave(int tipo, int posX, int posY, int limX, int limY){
		super(posX, posY, limX, limY);
		estadoMov = new EstadoIdle();

		//Definindo tipo da Nave
		this.tipo = tipo;
		
		//Criando as imagens da Nave
		naveIcone = new ImageIcon("imagens/nave_" + tipo + ".png");
		naveImagem = naveIcone.getImage();
		
		//Definindo tamanho da Nave;
		super.setTamanhoX(naveIcone.getIconWidth());
		super.setTamanhoY(naveIcone.getIconHeight());
		
		//Criando conjunto de tiros
		estadoTiros = new EstadoTiros(new ArrayList<Tiro>());
		
		//Criando espectador de eventos
		naveEvento = new NaveKeyListener(this);
		
		//definindo pot�ncia do tiro
		forcaTiro = 1;
		qtdArmas = 1;
	}
	
	/**
	 * Metodo que faz a movimentacao da nave, utilizando os atributos da super classe
	 * Colidivel
	 */
	public void moveNave(){
		setX(getX() + getMoveX());
		setY(getY() + getMoveY());
	}
	
	/**
	 * Metodo que da o comando de atirar
	 */
	public void atira(){
		if(!(estadoTiros.isAtirou()) && estadoTiros.getTiros().size() <= 3*qtdArmas){
			//Definindo quantos tiros a nave dispara por vez
			if(qtdArmas == 3){
				estadoTiros.getTiros().add(new Tiro(getX() + (getTamanhoX()/4), getY() + (getTamanhoY()/2), getLimX(), getLimY(), 1));

				estadoTiros.getTiros().add(new Tiro(getX() + (int)(getTamanhoX()*0.48), getY(), getLimX(), getLimY(), 1));

				estadoTiros.getTiros().add(new Tiro(getX() + (int)(getTamanhoX()*0.72), getY() + (getTamanhoY()/2), getLimX(), getLimY(), 1));
			}
			else if(qtdArmas == 2){
				estadoTiros.getTiros().add(new Tiro(getX() + (getTamanhoX()/4), getY() + (getTamanhoY()/2), getLimX(), getLimY(), 1));
				
				estadoTiros.getTiros().add(new Tiro(getX() + (int)(getTamanhoX()*0.72), getY() + (getTamanhoY()/2), getLimX(), getLimY(), 1));
			}
			else{
				estadoTiros.getTiros().add(new Tiro(getX() + (int)(getTamanhoX()*0.48), getY(), getLimX(), getLimY(), 1));
			}
		}
	}	
	/**
         * Metodo que dispara o evento de Botao(teclado) foi despressionado
         * @param e evento com o botao pressionado
         */
	public void disparaKeyReleased(KeyEvent e){
		naveEvento.keyReleased(e);
	}
	/**
         * Metodo que dispara o evento do botao pressionado
         * @param e evento botao pressionado
         */
	public void disparaKeyPressed(KeyEvent e){
		naveEvento.keyPressed(e);
	}

	public ArrayList<Tiro> getTiro() {
		return estadoTiros.getTiros();
	}

	public Image getNaveImagem() {
		return naveImagem;
	}

	public void setNaveImagem(Image naveImagem) {
		this.naveImagem = naveImagem;
	}

	public boolean isAtirou() {
		return estadoTiros.isAtirou();
	}

	public void setAtirou(boolean atirou) {
		estadoTiros.setAtirou(atirou);
	}
	
	public int getTipo(){
		return tipo;
	}
	
	public void setForcaTiro(int forcaTiro){
		this.forcaTiro = forcaTiro;
	}
        
        public void incrementaForcaTiro(int forcaTiro){
            this.forcaTiro +=forcaTiro;  
        }
	
	public int getForcaTiro(){
		return forcaTiro;
	}
	/**
         * Metodo que retorna a Cor do Tiro
         * @return cor do tiro dependendo da forca
         */
	public Color getCorTiro(){
		if(forcaTiro == 1){
			return Color.GREEN;
		}
		else if(forcaTiro== 2){
			return Color.YELLOW;	
		}
		else if(forcaTiro == 3){
			return Color.ORANGE;	
		}
		else {
			return Color.RED;	
		}	
	}
	/**
         * Metodo que seta a quantidade de armas de forma incremental
         * @param qtdArmas Quantidade de armas que sera incrementada.
         */
	public void setQtdArmas(int qtdArmas){
		this.qtdArmas +=  qtdArmas;
	}
        /**
         * Metodo que seta as armas de forma direta
         * @param qtd nova quantidade de armas
         */
        public void setArmas(int qtd){
            qtdArmas = qtd;
        }

    public void setTiros(ArrayList<Tiro> tiros) {
        estadoTiros.setTiros(tiros);
    }

    public int getQtdArmas() {
        return qtdArmas;
    }

	public EstadoMov getEstadoMov() {
		return estadoMov;
	}

	public void setEstadoMov(EstadoMov estadoMov) {
		this.estadoMov = estadoMov;
	}
        
        
	
}
