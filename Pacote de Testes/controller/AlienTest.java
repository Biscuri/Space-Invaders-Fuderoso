/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


import model.Alien;



/**
 * Teste de Unidade dos Alien.
 * @author Lucas do Carmo, Alberto Junior, Leno Oliveira
 */
public class AlienTest {
    Alien teste;


    @Before
    public void setUp() {
        teste = new Alien(1, 3, 3, 0, 0 , 550 , 550);   
        // int tipo, int velocidadeAtira, int forca, int posX, int posY, int limX, int limY
		
    }
    
    @Test
    public void TesteAlien(){
        // Movimentação
        teste.IA(1);
        assertNotSame(0, teste.getX());
        assertTrue(teste.estaVivo());
        teste.setVidaAtual(-1);
        assertTrue(teste.estaVivo());
        teste.setVidaAtual(-1);
        assertTrue(teste.estaVivo());
        teste.setVidaAtual(-1);
        assertFalse(teste.estaVivo());
        teste.atiraTest();
        assertEquals(1, teste.getTiros().size());
        teste.atiraTest();
        assertEquals(2, teste.getTiros().size());

    }


}
