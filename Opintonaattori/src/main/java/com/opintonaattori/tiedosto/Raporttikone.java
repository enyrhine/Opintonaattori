package com.opintonaattori.tiedosto;

import com.opintonaattori.logiikka.Kurssisuoritus;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 * Luokka tarjoaa tiedoston lukemiseen tarvittavia metodeja.
 */
public class Raporttikone {

    private File tiedosto;
    private List<Kurssisuoritus> kurssisuoritukset;
    private int tiedostonKoko;

    /**
     * Luokka tiedoston lukemiseen.
     *
     * @param tiedosto antaa raporttikoneelle halutun tiedoston
     *
     */
    public Raporttikone(File tiedosto) {
        this.tiedosto = tiedosto;
        this.kurssisuoritukset = new ArrayList<>();
        this.tiedostonKoko = lueTiedosto().size();

    }

    /**
     * Metodi asettaa tiedostolle uuden koon tiedoston pohjalta rakennetun
     * listan sen hetkisen koon mukaan.
     *
     */
    public void setTiedostonKoko() {
        this.tiedostonKoko = lueTiedosto().size();
    }

    public int getTiedostonKoko() {
        return this.tiedostonKoko;
    }

    /**
     * Metodi lukee tiedoston ja lisää saamansa rivit listaan.
     *
     * @return rivit arraylistinä
     */
    public List<String> lueTiedosto() {
        List<String> tiedostonRivit = new ArrayList<>();
        try {
            tiedostonRivit = FileUtils.readLines(this.tiedosto, "utf-8");
        } catch (Exception e) {
            tiedostonRivit.add("Virhe!!" + e.getMessage());
        }
        return tiedostonRivit;
    }

    /**
     * Metodi lukee lueTiedosto() antaman listan rivin, eli yhden kurssin
     * tiedot, erottaa tiedot pilkulla ja lisää ne taulukkoon.
     *
     * @param i halutun rivin numero
     * @return kurssisuorituksen tiedot taulukkona
     */
    public String[] lueRivi(int i) {
        if (this.tiedostonKoko > 0) {
            return lueTiedosto().get(i).split(",");
        }
        return null;
    }

    /**
     * Metodi lukee kurssisuoritusten tiedot tiedostosta, muuttaa ne
     * Kurssisuorituksiksi ja lisää listalle.
     *
     * @return Kurssisuoritukset listana
     */
    public List<Kurssisuoritus> lueKurssisuoritukset() {
        if (this.tiedostonKoko > 0 && lueRivi(0) != null) {
            for (int i = 0; i < this.tiedostonKoko; i++) {
                Kurssisuoritus kurssi = new Kurssisuoritus(lueRivi(i)[0], Integer.parseInt(lueRivi(i)[1]), Integer.parseInt(lueRivi(i)[2]));
                this.kurssisuoritukset.add(kurssi);
            }
        }
        return this.kurssisuoritukset;
    }

}
