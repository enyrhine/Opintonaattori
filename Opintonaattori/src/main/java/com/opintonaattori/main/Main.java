package com.opintonaattori.main;

import com.opintonaattori.logiikka.Kayttaja;
import com.opintonaattori.kayttoliittyma.Kayttoliittyma;
import com.opintonaattori.tiedosto.Tallentaja;
import java.io.IOException;
import javax.swing.SwingUtilities;

/**
 * Ohjelman käyttöliittymän luomiseen.
 */
public class Main {

    /**
     * Luokka hallitsee ohjelmaa, luo käyttöliittymän ja näyttää sen käyttäjälle.
     *
     * @param args taulukko
     * @throws java.io.IOException ei käsittele exceptionia
     *
     */
    public static void main(String[] args) throws IOException {
        Kayttaja uusiKayttaja = new Kayttaja("Kurssini");
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(uusiKayttaja.getTiedosto(), uusiKayttaja);
        SwingUtilities.invokeLater(kayttoliittyma);
    }

}
