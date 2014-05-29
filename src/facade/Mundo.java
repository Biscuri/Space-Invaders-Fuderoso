package facade;

import controller.MundoKeyListenerAdapter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Alien;
import model.Nave;
import model.Tiro;
import util.Colidivel;
import util.DataBase;

/**
 * Classe responsavel por todo o controle do jogo. Toda a parte visual do Jogo e pintada no Mundo.
 * @author Alberto Junior, Leno Oliveira, Lucas do Carmo.
 */
public class Mundo extends JPanel {
	
	private static final long serialVersionUID = 1L;

	protected Timer tempo;
	protected DataBase dataBase;
	private Nave nave;
	private ArrayList<Alien> aliens;
	private MundoKeyListenerAdapter mundoEvento;
	private Janela mestre;
	
	private Image bg = new ImageIcon("imagens/bg.jpg").getImage();
	private int bgY = 0;
	
	/**
	 * 
	 * @param mestre
	 *            pega referencia de sua janela mestre ou root
	 * @param dataBase
	 *            pega o database do jogo
	 */
	public Mundo(Janela mestre, DataBase dataBase) {
		this.dataBase = dataBase;
		this.mestre = mestre;
		aliens = new ArrayList<Alien>();
	
		//metodo que constroi a nave
		criaNave(false);
		
		// Coloca o foco no painel
		setFocusable(true);
		
		// coloca o painel como doubleBuffered
		setDoubleBuffered(true);
		
		// Metodo que define os ouvintes de eventos do Mundo
		ouvintesDoMundo();

		// Metodo que coloca os aliens na tela
		distribuirAliens();
	}

	private void defineTamanho(){
		Dimension tamanhoJanela = new Dimension(mestre.getWidth() - (int) (mestre.getWidth()*0.25), mestre.getHeight());
		setSize(tamanhoJanela);
		setPreferredSize(tamanhoJanela);
		setMinimumSize(tamanhoJanela);
		setMaximumSize(tamanhoJanela);
	}
        
        public void gameOver(){
            tempo.stop();
            JOptionPane.showMessageDialog(null, "Fim de Jogo Noob", "Game Over", JOptionPane.ERROR_MESSAGE);
            mestre.dispose();
            Janela novogame = new Janela(dataBase.getTipo());
            novogame.menu();
        }
	
	private void criaNave(boolean existAntiga){
		defineTamanho();
		
		// Verifica o tipo dos sprites
		if (dataBase.getTipo() == 1) {
			nave = new Nave(dataBase.getTipo(), this.getWidth() / 2, this.getHeight() - 100, this.getWidth(), this.getHeight());
			nave.setY((int)(this.getHeight() - ((int) nave.getTamanhoY()*1.5)));
		} 
		else {
			nave = new Nave(dataBase.getTipo(), this.getWidth() / 2, this.getHeight() - 55, this.getWidth(), this.getHeight());
			nave.setY((int)(this.getHeight() - ((int) nave.getTamanhoY()*2.3)));
		}
                // Se existia alguma nave antiga, pega os atributos da antiga
                if(existAntiga){
		Nave antiga = dataBase.getNave();
                nave.setArmas(antiga.getQtdArmas());
                nave.setForcaTiro(antiga.getForcaTiro());
                }
                
		// Atribuindo a nave ao dataBase
		dataBase.setNave(nave);
	}

	private void ouvintesDoMundo(){
		// Cria ouvidor de eventos do mundo
		mundoEvento = new MundoKeyListenerAdapter(nave, this, mestre);
		
		// inicia o timer q fica escutando a cada evento e espera 5mls para iniciar o proximo evento
		tempo = new Timer(5, mundoEvento);		

		// adciona o KeyListener para capturar os eventos do teclado
		if(getKeyListeners().length == 0){
			addKeyListener(mundoEvento);
		}
		else{
			removeKeyListener(getKeyListeners()[0]);
			addKeyListener(mundoEvento);
		}
		
	}
	
