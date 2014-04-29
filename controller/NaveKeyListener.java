package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Nave;

@SuppressWarnings("static-access")
public class NaveKeyListener extends KeyAdapter implements KeyListener {
	private Nave nave;
	
	public NaveKeyListener(Nave nave){
		this.nave = nave;
	}
	
	/**
	 * Método que verifica se a tecla foi pressionada
	 * @param e evento referente a tecla
	 */
	public void keyPressed(KeyEvent e) {
		// captura qual tecla foi pressionada
		int key = e.getKeyCode();

		//Perguntando se a tecla pressionada foi Espaço
		if (key == e.VK_SPACE) {
			nave.atira();
			nave.setAtirou(true);
		}

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
			if (nave.getX() <= 0) {
				nave.setMoveX(0);
				nave.setX(0);
			} 
			else {
				nave.setMoveX(-1);
			}
		}
		
		//Perguntando se a tecla pressionada foi Direita
		if (key == e.VK_RIGHT) {
			if (nave.getX() >= nave.getLimX() - nave.getTamanhoX()) {
				nave.setMoveX(0);
				nave.setX(nave.getLimX() - nave.getTamanhoX());
			} 
			else {
				nave.setMoveX(1);
			}
		}
		
		verifica();

	}

	/**
	 * Método que verifica se a tecla foi solta
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
			nave.setMoveX(0);
		}
		
		verifica();
	}
	
	private void verifica(){
		//verificação automatica
		if (nave.getX() >= nave.getLimX() - nave.getTamanhoX()) {
			nave.setX(nave.getLimX() - nave.getTamanhoX());
		} 
		else if (nave.getX() <= 0) {
			nave.setX(0);
		}
	}
}
