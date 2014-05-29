package controller;

import java.util.ArrayList;
import model.Nave;
import model.Tiro;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *Testes de Unidade para a Nave
 * @author Lucas do Carmo, Leno Oliveira, Alberto Junior
 */
public class NaveTest {
    Nave teste;
    
    
    @Test
    public void TesteNave(){
        teste = new Nave( 1, 0, 0, 50, 50);
        
        assertEquals(1, teste.getTipo());
        
        // Testando os tiros.
        teste.setQtdArmas(1);
        teste.atira();
        assertEquals(1, teste.getTiro().size());
        teste.atira();
        assertEquals(2, teste.getTiro().size());
        teste.atira();
        assertEquals(3, teste.getTiro().size());
       
        teste.setQtdArmas(2);
        teste.setTiros(new ArrayList<Tiro>());
        teste.atira();
        assertEquals(2,teste.getTiro().size());
        teste.atira();
        assertEquals(4, teste.getTiro().size());
        
        teste.setQtdArmas(3);
        teste.setTiros(new ArrayList<Tiro>());
        teste.atira();
        assertEquals(3, teste.getTiro().size());
        teste.atira();
        assertEquals(6, teste.getTiro().size());
        teste.setMoveX(4);
        teste.setMoveY(4);
        teste.moveNave();
        assertNotSame(0, teste.getX());
        assertNotSame(0, teste.getY());
        
        
    }

    
}
