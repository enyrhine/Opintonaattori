/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opintonaattori.main;

import com.opintonaattori.logiikka.Kayttaja;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Main {

    public Main() {
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
    public void kayttajaLuodaanOikein() {
        try {
            Kayttaja elsa = new Kayttaja("Elsa");
            assertEquals("Elsa", elsa.getNimi());
        } catch (Exception e) {
            System.out.println("Virhe!!" + e.getMessage());
        }
        
             
    }
}
