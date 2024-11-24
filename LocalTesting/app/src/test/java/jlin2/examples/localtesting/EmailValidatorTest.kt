package jlin2.examples.localtesting

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun testValidEmail() {
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }

}