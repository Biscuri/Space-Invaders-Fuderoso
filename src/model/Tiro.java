package model;

import util.Colidivel;

/**
 * Classe que implementa os Tiros do Jogo.
 * @author Alberto Manoel, Leno Oliveira, Lucas do Carmo.
 */
public class Tiro extends Colidivel{
	private int velocidade = -2;
	private boolean ativo;
	/**
         * Construtor da classe
         * @param x Posicao X
         * @param y Posicao Y
         * @param limX Limite da Tela em X
         * @param limY Limite da Tela em Y
         * @param direcao Direcao do Tiro ( cima / baixo )
         */
	public Tiro(int x, int y, int limX, int limY, int direcao){
		super(x, y, limX, limY);
		ativo = true;
		velocidade = velocidade*direcao;
	}

	// metodo para animar o tiro
	public void moveTiro() {
		// define a posicao y do tiro levando em conta a velocidade
		setY(getY() + velocidade);

		// se o tiro atingir a posicao final da tela ele sera apagado
		if (getY() < 0 || getY() > getLimY() || !ativo ) {
			ativo = false;
		}
	}

	public boolean isAtivo(){
		return ativo;
	}
	
	public void setAtivo(boolean ativo){
		this.ativo = ativo;
	}
}
