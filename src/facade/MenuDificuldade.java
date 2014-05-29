package facade;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.MenuRadioBoxListener;
/**
 * Classe do Menu de Dificuldades do Jogo.
 * @author Alberto Junior, Lucas do Carmo, Leno Oliveira.
 */
public class MenuDificuldade extends JDialog {
	
	private static final long serialVersionUID = 1L;

	public MenuDificuldade(final Janela mestre) {
		final JDialog mensagemRetorno = new JDialog();
		JPanel painel = new JPanel(new GridLayout(15, 1));

		final JRadioButton r1 = new JRadioButton("NOOB", true);
		final JRadioButton r2 = new JRadioButton("NORMAL", false);
		final JRadioButton r3 = new JRadioButton("HARD", false);
		final JRadioButton r4 = new JRadioButton("NIGHTMARE", false);

		MenuRadioBoxListener radioEvento = new MenuRadioBoxListener(r1, r2, r3,	r4);

		r1.setName("e1");
		r2.setName("e2");
		r3.setName("e3");
		r4.setName("e4");

		r1.addActionListener(radioEvento);
		r2.addActionListener(radioEvento);
		r3.addActionListener(radioEvento);
		r4.addActionListener(radioEvento);

		JButton confirma = new JButton ("Confirmar");

		painel.add(new JLabel("Escolha seu Destino"));
		painel.add(r1);
		painel.add(r2);
		painel.add(r3);
		painel.add(r4);
		painel.add(new JLabel(""));
		painel.add(new JLabel(""));
		painel.add(new JLabel(""));
		painel.add(new JLabel(""));
		painel.add(new JLabel(""));
		painel.add(new JLabel(""));
		painel.add(new JLabel(""));
		painel.add(new JLabel(""));
		painel.add(new JLabel(""));
		
		confirma.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(r1.isSelected()){
					mestre.atualizaDificuldade(1);
				}
				else if(r2.isSelected()) {
					mestre.atualizaDificuldade(2);
				}				
				else if(r3.isSelected()) {
					mestre.atualizaDificuldade(3);
				}				
				else {
					mestre.atualizaDificuldade(4);
				}
                                mensagemRetorno.dispose();
                               
			}
                        
                        
			
		});
		
		painel.add(confirma);
				
		mensagemRetorno.add(painel);
		
		Dimension tamanhoJanelasExtras = new Dimension(mestre.getWidth() / 2, mestre.getHeight() / 2);
		mensagemRetorno.setPreferredSize(tamanhoJanelasExtras);
		mensagemRetorno.setLocation((int) (mestre.getWidth() * 0.55), (int)(mestre.getHeight() * 0.3));
		mensagemRetorno.pack();
		mensagemRetorno.setModal(true);
		mensagemRetorno.setResizable(false);
		mensagemRetorno.setVisible(true);
	}
}
