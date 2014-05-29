package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Nave;
import model.Tiro;
import facade.Janela;
import facade.Mundo;

/**
 * Metodo que da funcionalidade as acoes do usuario.
 * @author Lucas do Carmo, Leno Oliveira, Alberto Junior.
 */
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

	public void keyReleased(KeyEvent e) {
		nave.disparaKeyReleased(e);
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mundo.tempo(false);
                    String acao = JOptionPane.showInputDialog(null);
                        if(acao!=null){
			if(acao.equals("AlbertoManja")){
				nave.setForcaTiro(5);
				nave.setArmas(3);
			}
			else if(acao.equals("LenoNaoManja")){
				nave.setForcaTiro(1);
				nave.setArmas(1);
			}
                        else if(acao.equals("LenoIlluminati")){
				mundo.getDataBase().setPontuacao(9999999);
                                mestre.atualizaPlacar();
			}
                        else if(acao.equals("LenoNaoManja2")){
				mundo.getDataBase().setPontuacao(-9999999);
                                mestre.atualizaPlacar();
			}
			
			mundo.tempo(true);
		}
                }
		else{
			nave.disparaKeyPressed(e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// cria array list que recebe o array list de tiro
		ArrayList<Tiro> tirosNave = nave.getTiro();

		// Tiro se move at� ser destruido ou que saia da tela
		for (int i = 0; i < tirosNave.size(); i++) {

			// Recebe um objeto Tiro do array de tiros da Nave
			Tiro tiro = (Tiro) tirosNave.get(i);

			// verifica se o tiro nao esta na posi��o final da tela
			if (tiro.isAtivo()){
				// chama m�todo para mover o tiro
				tiro.moveTiro();
			} 
			else {
				// se o tiro estiver na posi��o final da tela ele remove o tiro
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
