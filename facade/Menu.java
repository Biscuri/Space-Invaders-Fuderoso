package facade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.MenuKeyListener;

public class Menu extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Janela mestre;
	protected MenuKeyListener menuEvento;
	
	protected JButton inicio = new JButton("Comecar");
	protected JButton dificuldade = new JButton("Dificuldade");
	protected JButton resolucao = new JButton("Resolucao");
	protected JButton creditos = new JButton("Creditos");
	protected JButton sair = new JButton("Sair");

	public Menu(Janela mestre){
		this.mestre = mestre;
		menuEvento = new MenuKeyListener(mestre, this);
		
		setSize(this.mestre.getWidth(), this.mestre.getHeight());
		
		// Coloca o foco no painel
		setFocusable(true);

		// coloca o painel como doubleBuffered
		//setDoubleBuffered(true);		
		insereObjetos();
	}
	
	@SuppressWarnings({"static-access" })
	private void insereObjetos(){
		inicio.addActionListener(menuEvento);
		dificuldade.addActionListener(menuEvento);
		resolucao.addActionListener(menuEvento);
		creditos.addActionListener(menuEvento);
		sair.addActionListener(menuEvento);
		
		BorderLayout bl = new BorderLayout();
		JPanel gl1 = new JPanel(new GridLayout(5,1));
		JPanel gl2 = new JPanel(new GridLayout(1,3));
		
		gl1.add(inicio);
		gl1.add(dificuldade);
		gl1.add(resolucao);
		gl1.add(creditos);
		gl1.add(sair);
		
		gl2.add(new JPanel()).setBackground(Color.BLACK);
		gl2.add(gl1);
		gl2.add(new JPanel()).setBackground(Color.BLACK);
		
		this.setLayout(bl);
		this.add(bl.CENTER, new JPanel(new GridLayout(5,1))).setBackground(Color.BLACK);
		this.add(bl.SOUTH, gl2);
	}

	public void dificuldade(){
		new MenuDificuldade(mestre);
	}
	
	public void resolucao(){
		new MenuResolucao(mestre);
	}
	
	public void creditos(){
		new MenuCreditos(mestre);
	}
	
}
