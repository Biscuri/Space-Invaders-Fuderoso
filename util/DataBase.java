package util;

import java.util.ArrayList;

import model.Alien;

public class DataBase {
	private int tipo;
	private int pontuacao;
	private int vidas;
	private int nivel;
	private int dias;
	private String nomeJogador;
		
	public DataBase(int tipo){
		this.tipo = tipo;
		pontuacao = 0;
		vidas = 1;
		nivel = 1;
		dias = 1;
		nomeJogador = "Astrogildo";
	}
	
	public DataBase(String nomeJogador, int tipo){
		this.tipo = tipo;
		this.nomeJogador = nomeJogador;
		nivel = 1;
		pontuacao = 0;
		vidas = 1;
		dias = 1;
	}
		
	public DataBase(int nivel, String nomeJogador, int tipo){
		this.tipo = tipo;
		this.nomeJogador = nomeJogador;
		this.nivel = nivel;
		pontuacao = 0;
		vidas = 1;
		dias = 1;
	}

	public ArrayList<Colidivel> geradorDeAliens(int limX,int limY){
		ArrayList<Colidivel> aliens = new ArrayList<Colidivel>();
		
		int x = 0;
		int y = 0;
				
		for (int i = 0; i < 18; i++){
			Alien auxAlien = new Alien(tipo, 5, 3, x, y*30, limX, limY);
			
			auxAlien.setX((x*auxAlien.getTamanhoX()) + x*5);
			auxAlien.setY((y*auxAlien.getTamanhoY()) + y*5);

			aliens.add(auxAlien);			
			
			x++;

			if(x == 6){
				y++;
				x = 0;
			}
		}
		
		return aliens;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}

	/**
	 * Incrementa a pontua��o atual com o valor que for recebido como par�metro
	 * @param pontuacao
	 */
	public void setPontuacao(int pontuacao) {
		this.pontuacao += pontuacao;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}	
	
	public void setTipo(int tipo){
		this.tipo = tipo;
	}
	
	public int getTipo(){
		return tipo;
	}
}
