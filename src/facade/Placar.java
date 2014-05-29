package facade;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.DataBase;
/**
 * Classe que implementa a Tela de Placar do Jogo
 * @author Alberto Junior, Lucas do Carmo, Leno Oliveira.
 */
public class Placar extends JPanel {

	private static final long serialVersionUID = 1L;

	protected DataBase base;
	private JLabel nome;
	private JLabel pontuacao;
	private JLabel dias;
	private JLabel vidas;
	private JFrame mestre;

	public Placar(JFrame mestre, DataBase base){
		this.base = base;
		this.mestre = mestre;
		pontuacao = new JLabel(Integer.toString(base.getPontuacao()));
		dias = new JLabel(Integer.toString(base.getDias()));
		vidas = new JLabel(Integer.toString(base.getVidas()));
		nome = new JLabel(this.base.getNomeJogador());
		
		//Setando o tamanho do placar
		defineTamanho();

		//Setando Layout
		setLayout(new GridLayout(20,1));
		
		add(new JLabel("Piloto: "));
		add(nome);
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
		defineTamanho();
		nome.setText(base.getNomeJogador());
		pontuacao.setText(Integer.toString(base.getPontuacao()));
		dias.setText(Integer.toString(base.getDias()));
		vidas.setText(Integer.toString(base.getVidas()));
	}
	
	private void defineTamanho(){
		setSize(mestre.getWidth() - (int)(mestre.getWidth() * 0.75), mestre.getHeight());
		Dimension preferredSize = new Dimension(mestre.getWidth() - (int)(mestre.getWidth() * 0.75), mestre.getHeight());
		setPreferredSize(preferredSize);
		setMaximumSize(preferredSize);
		setMinimumSize(preferredSize);
	}
}
