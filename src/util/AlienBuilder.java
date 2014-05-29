package util;

import java.util.ArrayList;

import model.Alien;
/**
 * Classe construtora de Aliens.
 * @author Alberto Manoel, Leno Oliveira, Lucas do Carmo
 * Caso seja necessario em possiveis mudancas no codigo , fazer heranca deste construtor
 * sobrescrevendo os metodos desejados.
 */

public class AlienBuilder {
	private final DataBase dataBase;
	private final int limX;
	private final int limY;
	
	public AlienBuilder(DataBase dataBase, int limX, int limY){
		this.dataBase = dataBase;
		this.limX = limX;
		this.limY = limY;
	}
	
	public ArrayList<Alien> gerarAliens(){
		ArrayList<Alien> aliens;
		
		if(dataBase.getDias() == 1)
			aliens = criarStage1();
		else if(dataBase.getDias() == 2)
			aliens = criarStage2();
		else if(dataBase.getDias() == 3)
			aliens = criarStage3();
		else if(dataBase.getDias() == 4)
			aliens = criarStage4();
		else if(dataBase.getDias() == 5)
			aliens = criarStage5();
		else if(dataBase.getDias() == 6)
			aliens = criarStage6();
		else if(dataBase.getDias() == 7)
			aliens = criarStage7();
		else if(dataBase.getDias() == 8)
			aliens = criarStage8();
		else if(dataBase.getDias() == 9)
			aliens = criarStage9();
		else if(dataBase.getDias() == 10)
			aliens = criarStage10();
		else if(dataBase.getDias() == 11)
			aliens = criarStage11();
		else
			aliens = criarStage12();
		
		return aliens;
	}
	
