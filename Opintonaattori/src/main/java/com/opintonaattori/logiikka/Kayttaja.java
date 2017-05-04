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
//        if (this.raportti.getTiedostonKoko() > 0) {
//            this.kurssisuoritukset = this.raportti.lueKurssisuoritukset();
//        }
        
    }

    /**
     * Metodi lisää käyttäjälle uuden kurssisuorituksen arvosanoineen ja opintopisteineen.
     *
     * @param nimi Käyttäjän antama kurssin nimi
     * @param op Käyttäjän antama opintopistemäärä
     * @param arvosana Käyttäjän antama arvosana
     * @throws java.io.IOException
     *
     * @see
     * com.opintonaattori.tiedosto.Tallentaja#lisaaKurssisuoritus(com.opintonaattori.logiikka.Kurssisuoritus)
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
            return this.ka = summa / kurssisuoritukset.size();
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
     * Metodi hakee kaikki tiedostossa olevat kurssit ja palauttaa ne listana jolla Stringinä kurssin tiedot.
     *
     * @see com.opintonaattori.tiedosto.Raporttikone#lueTiedosto()
     * @see com.opintonaattori.tiedosto.Raporttikone#lueRivit(int)
     *
     * @return ArrayListin kursseista
     *
     */
    public ArrayList<String> getKurssit() {
        ArrayList<String> kaikkiKurssit = new ArrayList<>();
        if (this.kurssisuoritukset.size() > 0) {
            for (Kurssisuoritus kurssisuoritus : this.kurssisuoritukset) {
                kaikkiKurssit.add(kurssisuoritus.getNimi() + " " + kurssisuoritus.getOp() + " " + kurssisuoritus.getArvosana());
            }
        }
//        
//        if (!this.raportti.lueTiedosto().isEmpty()) {
//            for (int i = 0; i < this.raportti.lueTiedosto().size(); i++) {
//                String[] kurssiTiedot = this.raportti.lueRivit(i);
//                kaikkiKurssit.add(kurssiTiedot[0] + " " + kurssiTiedot[1] + " " + kurssiTiedot[2]);
//            }
//        }
        return kaikkiKurssit;
    }

    public void setKurssisuorituksetList() {
        this.kurssisuoritukset.clear();
        this.kurssisuoritukset = this.raportti.lueKurssisuoritukset();
    }
    
    public List<Kurssisuoritus> getKurssisuorituksetList() {
        return this.kurssisuoritukset;
    }

//    public String tulostaKurssit(int i) {
//        return getKurssit().get(i);
//    }

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
     * @return Kurssisuoritus 
     */
    public Kurssisuoritus getKurssi(int i) {
        return this.kurssisuoritukset.get(i);
    }

    //Kommentoitu ulos turhia tai ei toiminnallisuutta sisältäviä metodeja, palataan myöhemmin näihin.
//
//    public String getKurssisuoritusByName(String nimi) {
//        for (Kurssisuoritus kurssi : kurssisuoritukset) {
//            if (kurssi.getNimi().equals(nimi)) {
//                return nimi;
//            }
//        }
//        return null;
//    }
//    public void poistaKurssisuoritus(Kurssisuoritus kurssi) {
//        if (this.kurssisuoritukset.contains(kurssi)) {
//            this.kurssisuoritukset.remove(kurssi);
//        }
//    }
//    public void muokkaaKurssia(Kurssisuoritus kurssi, int arvosana, int op, boolean onkoMaisteri) {
//        if (this.kurssisuoritukset.contains(kurssi)) {
//            kurssi.setArvosana(arvosana);
//            kurssi.setOp(op);
//            kurssi.setTutkinto(onkoMaisteri);
//        }
//    }
}
