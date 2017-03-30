/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opintonaattori.tiedosto;

import java.io.File;
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

    public RaporttikoneTest() {
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
    public void raporttikoneLukeeTiedostonOikein() {
        File tiedosto = new File("moi");
        Raporttikone raportti = new Raporttikone(tiedosto);
        List<String> rivit = raportti.lueTiedosto();
        assertEquals("Moi", rivit.get(0));
    }
}
