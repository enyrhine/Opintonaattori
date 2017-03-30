package com.opintonaattori.tiedosto;

import com.opintonaattori.main.Kurssisuoritus;
import java.io.File;
import java.io.FileWriter;

public class Tallentaja {

    private FileWriter kirjoittaja;
    private File kayttajanTiedosto;

    public Tallentaja(File kayttaja) {
        try {
            this.kirjoittaja = new FileWriter(kayttaja);
        } catch (Exception e) {
            System.out.println("Virhe!!" + e.getMessage());
        }
        this.kayttajanTiedosto = kayttaja;

    }

    public void kirjoitaTiedostoon(String teksti) {
        try {
            this.kirjoittaja.write(teksti);
            this.kirjoittaja.close();
        } catch (Exception e) {
            System.out.println("Virhe tiedostoon kirjoittamisessa: " + e.getMessage());
        }
        
    }

    public void lisaaKurssisuoritus(Kurssisuoritus kurssi) {
        try (FileWriter uusiKirjoittaja = new FileWriter(this.kayttajanTiedosto, true)) {
            uusiKirjoittaja.write(kurssi.getKurssisuoritus() + "\n");
            uusiKirjoittaja.close();
        } catch (Exception e) {
            System.out.println("Virhe tiedostoon kirjoittamisessa: " + e.getMessage());
        }
    }
    
    
}
