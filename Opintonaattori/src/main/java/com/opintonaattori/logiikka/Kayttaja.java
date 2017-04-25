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

    public Kayttaja(String nimi) throws IOException {
        this.nimi = nimi;
        this.kurssisuoritukset = new ArrayList<>();
        this.tiedosto = new File("src/resources/" + this.nimi + ".csv");
        this.tallentaja = new Tallentaja(this.tiedosto);
        this.raportti = new Raporttikone(this.tiedosto);
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
     */
    public void lisaaKurssisuoritus(String nimi, int op, int arvosana) throws IOException {
        Kurssisuoritus kurssi = new Kurssisuoritus(nimi, op, arvosana);
        this.kurssisuoritukset.add(kurssi);
        this.tallentaja.lisaaKurssisuoritus(kurssi);
    }

//    
//    public void printKurssit() {
//        for (Kurssisuoritus kurssi : this.kurssisuoritukset) {
//            System.out.println(kurssi);
//        }
//    }
    public String getNimi() {
        return this.nimi;
    }

    /**
     * Metodi hakee kaikki tiedostossa olevat kurssit ja palauttaa ne listana jolla Stringinä kurssin tiedot.
     *
     * @see 
     * com.opintonaattori.tiedosto.Raporttikone#lueTiedosto() 
     * @see 
     * com.opintonaattori.tiedosto.Raporttikone#lueRivit(int) 
     * 
     * @return ArrayListin kursseista
     *
     */
    public ArrayList<String> getKurssit() {
        ArrayList<String> kaikkiKurssit = new ArrayList<>();
        for (int i = 0; i < this.raportti.lueTiedosto().size(); i++) {
            String[] kurssiTiedot = this.raportti.lueRivit(i);
            kaikkiKurssit.add(kurssiTiedot[0] + " " + kurssiTiedot[1] + " " + kurssiTiedot[2]);
        }
        return kaikkiKurssit;
    }
    
    public List<Kurssisuoritus> getKurssisuorituksetList() {
        return this.kurssisuoritukset;
    }
    
    public String tulostaKurssit(int i) {
        return getKurssit().get(i);
    }
    
    public String tulostaKurssinNimi(int i) {
        return getKurssi(i)[0];
    }
    
    public String tulostaKurssinOpintopisteet(int i) {
        return getKurssi(i)[1];
    }
    
    public String tulostaKurssinArvosana(int i) {
        return getKurssi(i)[2];
    }

    public File getTiedosto() {
        return this.tiedosto;
    }
    
    public String[] getKurssi(int i) {
        return this.raportti.lueRivit(i);
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