	//vida 1, velocidade tiro 1
	private ArrayList<Alien> criarStage1(){
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		
		int x = 0;
		int y = 0;
				
		for (int i = 0; i < 18; i++){
			Alien auxAlien = new Alien(dataBase.getTipo(), 1, 1, x, y*30, limX, limY);
			
			auxAlien.setX((x*auxAlien.getTamanhoX()) + x*5);
			auxAlien.setY((y*auxAlien.getTamanhoY()) + (y+1)*5);

			aliens.add(auxAlien);			
			
			if(y==0){
				auxAlien.setBrodinhos(new ArrayList<Alien>());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			else {
				auxAlien.setBrodinhos(((Alien) aliens.get(i - 6)).getBrodinhos());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			
			x++;

			if(x == 6){
				y++;
				x = 0;
			}
		}
		
		return aliens;
	}

	//vida 2, velocidade tiro 1
	private ArrayList<Alien> criarStage2(){
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		
		int x = 0;
		int y = 0;
				
		for (int i = 0; i < 18; i++){
			Alien auxAlien;
			if(y%2 == 0){
				auxAlien = new Alien(dataBase.getTipo(), 1, 1, x, y, limX, limY);
				auxAlien.setX((x*auxAlien.getTamanhoX()) + x*4);
				auxAlien.setY((y*auxAlien.getTamanhoY()) + (y+1)*5);
			}
			else {
				auxAlien = new Alien(dataBase.getTipo(), 2, 1, x, y, limX, limY);
				auxAlien.setX(((x*auxAlien.getTamanhoX()) + x*4) - (auxAlien.getTamanhoY()/2));
				auxAlien.setY((y*auxAlien.getTamanhoY()) + (int) (auxAlien.getTamanhoY()*0.4));
			}

			aliens.add(auxAlien);			
			
			if(y==0){
				auxAlien.setBrodinhos(new ArrayList<Alien>());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			else {
				auxAlien.setBrodinhos(((Alien) aliens.get(i - 6)).getBrodinhos());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			
			x++;

			if(x == 6){
				y++;
				x = 0;
			}
		}
		
		return aliens;
                
	}
	
	//vida 3, velocidade tiro 1
	private ArrayList<Alien> criarStage3(){
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		
		int x = 0;
		int y = 0;
				
		for (int i = 0; i < 18; i++){
			Alien auxAlien;
			if(y == 0){
				auxAlien = new Alien(dataBase.getTipo(), 3, 1, x, y, limX, limY);
			}
			else if (y == 1) {
				auxAlien = new Alien(dataBase.getTipo(), 2, 1, x, y, limX, limY);
			}
			else {
				auxAlien = new Alien(dataBase.getTipo(), 1, 1, x, y, limX, limY);
			}
				
			auxAlien.setX((x*auxAlien.getTamanhoX()) + x*8);
			auxAlien.setY((y*auxAlien.getTamanhoY()) + y*6);

			aliens.add(auxAlien);			
			
			if(y==0){
				auxAlien.setBrodinhos(new ArrayList<Alien>());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			else {
				auxAlien.setBrodinhos(((Alien) aliens.get(i - 6)).getBrodinhos());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			
			x++;

			if(x == 6){
				y++;
				x = 0;
			}
		}
		
		return aliens;
	}
	
	//vida 3, velocidade tiro 2
	private ArrayList<Alien> criarStage4(){
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		
		int x = 0;
		int y = 0;
				
		for (int i = 0; i < 18; i++){
			Alien auxAlien;
			
			if(y == 0)
				auxAlien = new Alien(dataBase.getTipo(), 3, 2, x, y, limX, limY);
			else if(y == 1 && x!=0 && x!=5)
				auxAlien = new Alien(dataBase.getTipo(), 3, 2, x, y, limX, limY);
			else if(y == 2 && x!=0 && x!=5 && x!=1 && x!= 4)
				auxAlien = new Alien(dataBase.getTipo(), 3, 2, x, y, limX, limY);
			else
				auxAlien = null;
			
			if(auxAlien != null){
				auxAlien.setX((x*auxAlien.getTamanhoX()) + x*8);
				auxAlien.setY((y*auxAlien.getTamanhoY()) + y*5);
	
				aliens.add(auxAlien);			
				
				if(y==0){
					auxAlien.setBrodinhos(new ArrayList<Alien>());
					auxAlien.getBrodinhos().add(auxAlien);
				}
				else {
					if(y == 1){
						auxAlien.setBrodinhos(((Alien) aliens.get(i - 6)).getBrodinhos());
						auxAlien.getBrodinhos().add(auxAlien);
					}
					else{
						auxAlien.setBrodinhos(((Alien) aliens.get(i - 7)).getBrodinhos());
						auxAlien.getBrodinhos().add(auxAlien);
					}
				}
			}
			
			x++;

			if(x == 6){
				y++;
				x = 0;
			}
		}
		
		return aliens;
	}
	
	//vida 4, velocidade tiro 2
	private ArrayList<Alien> criarStage5(){
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		
		int x = 0;
		int y = 0;
				
		for (int i = 0; i < 18; i++){
			Alien auxAlien;
			if(y == 0){
				auxAlien = new Alien(dataBase.getTipo(), 3, 1, x, y, limX, limY);
			}
			else if (y == 1) {
				auxAlien = new Alien(dataBase.getTipo(), 2, 1, x, y, limX, limY);
			}
			else {
				auxAlien = new Alien(dataBase.getTipo(), 1, 1, x, y, limX, limY);
			}
				
			auxAlien.setX((x*auxAlien.getTamanhoX()) + x*8);
			auxAlien.setY((y*auxAlien.getTamanhoY()) + y*5);

			aliens.add(auxAlien);			
			
			if(y==0){
				auxAlien.setBrodinhos(new ArrayList<Alien>());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			else {
				auxAlien.setBrodinhos(((Alien) aliens.get(i - 6)).getBrodinhos());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			
			x++;

			if(x == 6){
				y++;
				x = 0;
			}
		}
		
		return aliens;
	}
	
	//vida 5, velocidade tiro 2
	private ArrayList<Alien> criarStage6(){
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		
		int x = 0;
		int y = 0;
				
		for (int i = 0; i < 18; i++){
			Alien auxAlien;
			if(y == 0){
				auxAlien = new Alien(dataBase.getTipo(), 3, 1, x, y, limX, limY);
			}
			else if (y == 1) {
				auxAlien = new Alien(dataBase.getTipo(), 2, 1, x, y, limX, limY);
			}
			else {
				auxAlien = new Alien(dataBase.getTipo(), 1, 1, x, y, limX, limY);
			}
				
			auxAlien.setX((x*auxAlien.getTamanhoX()) + x*8);
			auxAlien.setY((y*auxAlien.getTamanhoY()) + y*5);

			aliens.add(auxAlien);			
			
			if(y==0){
				auxAlien.setBrodinhos(new ArrayList<Alien>());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			else {
				auxAlien.setBrodinhos(((Alien) aliens.get(i - 6)).getBrodinhos());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			
			x++;

			if(x == 6){
				y++;
				x = 0;
			}
		}
		
		return aliens;
	}
	
	//vida 5, velocidade tiro 3
	private ArrayList<Alien> criarStage7(){
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		
		int x = 0;
		int y = 0;
				
		for (int i = 0; i < 18; i++){
			Alien auxAlien;
			if(y == 0){
				auxAlien = new Alien(dataBase.getTipo(), 3, 1, x, y, limX, limY);
			}
			else if (y == 1) {
				auxAlien = new Alien(dataBase.getTipo(), 2, 1, x, y, limX, limY);
			}
			else {
				auxAlien = new Alien(dataBase.getTipo(), 1, 1, x, y, limX, limY);
			}
				
			auxAlien.setX((x*auxAlien.getTamanhoX()) + x*8);
			auxAlien.setY((y*auxAlien.getTamanhoY()) + y*5);

			aliens.add(auxAlien);			
			
			if(y==0){
				auxAlien.setBrodinhos(new ArrayList<Alien>());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			else {
				auxAlien.setBrodinhos(((Alien) aliens.get(i - 6)).getBrodinhos());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			
			x++;

			if(x == 6){
				y++;
				x = 0;
			}
		}
		
		return aliens;
	}
	
	//vida 6, velocidade tiro 3
	private ArrayList<Alien> criarStage8(){
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		
		int x = 0;
		int y = 0;
				
		for (int i = 0; i < 18; i++){
			Alien auxAlien;
			if(y == 0){
				auxAlien = new Alien(dataBase.getTipo(), 3, 1, x, y, limX, limY);
			}
			else if (y == 1) {
				auxAlien = new Alien(dataBase.getTipo(), 2, 1, x, y, limX, limY);
			}
			else {
				auxAlien = new Alien(dataBase.getTipo(), 1, 1, x, y, limX, limY);
			}
				
			auxAlien.setX((x*auxAlien.getTamanhoX()) + x*8);
			auxAlien.setY((y*auxAlien.getTamanhoY()) + y*5);

			aliens.add(auxAlien);			
			
			if(y==0){
				auxAlien.setBrodinhos(new ArrayList<Alien>());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			else {
				auxAlien.setBrodinhos(((Alien) aliens.get(i - 6)).getBrodinhos());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			
			x++;

			if(x == 6){
				y++;
				x = 0;
			}
		}
		
		return aliens;
	}
	
	//vida 7, velocidade tiro 3
	private ArrayList<Alien> criarStage9(){
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		
		int x = 0;
		int y = 0;
				
		for (int i = 0; i < 18; i++){
			Alien auxAlien;
			if(y == 0){
				auxAlien = new Alien(dataBase.getTipo(), 3, 1, x, y, limX, limY);
			}
			else if (y == 1) {
				auxAlien = new Alien(dataBase.getTipo(), 2, 1, x, y, limX, limY);
			}
			else {
				auxAlien = new Alien(dataBase.getTipo(), 1, 1, x, y, limX, limY);
			}
				
			auxAlien.setX((x*auxAlien.getTamanhoX()) + x*8);
			auxAlien.setY((y*auxAlien.getTamanhoY()) + y*5);

			aliens.add(auxAlien);			
			
			if(y==0){
				auxAlien.setBrodinhos(new ArrayList<Alien>());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			else {
				auxAlien.setBrodinhos(((Alien) aliens.get(i - 6)).getBrodinhos());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			
			x++;

			if(x == 6){
				y++;
				x = 0;
			}
		}
		
		return aliens;
	}
	
	private ArrayList<Alien> criarStage10(){
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		
		int x = 0;
		int y = 0;
				
		for (int i = 0; i < 18; i++){
			Alien auxAlien;
			if(y == 0){
				auxAlien = new Alien(dataBase.getTipo(), 3, 1, x, y, limX, limY);
			}
			else if (y == 1) {
				auxAlien = new Alien(dataBase.getTipo(), 2, 1, x, y, limX, limY);
			}
			else {
				auxAlien = new Alien(dataBase.getTipo(), 1, 1, x, y, limX, limY);
			}
				
			auxAlien.setX((x*auxAlien.getTamanhoX()) + x*8);
			auxAlien.setY((y*auxAlien.getTamanhoY()) + y*5);

			aliens.add(auxAlien);			
			
			if(y==0){
				auxAlien.setBrodinhos(new ArrayList<Alien>());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			else {
				auxAlien.setBrodinhos(((Alien) aliens.get(i - 6)).getBrodinhos());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			
			x++;

			if(x == 6){
				y++;
				x = 0;
			}
		}
		
		return aliens;
	}
	
	private ArrayList<Alien> criarStage11(){
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		
		int x = 0;
		int y = 0;
				
		for (int i = 0; i < 18; i++){
			Alien auxAlien;
			if(y == 0){
				auxAlien = new Alien(dataBase.getTipo(), 3, 1, x, y, limX, limY);
			}
			else if (y == 1) {
				auxAlien = new Alien(dataBase.getTipo(), 2, 1, x, y, limX, limY);
			}
			else {
				auxAlien = new Alien(dataBase.getTipo(), 1, 1, x, y, limX, limY);
			}
				
			auxAlien.setX((x*auxAlien.getTamanhoX()) + x*8);
			auxAlien.setY((y*auxAlien.getTamanhoY()) + y*5);

			aliens.add(auxAlien);			
			
			if(y==0){
				auxAlien.setBrodinhos(new ArrayList<Alien>());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			else {
				auxAlien.setBrodinhos(((Alien) aliens.get(i - 6)).getBrodinhos());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			
			x++;

			if(x == 6){
				y++;
				x = 0;
			}
		}
		
		return aliens;
	}
	
	private ArrayList<Alien> criarStage12(){
		ArrayList<Alien> aliens = new ArrayList<Alien>();
		
		int x = 0;
		int y = 0;
				
		for (int i = 0; i < 18; i++){
			Alien auxAlien;
			if(y == 0){
				auxAlien = new Alien(dataBase.getTipo(), 3, 1, x, y, limX, limY);
			}
			else if (y == 1) {
				auxAlien = new Alien(dataBase.getTipo(), 2, 1, x, y, limX, limY);
			}
			else {
				auxAlien = new Alien(dataBase.getTipo(), 1, 1, x, y, limX, limY);
			}
				
			auxAlien.setX((x*auxAlien.getTamanhoX()) + x*8);
			auxAlien.setY((y*auxAlien.getTamanhoY()) + y*5);

			aliens.add(auxAlien);			
			
			if(y==0){
				auxAlien.setBrodinhos(new ArrayList<Alien>());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			else {
				auxAlien.setBrodinhos(((Alien) aliens.get(i - 6)).getBrodinhos());
				auxAlien.getBrodinhos().add(auxAlien);
			}
			
			x++;

			if(x == 6){
				y++;
				x = 0;
			}
		}
		
		return aliens;
	}
	
}
