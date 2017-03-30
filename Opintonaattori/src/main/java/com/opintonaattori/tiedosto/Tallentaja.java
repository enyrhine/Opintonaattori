package com.opintonaattori.tiedosto;

import com.opintonaattori.Kurssisuoritus;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Tallentaja {

    private FileWriter kirjoittaja;
    private File kayttajanTiedosto;

    public Tallentaja(File kayttaja) throws IOException {
        this.kirjoittaja = new FileWriter(kayttaja);
        this.kayttajanTiedosto = kayttaja;

    }

    public void kirjoitaTiedostoon(String teksti) throws IOException {
        this.kirjoittaja.write(teksti);
        this.kirjoittaja.close();
    }

    public void lisaaKurssisuoritus(String nimi, int op, int arvosana) throws IOException {
        Kurssisuoritus kurssi = new Kurssisuoritus(nimi, op, arvosana);
        try (FileWriter uusiKirjoittaja = new FileWriter(this.kayttajanTiedosto, true)) {
            uusiKirjoittaja.write(kurssi.getKurssisuoritus() + "\n");
            uusiKirjoittaja.close();
        }
    }
}