	public void distribuirAliens() {
		aliens = dataBase.geradorDeAliens(getWidth(), getHeight());
		tempo.start();
	}
        // Metodo que pinta os Aliens / tiros na tela
	public void paint(Graphics g) {
		super.paint(g);
                int cont = 0;
				
		Graphics2D g2d = (Graphics2D) g;

		// desenha background
		g.drawImage(bg, ((nave.getX()/4)*-1) - 80, bgY - 922, null);

		// movimento do bg
		if(bgY >= 922){
			bgY = 0;
		}
		else {
			bgY++;
		}
		
		// desenha a imagem da nave
		g2d.drawImage(nave.getNaveImagem(), nave.getX(), nave.getY(), null);

		// desenha os aliens
		for (int contAliens1 = 0; contAliens1 < aliens.size(); contAliens1++) {
			Alien auxAlien = (Alien) aliens.get(contAliens1);
			g.drawImage(auxAlien.getAlienImagem(), auxAlien.getX(),	auxAlien.getY(), null);
			
			//Chama a IA na hora do paint pros aliens poderem se mexer
			auxAlien.IA(dataBase.getNivel());
		}

		// Aliens atirar
		for (int z = 0; z < aliens.size(); z++) {
			Alien auxAlien = (Alien) aliens.get(z);

			ArrayList<Tiro> tiros2 = auxAlien.getTiros();

			for (int i = 0; i < tiros2.size(); i++) {
				Tiro tiroz = (Tiro) tiros2.get(i);

				tiroz.moveTiro();

				for (int contAliens = 0; contAliens < aliens.size(); contAliens++) {
					// Pergunta se o tiro colidiu com o alien e se o tiro esta ativo
					if (tiroz.colidiu(nave) && tiroz.isAtivo()) {
						// Decrementa a vida do alien baseado na forca do tiro
						dataBase.setVidas(0);

						// Verifica se o alien esta vivo
						if (dataBase.getVidas() == 0) {
                                                    
                                                        ImageIcon naveIcone = new ImageIcon("Imagens/Explosao.gif");
							dataBase.getNave().setNaveImagem(naveIcone.getImage());
							mestre.atualizaPlacar();
                                                        dataBase.delay(this);
                                                        
                                                        
						}

						// O tiro atingiu, entao eh apagado
						tiroz.setAtivo(false);
					}
					
					g2d.setColor(Color.GREEN);
					
					// desenha o tiro pegando
					if(dataBase.getTipo() == 1)
						g2d.draw3DRect(tiroz.getX(), tiroz.getY(), 2, 10, true);
					else
						g2d.draw3DRect(tiroz.getX(), tiroz.getY(), 1, 5, true);
					
					if (!tiroz.isAtivo()) {
						tiros2.remove(tiroz);
					}
				}
			}
		}

		// Nave atirar
		// cria arraylist que pega quantidade de tiro
		ArrayList<Tiro> tiros = nave.getTiro();

		// cria um loop para desenhar todos os tiros
		for (int i = 0; i < tiros.size(); i++) {
			// cria uma instancia de tiro recebendo o objeto do arraylist
			Tiro tiro = (Tiro) tiros.get(i);

			// Colisao
			for (int contAliens = 0; contAliens < aliens.size(); contAliens++) {
				Colidivel alien = aliens.get(contAliens);

				// Pergunta se o tiro colidiu com o alien e se o tiro esta ativo
				if (tiro.colidiu(alien) && tiro.isAtivo()) {
					// Decrementa a vida do alien baseado na forca do tiro
					((Alien) alien).setVidaAtual(-nave.getForcaTiro());

					// Verifica se o alien esta vivo
					if (!((Alien) alien).estaVivo()) {
						dataBase.setPontuacao(((Alien) alien).getPontuacao());
						aliens.remove(alien);
						mestre.atualizaPlacar();
					}

					// O tiro atingiu, entao eh apagado
					tiro.setAtivo(false);
				}
			}

			// define a cor para o tiro
			g2d.setColor(nave.getCorTiro());

			// desenha o tiro da nave
			if(dataBase.getTipo() == 1)
				g2d.draw3DRect(tiro.getX(), tiro.getY(), 2, 10, true);
			else
				g2d.draw3DRect(tiro.getX(), tiro.getY(), 1, 5, true);
		}

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
		// Se nao existe mais Aliens e o tempo esta funcionando ainda , para o tempo  e faz a nova fase
		if(aliens.isEmpty() && tempo.isRunning()){
                        
			tempo.stop();
			mestre.terminouFase();
			dataBase.incrementaDias();
			criaNave(true);
			ouvintesDoMundo();
			distribuirAliens();
                        
		}
	}

	public void tempo(boolean b) {
		if(!b){
			tempo.stop();
		}
		else{
			tempo.start();
		}
	}
        /**
         * Metodo que retorna a database
         * @deprecated Utilizado apenas pra HU3ragem
         * @return database
         */

    public DataBase getDataBase() {
        return dataBase;
    }
        
        
        
}
