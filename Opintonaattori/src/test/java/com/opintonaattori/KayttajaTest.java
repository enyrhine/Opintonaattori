package com.opintonaattori;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KayttajaTest {

    private Kayttaja testi;

    public KayttajaTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void konstruktoriAsettaaNimenOikein() {
        Kayttaja kayttaja = new Kayttaja("Malla");
        String nimi = kayttaja.getNimi();
        assertEquals("Malla", nimi);
    }

    @Test
    public void kurssisuorituksenLisaysOnnistuu() {
        int kurssisuorituksiaAluksi = testi.getKurssit().size();
        testi.lisaaKurssisuoritus("Ohja", 5, 5);
        int kurssisuorituksiaLopuksi = testi.getKurssit().size();
        assertEquals(kurssisuorituksiaAluksi + 1, kurssisuorituksiaLopuksi);
    }
    
    @Test
    public void getKurssisuoritusByNameToimii() {
        testi.lisaaKurssisuoritus("Ohja", 5, 5);
        testi.lisaaKurssisuoritus("Ohpe", 5, 5);
        String nimi = testi.getKurssisuoritusByName("Ohja");
        assertEquals("Ohja", nimi);
    }
    
    @Test
    public void getKurssisuoritusByNameEiToimi() {
        testi.lisaaKurssisuoritus("Tira", 5, 5);
        testi.lisaaKurssisuoritus("Ohpe", 5, 5);
        String nimi = testi.getKurssisuoritusByName("Ohja");
        assertEquals(null, nimi);
    }
    
//    @Test
//    public void kurssisuorituksenLisaysOnnistuu() {
//        testi.lisaaKurssisuoritus("Ohja", 5, 5);
////        for (Kurssisuoritus nimi : testi.getKurssit()) {
////            nimi
////        }
//        //Kurssisuoritus kurssi = testi.getKurssisuoritusByName("Ohja");
//        //Kurssisuoritus kurssi = new Kurssisuoritus("Ohja", 5, 5);
//        boolean vastaus = testi.getKurssit().contains(kurssi);
//        assertEquals(true, vastaus);
//    }
}
