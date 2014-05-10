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

public class MenuResolucao extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuResolucao(final Janela mestre) {
		final JDialog mensagemRetorno = new JDialog();
		JPanel painel = new JPanel(new GridLayout(15,1));
		
		final JRadioButton r1 =  new JRadioButton("860x640", true);
		final JRadioButton r2 =  new JRadioButton("350x420", false);
		
		MenuRadioBoxListener radioEvento = new MenuRadioBoxListener(r1, r2);
		
		r1.setName("e1");
		r2.setName("e2");
		
		r1.addActionListener(radioEvento);
		r2.addActionListener(radioEvento);
		
		JButton confirma = new JButton ("Confirmar");

		painel.add(new JLabel("Resolução"));
		painel.add(r1);
		painel.add(r2);
		painel.add(new JLabel(""));
		painel.add(new JLabel(""));
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
					mestre.atualizaResolucao(1);
				}
				else {
					mestre.atualizaResolucao(2);
				}
				mensagemRetorno.dispose();
			}
			
		});
		
		painel.add(confirma);
		
		mensagemRetorno.add(painel);
		
		Dimension tamanhoJanelasExtras = new Dimension(mestre.getWidth() / 2, mestre.getHeight() / 2);
		mensagemRetorno.setPreferredSize(tamanhoJanelasExtras);
		mensagemRetorno.setLocation((int) (mestre.getWidth() * 0.55),(int) (mestre.getHeight() * 0.3));
		mensagemRetorno.pack();  
		mensagemRetorno.setModal(true);
		mensagemRetorno.setResizable(false);
		mensagemRetorno.setVisible(true);
	}
	
}
