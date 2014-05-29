package controller;

import model.Tiro;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Teste de Unidade para os tiros.
 * @author Lucas do Carmo, Alberto Junior, Leno Oliveira
 */
public class TiroTest {
    Tiro novo;
    
    @Before
    public void setUp() {
        novo = new Tiro(0, 0, 550, 550, 1);
        // (int x, int y, int limX, int limY, int direcao){
    }
    
    @Test
    public void TesteClasse(){
        
        assertSame(0, novo.getY());
        novo.moveTiro();
        assertNotSame(0, novo.getY());
        novo.setY(-2);
        assertFalse(novo.isAtivo());
        novo.setAtivo(true);
        // Fazendo ele sair da tela para verificar se ele está ficando "inativo"
        novo.setY(-549);
        novo.moveTiro();
        assertFalse(novo.isAtivo());
        
    }
    

}
