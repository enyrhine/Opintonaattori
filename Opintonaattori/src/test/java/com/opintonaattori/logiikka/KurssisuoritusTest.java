package com.opintonaattori.logiikka;

import com.opintonaattori.logiikka.Kurssisuoritus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KurssisuoritusTest {

    public KurssisuoritusTest() {
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
    // @Test
    // public void hello() {}
    @Test
    public void konstruktoriAsettaaNimenOikein() {
        Kurssisuoritus testi = new Kurssisuoritus("Ohja", 5, 5);
        String nimi = testi.getNimi();
        assertEquals("Ohja", nimi);
    }

    @Test
    public void konstruktoriAsettaaOpOikein() {
        Kurssisuoritus testi = new Kurssisuoritus("Ohja", 5, 5);
        int op = testi.getOp();
        assertEquals(5, op);
    }

    @Test
    public void konstruktoriAsettaaArvosananOikein() {
        Kurssisuoritus testi = new Kurssisuoritus("Ohja", 5, 4);
        int arvosana = testi.getArvosana();
        assertEquals(4, arvosana);
    }

    @Test
    public void metodiAsettaaArvosananOikein() {
        Kurssisuoritus testi = new Kurssisuoritus("Ohja", 4, 5);
        testi.setArvosana(5);
        int arvosana = testi.getArvosana();
        assertEquals(5, arvosana);
    }

    @Test
    public void metodiAsettaaOpOikein() {
        Kurssisuoritus testi = new Kurssisuoritus("Tira", 4, 8);
        testi.setOp(10);
        int op = testi.getOp();
        assertEquals(10, op);
    }

    @Test
    public void metodiAsettaaTutkinnonOikein() {
        Kurssisuoritus testi = new Kurssisuoritus("Tira", 4, 8);
        testi.setTutkinto(true);
        boolean t = testi.getTutkinto();
        assertEquals(true, t);
    }
}
