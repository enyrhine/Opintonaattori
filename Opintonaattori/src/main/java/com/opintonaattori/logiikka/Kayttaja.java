package com.opintonaattori.logiikka;

import com.opintonaattori.tiedosto.Raporttikone;
import com.opintonaattori.tiedosto.Tallentaja;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Luokka tarjoaa käyttäjän henkilökohtaisten kurssisuoritusten lisäyksiin
 * tarvittavia metodeita.
 */
public class Kayttaja {

    private String nimi;
    private List<Kurssisuoritus> kurssisuoritukset;
    private File tiedosto;
    private Tallentaja tallentaja;
    private Raporttikone raportti;
    private double ka;
    private int opintopisteet;

    /**
     * Luokka luo käyttäjän jonka avulla hallitaan kurssien lisäystä.
     *
     * @param nimi kertoo käyttäjän nimen, josta muodostuu tiedoston nimi
     *
     */
    public Kayttaja(String nimi) {
        this.nimi = nimi;
        this.tiedosto = new File("src/resources/" + this.nimi + ".csv");
        this.ka = 0;
        this.opintopisteet = 0;
        this.kurssisuoritukset = new ArrayList<>();

        this.tallentaja = new Tallentaja(this.tiedosto);
        this.raportti = new Raporttikone(this.tiedosto);

        try {
            this.kurssisuoritukset = this.raportti.lueKurssisuoritukset();
        } catch (Exception e) {
            this.kurssisuoritukset = new ArrayList<>();
        }

    }

    /**
     * Metodi lisää käyttäjälle uuden kurssisuorituksen arvosanoineen ja
     * opintopisteineen.
     *
     * @param nimi Käyttäjän antama kurssin nimi
     * @param op Käyttäjän antama opintopistemäärä
     * @param arvosana Käyttäjän antama arvosana
     *
     * @see
     * com.opintonaattori.tiedosto.Tallentaja#lisaaKurssisuoritus(com.opintonaattori.logiikka.Kurssisuoritus)
     * @throws java.io.IOException laittaa eteenpäin exceptionin
     */
    public void lisaaKurssisuoritus(String nimi, int op, int arvosana) throws IOException {
        Kurssisuoritus kurssi = new Kurssisuoritus(nimi, op, arvosana);
        this.kurssisuoritukset.add(kurssi);
        this.tallentaja.lisaaKurssisuoritus(kurssi);
    }

    public String getNimi() {
        return this.nimi;
    }

    /**
     * Metodi palauttaa kaikkien kurssien keskiarvot.
     *
     * @return keskiarvo double
     */
    public Double getKeskiarvo() {
        int summa = 0;
        for (Kurssisuoritus kurssisuoritus : kurssisuoritukset) {
            summa = summa + kurssisuoritus.getArvosana();
        }
        if (kurssisuoritukset.size() > 0) {
            return this.ka = (double) summa / kurssisuoritukset.size();
        }
        return 0.0;
    }

    /**
     * Metodi palauttaa kaikkien kurssien opintopisteet yhteenlaskettuna.
     *
     * @return summa opintopisteistä
     */
    public int getOpintopisteet() {
        int summa = 0;
        for (Kurssisuoritus kurssisuoritus : kurssisuoritukset) {
            summa = summa + kurssisuoritus.getOp();
        }

        return summa;
    }

    /**
     * Metodi palauttaa kaikkien kurssien opintopisteet yhteenlaskettuna.
     *
     */
    public void setKurssisuorituksetList() {
        this.kurssisuoritukset.clear();
        this.kurssisuoritukset = this.raportti.lueKurssisuoritukset();
    }

    public List<Kurssisuoritus> getKurssisuorituksetList() {
        return this.kurssisuoritukset;
    }

    /**
     * Metodi tulostaa kurssin nimen.
     *
     * @param i kurssisuorituksen indeksi
     * @return nimen palautus
     */
    public String tulostaKurssinNimi(int i) {
        return getKurssi(i).getNimi();
    }

    /**
     * Metodi tulostaa kurssin opintopisteet.
     *
     * @param i kurssisuorituksen indeksi
     * @return opintopisteiden palautus Stringinä
     */
    public String tulostaKurssinOpintopisteet(int i) {
        return getKurssi(i).getOp() + "";
    }

    /**
     * Metodi tulostaa kurssin arvosanan.
     *
     * @param i kurssisuorituksen indeksi
     * @return arvosanan palautus Stringinä
     */
    public String tulostaKurssinArvosana(int i) {
        return getKurssi(i).getArvosana() + "";
    }

    public File getTiedosto() {
        return this.tiedosto;
    }

    /**
     * Metodi hakee kurssisuorituksen annetun indeksin perusteella.
     *
     * @param i kurssisuorituksen indeksi
     * @return kurssisuoritukset
     */
    public Kurssisuoritus getKurssi(int i) {
        return this.kurssisuoritukset.get(i);
    }

    /**
     * Metodi tyhjentää käyttäjän kurssit.
     *
     */
    public void tyhjennaKurssit() {
        this.kurssisuoritukset.clear();
        this.tiedosto.delete();
        this.tiedosto = new File("src/resources/" + this.nimi + ".csv");
    }

}
