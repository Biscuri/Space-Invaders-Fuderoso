package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Nave;
import util.EstadoIdle;
import util.EstadoMovDir;
import util.EstadoMovEsq;

@SuppressWarnings("static-access")
public class NaveKeyListener extends KeyAdapter implements KeyListener {
	private Nave nave;
	
	public NaveKeyListener(Nave nave){
		this.nave = nave;
	}
	
	/**
	 * Metodo que verifica se a tecla foi pressionada
	 * @param e evento referente a tecla
	 */
	public void keyPressed(KeyEvent e) {
		// captura qual tecla foi pressionada
		int key = e.getKeyCode();

		//Perguntando se a tecla pressionada foi Espaco
		if (key == e.VK_SPACE) {
			nave.atira();
			nave.setAtirou(true);
		}
                // Caso seja necessario futuramente , as funcoes de subir e descer.
		/*
		//Perguntando se a tecla pressionada foi Cima
		if (key == e.VK_UP) {
			if (nave.getY() <= 0) {
				nave.setMoveY(0);
				nave.setY(0);
			}
			else {
				nave.setMoveY(-1);
			}
		}
		
		//Perguntando se a tecla pressionada foi Baixo
		if (key == e.VK_DOWN) {
			if (nave.getY() >= nave.getLimY() - (nave.getTamanhoY()*(nave.getTipo() + 0.5))) {
				nave.setMoveY(0);
				if(nave.getTipo() == 1){
					nave.setY(nave.getLimY() - (int) (nave.getTamanhoY()*(nave.getTipo() + 0.5)));	
				}
				else {
					nave.setY(nave.getLimY() - nave.getTamanhoY() - ((nave.getTipo()/2)* 30));			
				}
			}
			else {
				nave.setMoveY(1);
			}
		}
		*/		
		
		//Perguntando se a tecla pressionada foi Esquerda
		if (key == e.VK_LEFT) {
			if (!(nave.getEstadoMov() instanceof EstadoMovDir)){
				if (nave.getX() <= 0) {
					nave.setMoveX(0);
					nave.setX(0);
					nave.setEstadoMov(new EstadoIdle());
				} 
				else {
					nave.setEstadoMov(new EstadoMovEsq());
					nave.setMoveX(-2);
				}
			}
		}
		
		//Perguntando se a tecla pressionada foi Direita
		if (key == e.VK_RIGHT) {
			if (!(nave.getEstadoMov() instanceof EstadoMovEsq)){
				if (nave.getX() >= nave.getLimX() - nave.getTamanhoX()) {
					nave.setMoveX(0);
					nave.setX(nave.getLimX() - nave.getTamanhoX());
					nave.setEstadoMov(new EstadoIdle());
				} 
				else {
					nave.setEstadoMov(new EstadoMovEsq());
					nave.setMoveX(2);
				}
			}
		}
		
		verifica();

	}

	/**
	 * Metodo que verifica se a tecla foi solta
	 * @param e
	 */
	public void keyReleased(KeyEvent e) {

		// captura qual tecla foi pressionada
		int key = e.getKeyCode();

		
		if (key == e.VK_SPACE) {
			nave.setAtirou(false);
		}
		
		if (key == e.VK_UP || key == e.VK_DOWN) {
			nave.setMoveY(0);
		}

		if (key == e.VK_LEFT || key == e.VK_RIGHT) {
			nave.setEstadoMov(new EstadoIdle());
			nave.setMoveX(0);
		}
		
		verifica();
	}
	
	private void verifica(){
		//verificao automatica
		if (nave.getX() >= nave.getLimX() - nave.getTamanhoX()) {
			nave.setX(nave.getLimX() - nave.getTamanhoX());
		} 
		else if (nave.getX() <= 0) {
			nave.setX(0);
		}
	}
}
