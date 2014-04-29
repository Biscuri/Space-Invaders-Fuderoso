package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import facade.Janela;
import facade.Menu;

public class MenuKeyListener  extends MouseAdapter implements ActionListener{
	
	private Janela mestre;
	private Menu menu;
	
	public MenuKeyListener(Janela mestre, Menu menu){
		this.mestre = mestre;
		this.menu = menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton auxBotao = (JButton) e.getSource();
		String func = auxBotao.getText();
		
		if(func.equals("Comecar")){
			mestre.comeca();
			mestre.remove(menu);
		}
		
		else if(func.equals("Dificuldade")){
			menu.dificuldade();
		}
		
		else if(func.equals("Resolucao")){
			menu.resolucao();
		}
		
		else if(func.equals("Creditos")){
			menu.creditos();
		}
		
		else {
			mestre.sair();
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		super.mouseClicked(arg0);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseReleased(e);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mousePressed(e);
	}

}
