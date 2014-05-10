package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import model.Nave;
import model.Tiro;
import facade.Janela;
import facade.Mundo;

public class MundoKeyListenerAdapter extends KeyAdapter implements ActionListener{
	private Nave nave;
	private Mundo mundo;
	private Janela mestre;
	
	public MundoKeyListenerAdapter(Nave nave, Mundo mundo, Janela mestre) {
		super();
		this.mundo = mundo;
		this.nave = nave;
		this.mestre = mestre;
	}
	
	public void matouAlien(){
		mestre.atualizaPlacar();
	}
	
	public void terminouFase(){
		mestre.terminouFase();
	}

	public void keyPressed(KeyEvent e) {
		nave.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		nave.keyReleased(e);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// cria array list que recebe o array list de tiro
		ArrayList<Tiro> tirosNave = nave.getTiro();

		// Tiro se move até ser destruido ou que saia da tela
		for (int i = 0; i < tirosNave.size(); i++) {

			// Recebe um objeto Tiro do array de tiros da Nave
			Tiro tiro = (Tiro) tirosNave.get(i);

			// verifica se o tiro nao esta na posição final da tela
			if (tiro.isAtivo()){
				// chama método para mover o tiro
				tiro.moveTiro();
			} 
			else {
				// se o tiro estiver na posição final da tela ele remove o tiro
				// do list
				tirosNave.remove(i);
			}
		}

		// chama o metodo moveNave a cada novo evento
		nave.moveNave();

		// cham o metodo repaint(0 para redesenhar a tela
		mundo.repaint();
	}
}
