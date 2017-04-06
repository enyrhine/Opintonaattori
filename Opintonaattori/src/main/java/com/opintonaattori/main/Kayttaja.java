package com.opintonaattori.main;

import com.opintonaattori.tiedosto.Tallentaja;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Kayttaja {

    private String nimi;
    private List<Kurssisuoritus> kurssisuoritukset;
    private File tiedosto;
    private Tallentaja tallentaja;

    public Kayttaja(String nimi) throws IOException {
        this.nimi = nimi;
        this.kurssisuoritukset = new ArrayList<>();
        this.tiedosto = new File("src/resources/" + this.nimi + ".csv");
        this.tallentaja = new Tallentaja(this.tiedosto);
    }

    public void lisaaKurssisuoritus(String nimi, int op, int arvosana) throws IOException {
        Kurssisuoritus kurssi = new Kurssisuoritus(nimi, op, arvosana);
        this.kurssisuoritukset.add(kurssi);
        this.tallentaja.lisaaKurssisuoritus(kurssi);
    }

    public void printKurssit() {
        for (Kurssisuoritus kurssi : this.kurssisuoritukset) {
            System.out.println(kurssi);
        }
    }

    public String getNimi() {
        return this.nimi;
    }

    public List getKurssit() {
        return this.kurssisuoritukset;
    }
    
    public File getTiedosto() {
        return this.tiedosto;
    }

    public String getKurssisuoritusByName(String nimi) {
        for (Kurssisuoritus kurssi : kurssisuoritukset) {
            if (kurssi.getNimi().equals(nimi)) {
                return nimi;
            }
        }
        return null;
    }

    public void poistaKurssisuoritus(Kurssisuoritus kurssi) {
        if (this.kurssisuoritukset.contains(kurssi)) {
            this.kurssisuoritukset.remove(kurssi);
        }
    }

//    public void muokkaaKurssia(Kurssisuoritus kurssi, int arvosana, int op, boolean onkoMaisteri) {
//        if (this.kurssisuoritukset.contains(kurssi)) {
//            kurssi.setArvosana(arvosana);
//            kurssi.setOp(op);
//            kurssi.setTutkinto(onkoMaisteri);
//        }
//    }

}
