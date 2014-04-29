package util;

import model.Alien;
import model.Nave;


public class Colidivel {
	private int x;
	private int y;
	private int moveX;
	private int moveY;
	private int limX;
	private int limY;
	private boolean colidiu;

	public Colidivel(int x, int y, int limX, int limY){
		this.x = x;
		this.y = y;
		this.limX = limX;
		this.limY = limY;
	}
	
	public boolean colidiu(Colidivel obj){
            if(obj instanceof Alien){
		Alien objAux = (Alien) obj;
                if(x >= objAux.getX() && x <= objAux.getX() + objAux.getTamanhoX()){
			if(y >= objAux.getY() && y <= objAux.getY() + objAux.getTamanhoY() - 5){
				return true;
			}
		}
	
            }
            
            else if (obj instanceof Nave){
                Nave objAux = (Nave) obj;
		if(x >= objAux.getX() && x <= objAux.getX() + objAux.getTamanhoX()){
			if(y >= objAux.getY() && y <= objAux.getY() + objAux.getTamanhoY() - 5){
				return true;
			}
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
	
}
