package com.opintonaattori.tiedosto;

import com.opintonaattori.logiikka.Kayttaja;
import com.opintonaattori.logiikka.Kurssisuoritus;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TallentajaTest {

    private static Kayttaja elsa;

    public TallentajaTest() {
        elsa = new Kayttaja("Elsa");
    }

    @Test
    public void testTallentajaHakeeKayttajan() {
        Kayttaja maija = new Kayttaja("Maija");
        maija.tyhjennaKurssit();
        Tallentaja tallentaja = new Tallentaja(maija.getTiedosto());
        tallentaja.lisaaKurssisuoritus(new Kurssisuoritus("Otm", 5, 5));
        assertEquals(8, maija.getTiedosto().length());
        maija.getTiedosto().delete();
    }

    @Test
    public void testLisaaKurssisuoritus() {
        Tallentaja tallentaja = new Tallentaja(elsa.getTiedosto());
        tallentaja.lisaaKurssisuoritus(new Kurssisuoritus("Otm", 5, 5));
        assertEquals(8, elsa.getTiedosto().length());
    }

    @AfterClass
    public static void tearDown() {
        elsa.getTiedosto().delete();

    }
}
