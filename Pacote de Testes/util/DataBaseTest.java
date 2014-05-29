package util;
import java.util.ArrayList;
import model.Alien;
import model.Nave;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.DataBase;

/**
 *
 * @author Keader
 */
public class DataBaseTest {
    
    DataBase nova;
    
    @Before
    public void setUp() {
        nova = new DataBase(1);
    }
    
    @Test
    public void TesteDatabase(){
        // Gerando Alien , verificando se todos foram inseridos na lista e fazendo um teste para ver se o que foi adicionado
        // e realmente do tipo Alien
       ArrayList<Alien> novo = nova.geradorDeAliens(550, 550);
       Alien teste;
       assertEquals(18, novo.size());
       for(int i =0;i<18;i++){
           teste = (Alien) novo.get(i);
           assertNotSame(-1,novo.indexOf(teste));
       }
       Nave nave = new Nave( 1, 0, 0, 50, 50);
       nova.setNave(nave);
       assertSame(1, nova.getNave().getQtdArmas());
       nova.comprar("Arma");
       assertSame(2, nova.getNave().getQtdArmas());
       nova.comprar("Arma");
       assertSame(3, nova.getNave().getQtdArmas());
       nova.comprar("Arma");
       assertNotSame(4, nova.getNave().getQtdArmas());
       nova.comprar("Vida");
       assertSame(2, nova.getVidas());
       assertSame(1, nova.getNave().getForcaTiro());
       nova.comprar("Tiro");
       assertSame(2, nova.getNave().getForcaTiro());
       nova.comprar("Tiro");
       assertSame(3, nova.getNave().getForcaTiro());
       nova.comprar("Tiro");
       assertSame(4, nova.getNave().getForcaTiro());
       nova.comprar("Tiro");
       assertNotSame(5, nova.getNave().getForcaTiro());
       
       
       
       
       
        
    }

}
