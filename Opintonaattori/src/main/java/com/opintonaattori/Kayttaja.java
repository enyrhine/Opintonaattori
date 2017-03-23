package com.opintonaattori;

import java.util.ArrayList;
import java.util.List;

public class Kayttaja {

    private String nimi;
    private List<Kurssisuoritus> kurssisuoritukset;

    public Kayttaja(String nimi) {
        this.nimi = nimi;
        this.kurssisuoritukset = new ArrayList();
    }

    public void lisaaKurssisuoritus(String nimi, int op, int arvosana) {
        Kurssisuoritus kurssi = new Kurssisuoritus(nimi, op, arvosana);
        this.kurssisuoritukset.add(kurssi);
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

//    public Kurssisuoritus getKurssisuoritus(Kurssisuoritus kurssi) {
//        if (this.kurssisuoritukset.contains(kurssi)) {
//            return kurssi;
//        }
//        return null;
//    }
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

    public void muokkaaKurssia(Kurssisuoritus kurssi, int arvosana, int op, boolean onkoMaisteri) {
        if (this.kurssisuoritukset.contains(kurssi)) {
            kurssi.setArvosana(arvosana);
            kurssi.setOp(op);
            kurssi.setTutkinto(onkoMaisteri);
        }
    }

}
