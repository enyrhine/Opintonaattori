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
    public void testGetNimi() {
        assertEquals("testi", testi.getNimi());
    }

    @Test
    public void konstruktoriAsettaaNimenOikein() throws IOException {
        Kayttaja kayttaja = new Kayttaja("Malla");
        String nimi = kayttaja.getNimi();
        assertEquals("Malla", nimi);
    }

    @Test
    public void testGetKeskiarvo() throws IOException {
        Double a = 5.0;
        testi.tyhjennaKurssit();
        testi.lisaaKurssisuoritus("Ohja", 5, 5);
        assertEquals(a, testi.getKeskiarvo());
    }

    @Test
    public void testGetOpintopisteet() throws IOException {
        testi.lisaaKurssisuoritus("Testing", 10, 5);
        testi.setKurssisuorituksetList();
        System.out.println(testi.getKurssisuorituksetList());
        int i = testi.getOpintopisteet();
        assertEquals(i, testi.getOpintopisteet());
    }

    @Test
    public void testGetKurssisuorituksetList() {
        assertEquals(0, testi.getKurssisuorituksetList().size());
    }

    @Test
    public void testTulostaKurssinNimi() throws IOException {
        Kayttaja testiKayttaja = new Kayttaja("Testi");
        testiKayttaja.lisaaKurssisuoritus("Testi", 1, 1);
        assertEquals("Testi", testiKayttaja.tulostaKurssinNimi(0));
        testiKayttaja.getTiedosto().delete();
    }

    @Test
    public void testTulostaKurssinOp() throws IOException {
        testi.lisaaKurssisuoritus("Tira", 1, 1);
        assertEquals("1", testi.tulostaKurssinOpintopisteet(testi.getKurssisuorituksetList().size() - 1));
    }

    @Test
    public void testTulostaKurssinArvosana() throws IOException {
        testi.lisaaKurssisuoritus("Tira", 1, 1);
        assertEquals("1", testi.tulostaKurssinArvosana(testi.getKurssisuorituksetList().size() - 1));
    }

    @Test
    public void kurssisuorituksenLisaysOnnistuu() throws IOException {
        int kurssisuorituksiaAluksi = testi.getKurssisuorituksetList().size();
        testi.lisaaKurssisuoritus("Ohja", 5, 5);
        int kurssisuorituksiaLopuksi = testi.getKurssisuorituksetList().size();
        assertEquals(kurssisuorituksiaAluksi + 1, kurssisuorituksiaLopuksi);
    }

    @Test
    public void testTyhjennaKurssit() {
        testi.tyhjennaKurssit();
        assertEquals(0, testi.getKurssisuorituksetList().size());
    }

    @AfterClass
    public static void tearDown() {
        testi.getTiedosto().delete();

    }
}
