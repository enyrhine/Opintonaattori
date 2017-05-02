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
    //private static File tiedosto;
    private Raporttikone raportti;
    private static Kayttaja elsa;
    
    public RaporttikoneTest() throws IOException {
       //tiedosto = new File("src/resources/moi.csv");
       elsa = new Kayttaja("Elsa");
       raportti = new Raporttikone(elsa.getTiedosto());
       
    }

    @Test
    public void raporttikoneLukeeTiedostonOikein() throws IOException {
        try (FileWriter kirjoittaja = new FileWriter(elsa.getTiedosto())) {
            kirjoittaja.write("moi");
            kirjoittaja.close();
        }
       
        List<String> rivit = raportti.lueTiedosto();
        assertEquals("moi", rivit.get(0));
        
    }
    
    @Test
    public void testLueRivi() throws IOException {
        try (FileWriter kirjoittaja = new FileWriter(elsa.getTiedosto())) {
            kirjoittaja.write("Ohja,4,5");
            kirjoittaja.close();
        }
        assertEquals("Ohja", raportti.lueRivi(0)[0]);
    }
    
    @Test
    public void testLueKurssisuoritukset() throws IOException {
         elsa.lisaaKurssisuoritus("Ohja", 4, 5);
         try (FileWriter kirjoittaja = new FileWriter(elsa.getTiedosto())) {
            kirjoittaja.write("Ohja,4,5");
           
            kirjoittaja.close();
        }
        assertEquals("Ohja", raportti.lueKurssisuoritukset().get(0).getNimi());
    }
    
    @AfterClass
    public static void tearDown() {
        
        elsa.getTiedosto().delete();
        
    }
    
}
