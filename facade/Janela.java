package facade;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import util.DataBase;

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
		terminouFase();
	}

	public void menu(){
		this.add(menu);
		setVisible(true);
	}
	
	public void comeca(){
		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, mundo);
		add(BorderLayout.EAST, placar);
		setVisible(true);
	}	

	public void atualizaPlacar() {
		placar.atualiza();
	}

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
	}
	

	public void atualizaDificuldade(int dificuldade) {
		dataBase.setNivel(dificuldade);
	}
	
	public void terminouFase(){
		new Hangar(mundo, dataBase);
		dataBase.incrementaDias();
	}
	
	public void sair(){
		System.exit(0);
	}

}
