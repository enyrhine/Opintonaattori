package com.opintonaattori.tiedosto;

import com.opintonaattori.logiikka.Kurssisuoritus;
import java.io.File;
import java.io.FileWriter;

/**
 * Luokka tarjoaa tiedoston tallennukseen tarvittavia metodeja.
 */
public class Tallentaja {

    private File kayttajanTiedosto;
    

    public Tallentaja(File kayttaja) {
        this.kayttajanTiedosto = kayttaja;
     

    }

    /**
     * Metodi lisää käyttäjälle uuden kurssisuorituksen.
     *
     * @param kurssi Käyttäjän antama kurssisuoritus
     *
     */
    public void lisaaKurssisuoritus(Kurssisuoritus kurssi) {
        try (FileWriter uusiKirjoittaja = new FileWriter(this.kayttajanTiedosto, true)) {
            uusiKirjoittaja.write(kurssi.getKurssisuoritus() + "\n");
            uusiKirjoittaja.close();
        } catch (Exception e) {
            System.out.println("Virhe tiedostoon kirjoittamisessa: " + e.getMessage());
        }
    }
    
    
}
