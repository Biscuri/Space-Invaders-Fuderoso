package facade;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
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
		JPanel estilo = new JPanel(new BorderLayout());

		JPanel loja1 = new JPanel(new GridLayout(6, 1));
		loja1.add(new JLabel("Ola, " + dataBase.getNomeJogador() + "."));
		loja1.add(new JLabel("Vejo que você possui um pouco de dinheiro, gostaria de comprar algo?"));
		loja1.add(new JLabel(""));
		loja1.add(new JLabel("Dia: " + dataBase.getDias()));
		loja1.add(new JLabel("Dinheiro: " + dataBase.getPontuacao()));
			
		ImageIcon b1Imagem = new ImageIcon("imagens/piloto.png");
		ImageIcon b2Imagem = new ImageIcon("imagens/nave_1.png");
		ImageIcon b3Imagem = new ImageIcon("imagens/nave_1.png");
		ImageIcon b4Imagem = new ImageIcon("imagens/nave_1.png");
		
		JButton b1 = new JButton("Mudar Nome", b1Imagem);
		JButton b2 = new JButton("Vida", b2Imagem);
		JButton b3 = new JButton("Mais Armas", b3Imagem);
		JButton b4 = new JButton("Melhorar tiro", b4Imagem);

		b1.setToolTipText("Valor: " + dataBase.getLoja(1));
		b2.setToolTipText("Valor: " + dataBase.getLoja(2));
		b3.setToolTipText("Valor: " + dataBase.getLoja(3));
		b4.setToolTipText("Valor: " + dataBase.getLoja(4));
		
		JPanel loja2 = new JPanel(new GridLayout(2, 2));
		loja2.add(b1);
		loja2.add(b2);
		loja2.add(b3);
		loja2.add(b4);
		
		estilo.add(BorderLayout.NORTH, loja1);
		estilo.add(BorderLayout.CENTER, loja2);

		mensagemRetorno.add(estilo);

		Dimension tamanhoJanelasExtras = new Dimension((int) (mundo.getWidth()*(0.7)),(int) (mundo.getHeight()*(0.7)));
		mensagemRetorno.setPreferredSize(tamanhoJanelasExtras);
		mensagemRetorno.setLocation((int) (mundo.getWidth() * 0.55),(int) (mundo.getHeight() * 0.3));
		mensagemRetorno.pack();  
		mensagemRetorno.setTitle("Hangar");
		mensagemRetorno.setModal(true);
		mensagemRetorno.setResizable(false);
		mensagemRetorno.setVisible(true);
	}
	
}
