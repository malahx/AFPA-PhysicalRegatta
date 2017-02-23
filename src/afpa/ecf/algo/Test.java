/*
 * This is free and unencumbered software released into the public domain.
 */

package afpa.ecf.algo;

import static org.junit.Assert.*;

import afpa.ecf.physicalregatta.Utils;

/**
 * @author gwenole
 *
 */
public class Test {

    @org.junit.Test
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
    
    @org.junit.Test
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
