package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import util.DataBase;

public class HangarKeyListener  extends MouseAdapter implements ActionListener{
	
	private DataBase dataBase;
	
	public HangarKeyListener(DataBase dataBase){
		this.dataBase = dataBase;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton auxBotao = (JButton) e.getSource();
		String func = auxBotao.getText();
		
		 if(func.equals("Mudar Nome")){
			if(dataBase.getPontuacao() >= dataBase.getLoja(1))
				dataBase.comprar(func);
		}
		 else if(func.equals("Vida")){
			if(dataBase.getPontuacao() >= dataBase.getLoja(2))
				dataBase.comprar(func);
		}
		else if(func.equals("Mais Armas")){
			if(dataBase.getPontuacao() >= dataBase.getLoja(3))
				dataBase.comprar(func);
		}
		else if(func.equals("Melhorar tiro")){
			if(dataBase.getPontuacao() >= dataBase.getLoja(4))
				dataBase.comprar(func);
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
