package facade;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Classe responsavel pelos Creditos do Programa.
 * @author Leno Oliveira, Alberto Junior, Lucas do Carmo.
 */
public class MenuCreditos extends JDialog {

	private static final long serialVersionUID = 1L;

	public MenuCreditos(JFrame mestre) {
		JDialog mensagemRetorno = new JDialog();
		JPanel painel = new JPanel(new GridLayout(15,2));
		JButton bt = new JButton("Clique aqui para dar 10");
		
		painel.add(new JLabel(" Space Invaders Fuderoso "));
		painel.add(new JLabel(" Versao 2.0 - Beta "));
		painel.add(new JLabel(" 27/05/2014 "));
		painel.add(new JLabel("  "));
		painel.add(new JLabel("  "));
		painel.add(new JLabel("  "));
		painel.add(new JLabel(" |---------------------------|"));
		painel.add(new JLabel("  "));
		painel.add(new JLabel(" |  Alberto Junior       |"));
		painel.add(new JLabel("  "));
		painel.add(new JLabel(" |  Leno Oliveira         |"));
		painel.add(new JLabel("  "));
		painel.add(new JLabel(" |  Lucas Carmo        |"));
		painel.add(new JLabel("  "));
		painel.add(new JLabel(" |---------------------------|"));
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Este botao nao funciona!, porem obrigado!");
			}
		});
		
			painel.add(new JLabel("  "));
			painel.add(new JLabel("  "));
			painel.add(new JLabel("  "));
			painel.add(new JLabel("  "));
			painel.add(new JLabel("  "));
			painel.add(new JLabel("  "));
			painel.add(new JLabel("  "));
			painel.add(new JLabel("  "));
			painel.add(new JLabel("  "));
			painel.add(new JLabel("  "));
			painel.add(new JLabel("  "));
			painel.add(new JLabel("  "));
			painel.add(new JLabel("  "));
			painel.add(new JLabel("  "));
		
		painel.add(bt);

		Dimension tamanhoJanelasExtras = new Dimension(mestre.getWidth() / 2, mestre.getHeight() / 2);
		mensagemRetorno.setPreferredSize(tamanhoJanelasExtras);
		mensagemRetorno.setLocation((int) (mestre.getWidth() * 0.55),(int) (mestre.getHeight() * 0.3));
		mensagemRetorno.add(painel);
		mensagemRetorno.pack();  
		mensagemRetorno.setResizable(false);
		mensagemRetorno.setVisible(true);
	}
}
