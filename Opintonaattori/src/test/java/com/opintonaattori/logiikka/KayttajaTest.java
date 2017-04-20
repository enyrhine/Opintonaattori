package com.opintonaattori.logiikka;

import com.opintonaattori.logiikka.Kayttaja;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KayttajaTest {

    private Kayttaja testi;

    public KayttajaTest() throws IOException {
        this.testi = new Kayttaja("testi");
        
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaNimenOikein() throws IOException {
        Kayttaja kayttaja = new Kayttaja("Malla");
        String nimi = kayttaja.getNimi();
        assertEquals("Malla", nimi);
        kayttaja.getTiedosto().delete();
    }

    @Test
    public void kurssisuorituksenLisaysOnnistuu() throws IOException {
        int kurssisuorituksiaAluksi = testi.getKurssit().size();
        testi.lisaaKurssisuoritus("Ohja", 5, 5);
        int kurssisuorituksiaLopuksi = testi.getKurssit().size();
        assertEquals(kurssisuorituksiaAluksi + 1, kurssisuorituksiaLopuksi);
        this.testi.getTiedosto().delete();
    }
    
//    @Test
//    public void getKurssisuoritusByNameToimii() throws IOException {
//        testi.lisaaKurssisuoritus("Ohja", 5, 5);
//        testi.lisaaKurssisuoritus("Ohpe", 5, 5);
//        String nimi = testi.getKurssisuoritusByName("Ohja");
//        assertEquals("Ohja", nimi);
//    }
//    
//    @Test
//    public void getKurssisuoritusByNameEiToimi() throws IOException {
//        testi.lisaaKurssisuoritus("Tira", 5, 5);
//        testi.lisaaKurssisuoritus("Ohpe", 5, 5);
//        String nimi = testi.getKurssisuoritusByName("Ohja");
//        assertEquals(null, nimi);
//    }
    
//    @Test
//    public void 

}
