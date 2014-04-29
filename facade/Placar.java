package facade;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.DataBase;

public class Placar extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected DataBase base;
	protected JLabel pontuacao;
	protected JLabel dias;
	protected JLabel vidas;

	public Placar(JFrame mestre, DataBase base){
		this.base = base;
		pontuacao = new JLabel(Integer.toString(base.getPontuacao()));
		dias = new JLabel(Integer.toString(base.getDias()));
		vidas = new JLabel(Integer.toString(base.getVidas()));
		
		//Setando o tamanho do placar
		setSize(mestre.getWidth() - (int)(mestre.getWidth() * 0.75), mestre.getHeight());
		Dimension preferredSize = new Dimension(mestre.getWidth() - (int)(mestre.getWidth() * 0.75), mestre.getHeight());
		setPreferredSize(preferredSize );

		//Setando Layout
		setLayout(new GridLayout(20,1));
		
		add(new JLabel("Piloto: "));
		add(new JLabel(base.getNomeJogador()));
		add(new JLabel("--------------------------------------------------"));

		add(new JLabel("Pontuacao: "));
		add(pontuacao);
		add(new JLabel("--------------------------------------------------"));

		add(new JLabel("Dia: "));
		add(dias);
		add(new JLabel("--------------------------------------------------"));

		add(new JLabel("Vidas: "));
		add(vidas);
		add(new JLabel("--------------------------------------------------"));

		// coloca o painel como doubleBuffered
		setDoubleBuffered(true);
	
		setVisible(true);
	}
	
	public void atualiza(){
		pontuacao.setText(Integer.toString(base.getPontuacao()));
		dias.setText(Integer.toString(base.getDias()));
		vidas.setText(Integer.toString(base.getVidas()));
	}
}
