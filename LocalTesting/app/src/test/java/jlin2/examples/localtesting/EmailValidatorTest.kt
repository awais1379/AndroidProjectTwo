package jlin2.examples.localtesting

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun testValidEmail() {
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }

    @Test
    fun testValidEmailWithSubdomain() {
        assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }

    @Test
    fun testInvalidEmailMissingDomain() {
        assertFalse(EmailValidator.isValidEmail("123@abc"))
    }

    @Test
    fun testInvalidEmailWithDoubleDots() {
        assertFalse(EmailValidator.isValidEmail("123@abc..com"))
    }

    @Test
    fun testInvalidEmailWithoutUsername() {
        assertFalse(EmailValidator.isValidEmail("@abc.com"))
    }

    @Test
    fun testInvalidEmailWithoutDomain() {
        assertFalse(EmailValidator.isValidEmail("testing123"))
    }

}