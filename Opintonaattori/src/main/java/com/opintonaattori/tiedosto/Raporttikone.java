package com.opintonaattori.tiedosto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

/**
 * Luokka tarjoaa tiedoston lukemiseen tarvittavia metodeja, vaatii vielä toiminnallisuutta.
 */
public class Raporttikone {

    private Scanner lukija;
    private List<String> rivit;
    private File tiedosto;

    public Raporttikone(File tiedosto) {
        // this.lukija = new Scanner(lukija.nextLine());
        this.tiedosto = tiedosto;
        this.rivit = new ArrayList<>();

    }

    /**
     * Metodi lukee tiedoston ja lisää
     * saamansa rivit listaan.
     *
     * @return rivit arraylistinä
     */
    public List<String> lueTiedosto() {
        try {
            this.rivit = FileUtils.readLines(this.tiedosto, "utf-8");
        } catch (Exception e) {
            System.out.println("Virhe!!" + e.getMessage());
        }
        return this.rivit;
    }
}
