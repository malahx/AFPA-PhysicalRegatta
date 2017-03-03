/*
 * This is free and unencumbered software released into the public domain.
 */

import afpa.ecf.algo.Algo;
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
public class AlgoTest {
    
    public AlgoTest() {
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
        assertTrue(Algo.isEmail("ab@cd.ef"));
        assertTrue(Algo.isEmail("abcdef@ghij.klmn"));
        assertTrue(Algo.isEmail("ab@c.f.ef"));
        assertFalse(Algo.isEmail("a@ghij.klmn"));
        assertFalse(Algo.isEmail("ab@c.de"));
        assertFalse(Algo.isEmail("ab@cd.e"));
        assertFalse(Algo.isEmail("abcdefghij"));
        assertFalse(Algo.isEmail("abcdefghij.kl"));
        assertFalse(Algo.isEmail("ab@cdef"));
    }
    
    @Test
    public void test_isEmailReg() {
        assertTrue(Algo.isEmailReg("ab@cd.ef"));
        assertTrue(Algo.isEmailReg("abcdef@ghij.klmn"));
        assertTrue(Algo.isEmail("ab@c.f.ef"));
        assertFalse(Algo.isEmailReg("a@ghij.klmn"));
        assertFalse(Algo.isEmailReg("ab@c.de"));
        assertFalse(Algo.isEmailReg("ab@cd.e"));
        assertFalse(Algo.isEmailReg("abcdefghij"));
        assertFalse(Algo.isEmailReg("abcdefghij.kl"));
        assertFalse(Algo.isEmailReg("ab@cdef"));
    }
}
