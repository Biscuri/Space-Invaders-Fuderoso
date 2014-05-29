package facade;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.Alien;
import model.Nave;
import model.Tiro;
import util.Colidivel;
import util.DataBase;
import controller.MundoKeyListenerAdapter;

public class Mundo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Timer tempo;
	protected DataBase dataBase;
	private Nave nave;
	private ArrayList<Colidivel> aliens;
	private MundoKeyListenerAdapter mundoEvento;
	private Janela mestre;

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
		aliens = new ArrayList<Colidivel>();

		Dimension tamanhoJanela = new Dimension(mestre.getWidth() - (mestre.getWidth() / 4), mestre.getHeight());
		setSize(tamanhoJanela);
		setPreferredSize(tamanhoJanela);

		// Verifica o tipo dos sprites
		if (dataBase.getTipo() == 1) {
			nave = new Nave(dataBase.getTipo(), this.getWidth() - 50*mestre.uy, this.getHeight() - 80*mestre.ux, this.getWidth(), this.getHeight());
		} 
		else {
			nave = new Nave(dataBase.getTipo(), this.getWidth() / 2, this.getHeight() - 55, this.getWidth(), this.getHeight());
		}

		// Cria ouvidor de eventos do mundo
		mundoEvento = new MundoKeyListenerAdapter(nave, this, mestre);

		// adciona o KeyListener para capturar os eventos do teclado
		addKeyListener(mundoEvento);

		// Coloca o foco no painel
		setFocusable(true);

		// Selecionando cor de fundo
		setBackground(Color.BLACK);

		// coloca o painel como doubleBuffered
		setDoubleBuffered(true);

		// Método que coloca os aliens na tela
		distribuirAliens();
		
		// Atribuindo a nave ao dataBase
		dataBase.setNave(nave);

		// inicia o timer q fica escutando a cada evento e espera 5mls para
		// iniciar o proximo evento
		tempo = new Timer(5, mundoEvento);
		tempo.start();
	}

	private void distribuirAliens() {
		aliens = dataBase.geradorDeAliens(getWidth(), getHeight());
	}

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;

		// desenha a imagem da nave
		g2d.drawImage(nave.getNaveImagem(), nave.getX(), nave.getY(), null);

		// desenha os aliens
		for (int contAliens1 = 0; contAliens1 < aliens.size(); contAliens1++) {

			Alien auxAlien = (Alien) aliens.get(contAliens1);

			g.drawImage(auxAlien.getAlienImagem(), auxAlien.getX(),	auxAlien.getY(), null);
			
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
					// Pergunta se o tiro colidiu com o alien e se o tiro estï¿½
					// ativo
					if (tiroz.colidiu(nave) && tiroz.isAtivo()) {
						// Decrementa a vida do alien baseado na forï¿½a do tiro
						dataBase.setVidas(0);

						// Verifica se o alien estï¿½ vivo
						if (dataBase.getVidas() == 0) {
							System.out.println("Perdeu champiz");
							mestre.atualizaPlacar();
						}

						// O tiro atingiu, entï¿½o ï¿½ apagado
						tiroz.setAtivo(false);
					}
					g2d.setColor(Color.GREEN);
					g2d.draw3DRect(tiroz.getX(), tiroz.getY(), 2, 10, true);

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

			// Colisï¿½o
			for (int contAliens = 0; contAliens < aliens.size(); contAliens++) {
				Colidivel alien = aliens.get(contAliens);

				// Pergunta se o tiro colidiu com o alien e se o tiro estï¿½
				// ativo
				if (tiro.colidiu(alien) && tiro.isAtivo()) {
					// Decrementa a vida do alien baseado na forï¿½a do tiro
					((Alien) alien).setVidaAtual(-nave.getForcaTiro());

					// Verifica se o alien estï¿½ vivo
					if (!((Alien) alien).estaVivo()) {
						dataBase.setPontuacao(((Alien) alien).getPontuacao());
						aliens.remove(alien);
						mestre.atualizaPlacar();
					}

					// O tiro atingiu, entï¿½o ï¿½ apagado
					tiro.setAtivo(false);
				}
			}

			// define a cor para o tiro
			if (nave.getForcaTiro() == 1) {
				g2d.setColor(Color.GREEN);
			} 
			else if (nave.getForcaTiro() == 2) {
				g2d.setColor(Color.YELLOW);
			} 
			else if (nave.getForcaTiro() == 3) {
				g2d.setColor(Color.ORANGE);
			} 
			else if (nave.getForcaTiro() == 4) {
				g2d.setColor(Color.RED);
			}

			// denha o tiro pegando
			g2d.draw3DRect(tiro.getX(), tiro.getY(), 2, 10, true);

		}

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
}
