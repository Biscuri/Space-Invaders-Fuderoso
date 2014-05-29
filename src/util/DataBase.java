package util;

import facade.Mundo;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Alien;
import model.Nave;
/**
 * Classe que funciona como a central de dados (database) do jogo.
 * @author Leno Oliveira, Alberto Junior, Lucas do Carmo.
 */
public class DataBase {
	private int tipo;
	private int pontuacao;
	private int vidas;
	private int nivel;
	private int dias;
	private String nomeJogador;
	
	private int[] loja; 
	
	private Nave nave;
	private AlienBuilder gerador;
	
	public DataBase(int tipo){
		this.tipo = tipo;
		pontuacao = 0;
		vidas = 1;
		nivel = 1;
		dias = 1;
		nomeJogador = "Astrogildo";
		loja();
                
	}
	
	public DataBase(String nomeJogador, int tipo){
		this.tipo = tipo;
		this.nomeJogador = nomeJogador;
		nivel = 1;
		pontuacao = 0;
		vidas = 1;
		dias = 1;
		loja();
	}
		
	public DataBase(int nivel, String nomeJogador, int tipo){
		this.tipo = tipo;
		this.nomeJogador = nomeJogador;
		this.nivel = nivel;
		pontuacao = 0;
		vidas = 1;
		dias = 1;
		loja();
	}

	//Chama padrao de criacao Builder
	public ArrayList<Alien> geradorDeAliens(int limX,int limY){
		gerador =new AlienBuilder(this, limX, limY);
		return gerador.gerarAliens();
	}
	
	//Metodo de definir valores da loja
	private void loja(){
		loja = new int[4];
		
		//nome
		loja[0] = 1800;
		
		//vida
		loja[1] = 3200;
		
		//arma
		loja[2] = 6300;
		
		//forca tiro
		loja[3] = 7600;	
	}
	
	//Metodo de comprar os produtos da loja
	public void comprar(String func){
		if(func.equals("Nome")){
			pontuacao -= loja[0];
		}
		else if(func.equals("Vida")){
			vidas++;
			pontuacao -= loja[1];
		}
		else if(func.equals("Arma")){
                        if(nave.getQtdArmas()<3){
			nave.setQtdArmas(+1);
                        pontuacao -= loja[2];
                        }
                        else{
                         JOptionPane.showMessageDialog(null, "Upgrade Nao Realizado", "Nao e possivel comprar mais armas", JOptionPane.ERROR_MESSAGE);
                        }
			
		}
		else if(func.equals("Tiro")){
                        if(nave.getForcaTiro()<4){
			nave.incrementaForcaTiro(+1);
			pontuacao -= loja[3];
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Upgrade Nao Realizado", "Perdao camarada, ja ta querendo apelar", JOptionPane.ERROR_MESSAGE);
                        }
		}		
	}
	
	//Metodo de atualizar o dia(Stage)
	public void incrementaDias(){
		dias++;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}

	/**
	 * Incrementa a pontuacao atual com o valor que for recebido como paremetro
	 * @param pontuacao
	 */
	public void setPontuacao(int pontuacao) {
		this.pontuacao += pontuacao;
	}

        public void delay(Mundo mundao){
            final Mundo novo = mundao;
            final Timer delay = new Timer();
            delay.schedule(new TimerTask(){

                @Override
                public void run() {
                    novo.gameOver();
                    delay.cancel();
                }
                
            }, 1*300);
        }
        
          public void delay(final ArrayList<Alien> aliens, final Alien alien){
            
            final Timer delay = new Timer();
            delay.schedule(new TimerTask(){

                @Override
                public void run() {
                    aliens.remove(alien);
                    delay.cancel();
                }
                
            }, 1*1000);
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

	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}
	
	public int getLoja(int i){
		return loja[i-1];
	}
        /**
         * Metodo que adiciona a explosao na nave.
        */
        public void naveDown(){
            ImageIcon naveIcone = new ImageIcon("Imagens/Explosao.gif");
            nave.setNaveImagem(naveIcone.getImage());
        }
        
}
