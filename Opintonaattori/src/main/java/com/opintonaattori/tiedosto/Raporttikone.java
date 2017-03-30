package com.opintonaattori.tiedosto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

public class Raporttikone {

    private Scanner lukija;
    private List<String> rivit;
    private File tiedosto;

    public Raporttikone(File tiedosto) {
        // this.lukija = new Scanner(lukija.nextLine());
        this.tiedosto = tiedosto;
        this.rivit = new ArrayList<>();

    }

    public List<String> lueTiedosto() {
        try {
            this.rivit = FileUtils.readLines(this.tiedosto, "utf-8");
        } catch (Exception e) {
            System.out.println("Virhe!!" + e.getMessage());
        }
        return this.rivit;
    }
}
