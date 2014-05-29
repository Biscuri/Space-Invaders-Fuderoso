package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import util.DataBase;

/**
 * Classe que escuta os eventos dos Hangar e da funcionalidade a eles
 * @author Alberto Junior, Lucas do Carmo, Leno Oliveira.
 */
public class HangarKeyListener implements ActionListener{
	
	private DataBase dataBase;
	
	public HangarKeyListener(DataBase dataBase){
		this.dataBase = dataBase;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton auxBotao = (JButton) e.getSource();
		String func = auxBotao.getText();
		
		 if(func.equals("Mudar Nome")){
			if(dataBase.getPontuacao() >= dataBase.getLoja(1)){
				String novoNome = JOptionPane.showInputDialog(null, new JLabel("Astrogildo, nao e voce?"), "Digite seu nome.");
				dataBase.comprar(func);
                                while (novoNome!=null){
                                novoNome = JOptionPane.showInputDialog(null, new JLabel("Astrogildo, nao e voce?"), "Digite seu nome.");
                                }
                               
                                dataBase.setNomeJogador(novoNome);
                               
			}
			else{
				JOptionPane.showMessageDialog(null, "Voce nao possui dinheiro suficiente.");
			}
		}
		 else if(func.equals("Vida")){
			if(dataBase.getPontuacao() >= dataBase.getLoja(2))
				dataBase.comprar(func);
			else{
				JOptionPane.showMessageDialog(null, "Voce nao possui dinheiro suficiente.");
			}
		 }
		else if(func.equals("Mais Armas")){
			if(dataBase.getPontuacao() >= dataBase.getLoja(3))
				dataBase.comprar(func);
			else{
				JOptionPane.showMessageDialog(null, "Voce nao possui dinheiro suficiente.");
			}
		}
		else if(func.equals("Melhorar tiro")){
			if(dataBase.getPontuacao() >= dataBase.getLoja(4))
				dataBase.comprar(func);
			else{
				JOptionPane.showMessageDialog(null, "Voce nao possui dinheiro suficiente.");
			}
		}		
	}
}
