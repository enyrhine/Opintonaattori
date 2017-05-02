
package com.opintonaattori.tiedosto;

import com.opintonaattori.logiikka.Kurssisuoritus;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TallentajaTest {
    private static File tiedosto;
    private Raporttikone raportti;
    
    public TallentajaTest() {
        tiedosto = new File("moi");
        this.raportti = new Raporttikone(tiedosto);
    }
  

//     @Test
//     public void tiedostoonTallennusToimii() {
//         File tiedosto2 = new File("moi");
//         Tallentaja tallentaja = new Tallentaja(this.tiedosto);
//         tallentaja.kirjoitaTiedostoon("Moi");
//         
//         assertEquals(3, tiedosto2.length());
//         tiedosto2.delete();
//     }
//     
//     @Test
//     public void kurssisuorituksenLisaysTallentuu() {
//         File teksti = new File("testi");
//         Tallentaja tallentaja = new Tallentaja(teksti);
//         tallentaja.lisaaKurssisuoritus(new Kurssisuoritus("Ohja", 5, 5));
//         assertEquals("Ohja,5,5", this.raportti.lueKurssisuoritukset());
//         teksti.delete();
//     }
    
    @AfterClass
    public static void tearDown() {
        tiedosto.delete();
        
    }
}
