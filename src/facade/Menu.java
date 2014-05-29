package facade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.MenuKeyListener;
import java.awt.Container;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * Classe que cria o Menu do Jogo
 * @author Lucas do Carmo, Alberto Junior, Leno Oliveira.
 */
@SuppressWarnings("serial")
public class Menu extends JPanel {
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
               
                 Icon icon= new ImageIcon("Imagens/bg1.png");
                
              
		JLabel img = new JLabel(icon, JLabel.CENTER);
                img.setIcon(icon);
		this.setLayout(bl);
		//this.add(bl.CENTER, new JPanel(new GridLayout(5,1))).setBackground(Color.BLACK);
                this.add(img, BorderLayout.CENTER);
		this.add(bl.SOUTH, gl2);
	}
        /**
         * Metodo que cria o Menu de dificuldade
         */
	public void dificuldade(){
		new MenuDificuldade(mestre);
	}
	/**
         * Metodo que cria o Menu de resolucao
         */
	public void resolucao(){
		new MenuResolucao(mestre);
	}
	/**
         * Metodo que abre os Creditos do Programa
         */
	public void creditos(){
		new MenuCreditos(mestre);
	}
	
}
