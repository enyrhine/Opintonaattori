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

    private final Kayttaja testi;

    public KayttajaTest() throws IOException {
        this.testi = new Kayttaja("testi");
        testi.lisaaKurssisuoritus("Ohpe", 5, 5);
        testi.lisaaKurssisuoritus("Tira", 5, 3);
        
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
        Double a = 4.0;
        assertEquals(a, this.testi.getKeskiarvo());
    }
    
    @Test
    public void testGetOpintopisteet() throws IOException {
        assertEquals(10, this.testi.getOpintopisteet());
    }
}
