package facade;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuCreditos extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuCreditos(JFrame mestre) {
		JDialog mensagemRetorno = new JDialog();
		JPanel painel = new JPanel(new GridLayout(15,1));
		
		painel.add(new JLabel(" A muito, muito tempo, em uma galáxia muito distante."));
		painel.add(new JLabel(" A humanidade viu seus dias chegarem ao fim! mas nem tudo estava"));
		painel.add(new JLabel(" perdido. Apareceu aquele! o mestre, o grande, o poderoso, o fuderoso!"));
		painel.add(new JLabel(" "));
		painel.add(new JLabel(" \" -EU!... Sim, EU!... Não você(eu), EU! EU POHA! \" "));
		painel.add(new JLabel(" OOoooooOoOooo Chapolin Colorado"));
		painel.add(new JLabel(" "));
		painel.add(new JLabel(" \" - Não contavam com minha astúcia \" "));
		painel.add(new JLabel(" "));

		painel.add(new JLabel(" |---------------------------|"));
		painel.add(new JLabel(" |  Alberto Junior       |"));
		painel.add(new JLabel(" |  Leno Oliveira         |"));
		painel.add(new JLabel(" |  Lucas Carmo        |"));
		painel.add(new JLabel(" |---------------------------|"));
				
		Dimension tamanhoJanelasExtras = new Dimension(mestre.getWidth() / 2, mestre.getHeight() / 2);
		mensagemRetorno.setPreferredSize(tamanhoJanelasExtras);
		mensagemRetorno.setLocation((int) (mestre.getWidth() * 0.55),(int) (mestre.getHeight() * 0.3));
		mensagemRetorno.add(painel);
		mensagemRetorno.pack();  
		mensagemRetorno.setResizable(false);
		mensagemRetorno.setVisible(true);
	}
}
