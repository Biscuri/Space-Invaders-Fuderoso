package facade;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import util.DataBase;

/**
 * Classe que implementa a Janela principal do Jogo.
 * @author Alberto Junior, Leno Oliveira, Lucas do Carmo
 */
@SuppressWarnings("serial")
public class Janela extends JFrame {
	int tamanhoX;
	int tamanhoY;
	protected DataBase dataBase;
	protected Menu menu;
	protected Mundo mundo;
	protected Placar placar;

	public Janela(int resolucao){
		if (resolucao == 1){
			tamanhoX = 860;
			tamanhoY = 640;
		}
		else {
			tamanhoX = 430;
			tamanhoY = 320;
		}
				
		setSize(tamanhoX, tamanhoY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Space Invaders Fuderoso 1.0");
		
		dataBase = new DataBase(resolucao);
		menu = new Menu(this);
		mundo = new Mundo(this, dataBase);
		placar = new Placar(this, dataBase);	
		
	}
        /**
         * Metodo que adiciona o Menu na Tela
         */
	public void menu(){
		this.add(menu);
		setVisible(true);
	}
	/**
         * Metodo que inicia a partida
         */
	public void comeca(){
		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, mundo);
		add(BorderLayout.EAST, placar);

		setVisible(true);
	}	
        /**
         * Metodo que atualiza o Placar
         */
	public void atualizaPlacar() {
		placar.atualiza();
	}
        /**
         * Metodo que atualiza a resolucao
         * @param tipo tipo da resolucao
         */
	public void atualizaResolucao(int tipo){
		dataBase.setTipo(tipo);
		
		if (tipo == 1){
			tamanhoX = 860;
			tamanhoY = 640;
		}
		else {
			tamanhoX = 430;
			tamanhoY = 320;
		}
		setSize(tamanhoX, tamanhoY);
		Dimension tamanhoJanela = new Dimension(tamanhoX, tamanhoY);
		setPreferredSize(tamanhoJanela );

		menu = new Menu(this);
		mundo = new Mundo(this, dataBase);
		placar = new Placar(this, dataBase);
		placar.setDoubleBuffered(true);
	}
	
        /**
         * Metodo que atualiza a dificuldade
         * @param dificuldade dificuldade a ser modificada
         */
	public void atualizaDificuldade(int dificuldade) {
		dataBase.setNivel(dificuldade);
	}   
	/**
         * Metodo que adiciona o Angar e atualiza o placar ao termino das fases.
         */
	public void terminouFase(){
		new Hangar(mundo, dataBase);
		atualizaPlacar();
	}
	/**
         * Metodo que fecha o Jogo.
         */
	public void sair(){
		System.exit(0);
	}

}
