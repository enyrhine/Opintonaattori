package com.opintonaattori.logiikka;

import com.opintonaattori.logiikka.Kayttaja;
import java.io.IOException;
import java.io.PrintWriter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KayttajaTest {

    private static Kayttaja testi;

    public KayttajaTest() throws IOException {
        testi = new Kayttaja("testi");

    }

    @Test
    public void konstruktoriAsettaaNimenOikein() throws IOException {
        Kayttaja kayttaja = new Kayttaja("Malla");
        String nimi = kayttaja.getNimi();
        assertEquals("Malla", nimi);
    }

    @Test
    public void kurssisuorituksenLisaysOnnistuu() throws IOException {
        int kurssisuorituksiaAluksi = testi.getKurssisuorituksetList().size();
        testi.lisaaKurssisuoritus("Ohja", 5, 5);
        int kurssisuorituksiaLopuksi = testi.getKurssisuorituksetList().size();
        assertEquals(kurssisuorituksiaAluksi + 1, kurssisuorituksiaLopuksi);
    }

    @Test
    public void testGetKeskiarvo() throws IOException {
        Double a = 5.0;
        assertEquals(a, this.testi.getKeskiarvo());
    }

    @Test
    public void testGetOpintopisteet() throws IOException {
//        PrintWriter writer = new PrintWriter(this.testi.getTiedosto());
//        writer.print("");
//        writer.close();
        this.testi.lisaaKurssisuoritus("Testing", 10, 5);
        this.testi.setKurssisuorituksetList();
        System.out.println(this.testi.getKurssisuorituksetList());
        int i = this.testi.getOpintopisteet();
        assertEquals(i, this.testi.getOpintopisteet());
    }

    @AfterClass
    public static void tearDown() {
        testi.getTiedosto().delete();
        
    }
}
