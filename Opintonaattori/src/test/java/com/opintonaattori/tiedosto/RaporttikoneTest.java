/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opintonaattori.tiedosto;

import com.opintonaattori.logiikka.Kayttaja;
import com.opintonaattori.logiikka.Kurssisuoritus;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elsanyrhinen
 */
public class RaporttikoneTest {
    private File tiedosto;
    private Raporttikone raportti;
    private Kayttaja elsa;
    
    public RaporttikoneTest() throws IOException {
       this.tiedosto = new File("src/resources/moi.csv");
       this.raportti = new Raporttikone(tiedosto);
       this.elsa = new Kayttaja("Elsa");
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

    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void raporttikoneLukeeTiedostonOikein() throws IOException {
        try (FileWriter kirjoittaja = new FileWriter(tiedosto)) {
            kirjoittaja.write("moi");
            kirjoittaja.close();
        }
       
        List<String> rivit = raportti.lueTiedosto();
        assertEquals("moi", rivit.get(0));
        
    }
    
    @Test
    public void testLueRivi() throws IOException {
        try (FileWriter kirjoittaja = new FileWriter(tiedosto)) {
            kirjoittaja.write("Ohja,4,5");
            kirjoittaja.close();
        }
        assertEquals("Ohja", this.raportti.lueRivi(0)[0]);
    }
    
    @Test
    public void testLueKurssisuoritukset() throws IOException {
         try (FileWriter kirjoittaja = new FileWriter(tiedosto)) {
            kirjoittaja.write("Ohja,4,5");
            kirjoittaja.close();
        }
        assertEquals("Ohja", this.raportti.lueKurssisuoritukset().get(0).getNimi());
    }
    
}
