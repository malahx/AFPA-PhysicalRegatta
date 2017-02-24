/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gwenole
 */
public class Algo {
    
    public Algo() {
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
    public void test_isEmail() {
        assertTrue(afpa.ecf.algo.Algo.isEmail("ab@cd.ef"));
        assertTrue(afpa.ecf.algo.Algo.isEmail("abcdef@ghij.klmn"));
        assertTrue(afpa.ecf.algo.Algo.isEmail("ab@c.f.ef"));
        assertFalse(afpa.ecf.algo.Algo.isEmail("a@ghij.klmn"));
        assertFalse(afpa.ecf.algo.Algo.isEmail("ab@c.de"));
        assertFalse(afpa.ecf.algo.Algo.isEmail("ab@cd.e"));
        assertFalse(afpa.ecf.algo.Algo.isEmail("abcdefghij"));
        assertFalse(afpa.ecf.algo.Algo.isEmail("abcdefghij.kl"));
        assertFalse(afpa.ecf.algo.Algo.isEmail("ab@cdef"));
    }
    
    @Test
    public void test_isEmailReg() {
        assertTrue(afpa.ecf.algo.Algo.isEmailReg("ab@cd.ef"));
        assertTrue(afpa.ecf.algo.Algo.isEmailReg("abcdef@ghij.klmn"));
        assertTrue(afpa.ecf.algo.Algo.isEmail("ab@c.f.ef"));
        assertFalse(afpa.ecf.algo.Algo.isEmailReg("a@ghij.klmn"));
        assertFalse(afpa.ecf.algo.Algo.isEmailReg("ab@c.de"));
        assertFalse(afpa.ecf.algo.Algo.isEmailReg("ab@cd.e"));
        assertFalse(afpa.ecf.algo.Algo.isEmailReg("abcdefghij"));
        assertFalse(afpa.ecf.algo.Algo.isEmailReg("abcdefghij.kl"));
        assertFalse(afpa.ecf.algo.Algo.isEmailReg("ab@cdef"));
    }
}
