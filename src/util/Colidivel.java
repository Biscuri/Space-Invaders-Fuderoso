package util;

/**
 * Classe que implementa todos os metodos necessarios para a colisao dos objetos
 * @author Alberto Manoel, Leno Oliveira, Lucas do Carmo
 */
public class Colidivel {
	private int x;
	private int y;
	private int moveX;
	private int moveY;
	private int limX;
	private int limY;
	private int tamX;
	private int tamY;
	private boolean colidiu;
        /**
         * Construtor da classe
         * @param x posicao X
         * @param y Posicao Y
         * @param limX limite da tela em X
         * @param limY  limite da tela em Y
         */
	public Colidivel(int x, int y, int limX, int limY){
		this.x = x;
		this.y = y;
		this.limX = limX;
		this.limY = limY;
	}
	/**
         * Metodo que verifica se houve colisao
         * @param alien Alien a ser verificada a colisao
         * @return true se houve colisao,false se nao houve colisao
         */
	public boolean colidiu(Colidivel alien){
		int alienX = alien.getX();
		int alienY = alien.getY();
		
		if(x >= alienX && x <= alienX + alien.getTamanhoX()){
			if(y >= alienY && y <= alienY + alien.getTamanhoY() - 5){
				return true;
			}
		}
		return false;
	}

	public boolean isColidiu(){
		return colidiu;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getMoveX() {
		return moveX;
	}
	
	public void setMoveX(int moveX) {
		this.moveX = moveX;
	}
	
	public int getMoveY() {
		return moveY;
	}
	
	public void setMoveY(int moveY) {
		this.moveY = moveY;
	}

	public int getLimX() {
		return limX;
	}

	public void setLimX(int limX) {
		this.limX = limX;
	}

	public int getLimY() {
		return limY;
	}

	public void setLimY(int limY) {
		this.limY = limY;
	}

	public int getTamanhoX() {
		return tamX;
	}

	public void setTamanhoX(int tamX) {
		this.tamX = tamX;
	}

	public int getTamanhoY() {
		return tamY;
	}

	public void setTamanhoY(int tamy) {
		this.tamY = tamy;
	}
}
