package util;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class AlbertoButton extends JPanel implements MouseListener {
	private Image imagem;
	private Image[] imagens;
	
	private String funcao;
	private String imagemNome;
	private String diretorio1 = "Imagens";
	private String diretorio2 = "Botoes";
	private String ext = "png";
	
	private int delayClicou;
	private int imgX, imgY;
	private int posX, posY;
	private double mouseX, mouseY;

	private boolean passou, clicou;
	
	private Timer tempoAtualiza;
	
	private MouseEvent mouseEvento;
	
	public AlbertoButton(String funcao, int posX, int posY){
		this.funcao = funcao;
		this.imagemNome = funcao;
		this.posX = posX;
		this.posY = posY;
	
		carregaImagem();
	}
	
	public AlbertoButton(String funcao, int posX, int posY, boolean ativaMouseEvent){
		this.funcao = funcao;
		this.imagemNome = funcao;
		this.posX = posX;
		this.posY = posY;
		
		if(ativaMouseEvent){
			addMouseListener(this);
		}
			
		carregaImagem();
	}

	public AlbertoButton(String funcao, int posX, int posY, boolean ativaMouseEvent, String ext){
		this.funcao = funcao;
		this.imagemNome = funcao;
		this.posX = posX;
		this.posY = posY;
		this.ext = ext;
		
		if(ativaMouseEvent){
			addMouseListener(this);
		}
			
		carregaImagem();
	}
	
	private void carregaImagem(){
		ImageIcon icone;
		
		imagens = new Image[3];
		
		icone = new ImageIcon(diretorio1 + "/" + diretorio2 + "/" + imagemNome + "." + ext);	
		imagens[0] = icone.getImage();
		imagem = imagens[0];

		icone = new ImageIcon(diretorio1 + "/" + diretorio2 + "/" + imagemNome + "_clicou." + ext);	
		imagens[1] = icone.getImage();
		
		icone = new ImageIcon(diretorio1 + "/" + diretorio2 + "/" + imagemNome + "_passou." + ext);	
		imagens[2] = icone.getImage();
			
		imgX = icone.getIconWidth();
		imgY = icone.getIconHeight();
				
		Dimension dm = new Dimension(imgX,imgY);
		setPreferredSize(dm);
		setMinimumSize(dm);
		setMaximumSize(dm);
		
		tempoAtualiza = new Timer(8, new AlbertoMouseKeyListener(this));
		tempoAtualiza.start();
	}
	
	public void paint(Graphics img){
		super.paint(img);

		Graphics2D g2d = (Graphics2D) img;
		
		g2d.drawImage(imagem, posX, posY, null);
		
		Toolkit.getDefaultToolkit().sync();
		img.dispose();
	}
	
	public void verifica(){
		if(clicou){
			if(delayClicou >= 2){
				mouseReleased(mouseEvento);
				delayClicou = 0;
			}
			else
				delayClicou++;
		}
		
		if(passou)
			mouseSaiu();
		else
			mouseEntered(mouseEvento);
	}
	
	public void atualizaMouse(){
		mouseX =  MouseInfo.getPointerInfo().getLocation().getX() - 8;
		mouseY =  MouseInfo.getPointerInfo().getLocation().getY() - 30;
	}

	public int getImgX(){
		return imgX;
	}
	
	public int getImgY(){
		return imgY;
	}
	
	public int getPosX(){
		return posX;
	}
	
	public void setPosX(int posX){
		this.posX = posX;
	}
	
	public int getPosY(){
		return posY;
	}

	public void setPosY(int posY){
		this.posY = posY;
	}
	
	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}
	
	public String getFuncao(){
		return funcao;
	}
	
	public void setFuncao(String funcao){
		this.funcao = funcao;
	}
	
	public String getDiretorio1() {
		return diretorio1;
	}

	public void setDiretorio1(String diretorio1) {
		this.diretorio1 = diretorio1;
	}
	
	public String getDiretorio2() {
		return diretorio2;
	}

	public void setDiretorio2(String diretorio2) {
		this.diretorio2 = diretorio2;
	}

	public void setImagemNome(String imagemNome){
		ImageIcon icone;

		String imagemNomeAux = this.imagemNome;
		
		icone = new ImageIcon(diretorio1 + "/" + diretorio2 + "/" + imagemNome + "." + ext);

		if(icone.getIconWidth() > 0 && icone.getIconHeight() > 0){
			this.imagemNome = imagemNome;
			imagens[0] = icone.getImage();
			imagem = imagens[0];

			icone = new ImageIcon(diretorio1 + "/" + diretorio2 + "/" + imagemNome + "_clicou."  + ext);	
			imagens[1] = icone.getImage();
			
			icone = new ImageIcon(diretorio1 + "/" + diretorio2 + "/" + imagemNome + "_passou."  + ext);	
			imagens[2] = icone.getImage();
			
			imgX = icone.getIconWidth();
			imgY = icone.getIconHeight();	
			setPreferredSize(new Dimension(imgX,imgY));
		}
		else {
			this.imagemNome = imagemNomeAux;
		}
	}

	//TODO MÉTODOS DO MOUSE LISTENER
	//----------------------------------------------------------------------------------------
	
	@Override
	public void mouseClicked(MouseEvent mouse) {
		if(mouseEvento == null)
			mouseEvento = mouse;
		
		if((mouseX >= posX && mouseX <= posX+imgX) && (mouseY >= posY && mouseY <= posY+imgY)){
			clicou = true;
			setImagem(imagens[1]);
			repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent mouse) {
		if(mouseEvento == null)
			mouseEvento = mouse;
		
		if((mouseX >= posX && mouseX <= posX + imgX) && (mouseY >= posY && mouseY <= posY + imgY)){
			passou = true;
			setImagem(imagens[2]);
			repaint();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent mouse) {
		if(mouseEvento == null)
			mouseEvento = mouse;
		
		clicou = false;
		setImagem(imagens[0]);
		repaint();
	}
	
	private void mouseSaiu(){	
		if(!(mouseX >= posX && mouseX <= posX + imgX) && !(mouseY >= posY && mouseY <= posY + imgY)){
			passou = false;
			setImagem(imagens[0]);
			repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent mouse) {}
	@Override
	public void mouseExited(MouseEvent mouse) {}

}

//----------------------------------------------------------------------------------------
class AlbertoMouseKeyListener implements ActionListener {
	private AlbertoButton b;
	private static int i;
	
	public AlbertoMouseKeyListener(AlbertoButton b){
		this.b = b;
		i = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		b.atualizaMouse();
		if(i == 10){
			i = 0;
			b.verifica();
		}
		else {
			i++;
		}
	}
}