package afpa.ecf.physicalregatta.test;

import static org.junit.Assert.*;

import org.junit.Test;

import afpa.ecf.physicalregatta.Utils;

public class Email {

    @Test
    public void test_isEmail() {
        assertTrue(Utils.isEmail("ab@cd.ef"));
        assertTrue(Utils.isEmail("abcdef@ghij.klmn"));
        assertTrue(Utils.isEmail("ab@c.f.ef"));
        assertFalse(Utils.isEmail("a@ghij.klmn"));
        assertFalse(Utils.isEmail("ab@c.de"));
        assertFalse(Utils.isEmail("ab@cd.e"));
        assertFalse(Utils.isEmail("abcdefghij"));
        assertFalse(Utils.isEmail("abcdefghij.kl"));
        assertFalse(Utils.isEmail("ab@cdef"));
    }
    

    @Test
    public void test_isEmailReg() {
        assertTrue(Utils.isEmailReg("ab@cd.ef"));
        assertTrue(Utils.isEmailReg("abcdef@ghij.klmn"));
        assertTrue(Utils.isEmail("ab@c.f.ef"));
        assertFalse(Utils.isEmailReg("a@ghij.klmn"));
        assertFalse(Utils.isEmailReg("ab@c.de"));
        assertFalse(Utils.isEmailReg("ab@cd.e"));
        assertFalse(Utils.isEmailReg("abcdefghij"));
        assertFalse(Utils.isEmailReg("abcdefghij.kl"));
        assertFalse(Utils.isEmailReg("ab@cdef"));
    }

}
