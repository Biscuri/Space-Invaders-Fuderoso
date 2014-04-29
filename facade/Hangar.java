package facade;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.DataBase;

@SuppressWarnings("serial")
public class Hangar extends  JDialog {
	protected Mundo mundo;
	protected final DataBase dataBase;
	
	public Hangar(Mundo mundo, DataBase dataBase){
		this.mundo = mundo;
		this.dataBase = dataBase;
		mostraHangar();
	}
	
	private void mostraHangar(){
		JDialog mensagemRetorno = new JDialog();
		
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		
		JPanel estilo = new JPanel(new BorderLayout());
	
		JPanel loja1 = new JPanel(new GridLayout(3, 1));
		loja1.add(new JLabel("Teste"));

		JPanel loja2 = new JPanel(new GridLayout(2, 2));
		loja2.add(b1);
		loja2.add(b2);
		loja2.add(b3);
		loja2.add(b4);
		
		JPanel loja3 = new JPanel(new GridLayout(3, 1));
		loja3.add(new JLabel("Teste"));

		estilo.add(BorderLayout.NORTH, loja1);
		estilo.add(BorderLayout.CENTER, loja2);
		estilo.add(BorderLayout.SOUTH, loja3);

		mensagemRetorno.add(estilo);

		Dimension tamanhoJanelasExtras = new Dimension((int) (mundo.getWidth()*(0.7)),(int) (mundo.getHeight()*(0.7)));
		mensagemRetorno.setPreferredSize(tamanhoJanelasExtras);
		mensagemRetorno.setLocation((int) (mundo.getWidth() * 0.55),(int) (mundo.getHeight() * 0.3));
		mensagemRetorno.pack();  
		mensagemRetorno.setTitle("Hangar");
		mensagemRetorno.setResizable(false);
		mensagemRetorno.setVisible(true);
	}
	
}
