/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.kyriosdata.exemplo.application.api;

import com.github.kyriosdata.exemplo.domain.DiaDaSemana;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class DiaDaSemanaControllerTest {
    
    public DiaDaSemanaControllerTest() {
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

    /**
     * Test of diaDaSemana method, of class DiaDaSemanaController.
     */
    @Test
    public void testDiaDaSemana() {
        System.out.println("diaDaSemana");
        String arg = "";
        DiaDaSemanaController instance = new DiaDaSemanaController();
        DiaDaSemana expResult = null;
        DiaDaSemana result = instance.diaDaSemana(arg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of localDateFromString method, of class DiaDaSemanaController.
     */
    @Test
    public void testLocalDateFromString() {
        System.out.println("localDateFromString");
        String data = "";
        DiaDaSemanaController instance = new DiaDaSemanaController();
        LocalDate expResult = null;
        LocalDate result = instance.localDateFromString(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
