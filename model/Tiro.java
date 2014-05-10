package model;

import util.Colidivel;

public class Tiro extends Colidivel{
	private int velocidade = -2;
	private boolean ativo;
	
	public Tiro(int x, int y, int limX, int limY, int direcao){
		super(x, y, limX, limY);
		ativo = true;
		velocidade = velocidade*direcao;
	}

	// metodo para animar o tiro
	public void moveTiro() {
		// define a posição y do tiro levando em conta a velocidade
		setY(getY() + velocidade);

		// se o tiro atingir a posição final da tela ele sera apagado
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
