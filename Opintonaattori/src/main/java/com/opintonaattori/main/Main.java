
package com.opintonaattori.main;

import com.opintonaattori.logiikka.Kayttaja;
import com.opintonaattori.kayttoliittyma.Kayttoliittyma;
import com.opintonaattori.tiedosto.Tallentaja;
import java.io.IOException;
import javax.swing.SwingUtilities;

/**
 * Ohjelman käyttöliittymän testaukseen.
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        Kayttaja elsa = new Kayttaja("Sonja");
        //Tallentaja elsanTallentaja = new Tallentaja(elsa.getTiedosto());
        elsa.lisaaKurssisuoritus("Ohja", 5, 5);
        //System.out.println(elsa.getTiedosto().length());
        elsa.lisaaKurssisuoritus("Ohpe", 5, 5);
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(elsa.getTiedosto(), elsa);
        SwingUtilities.invokeLater(kayttoliittyma);
    }
   
    
}
