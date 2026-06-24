
/**
 * Unit Tests for PalindromeValidator Utility Class
 *
 * Tests input sanitization, validation, and preprocessing
 * functionality.
 */
@DisplayName("PalindromeValidator Tests")
class PalindromeValidatorTest {

    @Test
    @DisplayName("Sanitize: removes spaces")
    void testSanitizeRemovesSpaces() {
        assertEquals("amanaplanacanalpanama",
                     PalindromeValidator.sanitize("a man a plan a canal panama"));
    }

    @Test
    @DisplayName("Sanitize: removes punctuation")
    void testSanitizeRemovesPunctuation() {
        assertEquals("amanaplanacanalpanama",
                     PalindromeValidator.sanitize("A man, a plan, a canal: Panama!"));
    }

    @Test
    @DisplayName("Sanitize: converts to lowercase")
    void testSanitizeConvertsToLowercase() {
        assertEquals("level", PalindromeValidator.sanitize("LEVEL"));
    }

    @Test
    @DisplayName("Sanitize: handles mixed case and punctuation")
    void testSanitizeHandlesMixed() {
        assertEquals("racecar",
                     PalindromeValidator.sanitize("RaCe-Car!"));
    }

    @Test
    @DisplayName("Sanitize: keeps numbers")
    void testSanitizeKeepsNumbers() {
        assertEquals("12321", PalindromeValidator.sanitize("1-2-3-2-1"));
    }

    @Test
    @DisplayName("Sanitize: null input throws IllegalArgumentException")
    void testSanitizeNullInput() {
        assertThrows(IllegalArgumentException.class, () -> PalindromeValidator.sanitize(null));
    }

    @Test
    @DisplayName("Sanitize: empty string remains empty")
    void testSanitizeEmptyString() {
        assertEquals("", PalindromeValidator.sanitize(""));
    }

    @Test
    @DisplayName("Sanitize: only special characters becomes empty")
    void testSanitizeOnlySpecialChars() {
        assertEquals("", PalindromeValidator.sanitize("!@#$%^&*()"));
    }

    @Test
    @DisplayName("isValidInput: valid alphanumeric string")
    void testIsValidInputAlphanumeric() {
        assertTrue(PalindromeValidator.isValidInput("level"));
    }

    @Test
    @DisplayName("isValidInput: valid string with spaces")
    void testIsValidInputWithSpaces() {
        assertTrue(PalindromeValidator.isValidInput("a man a plan a canal panama"));
    }

    @Test
    @DisplayName("isValidInput: valid string with special chars")
    void testIsValidInputWithSpecialChars() {
        assertTrue(PalindromeValidator.isValidInput("A man, a plan, a canal: Panama"));
    }

    @Test
    @DisplayName("isValidInput: null input is invalid")
    void testIsValidInputNull() {
        assertFalse(PalindromeValidator.isValidInput(null));
    }

    @Test
    @DisplayName("isValidInput: empty string is invalid")
    void testIsValidInputEmpty() {
        assertFalse(PalindromeValidator.isValidInput(""));
    }

    @Test
    @DisplayName("isValidInput: only spaces is invalid")
    void testIsValidInputOnlySpaces() {
        assertFalse(PalindromeValidator.isValidInput("   "));
    }

    @Test
    @DisplayName("isValidInput: only special chars is invalid")
    void testIsValidInputOnlySpecialChars() {
        assertFalse(PalindromeValidator.isValidInput("!@#$%^&*()"));
    }

    @Test
    @DisplayName("getSanitizedLength: basic case")
    void testGetSanitizedLength() {
        assertEquals(5, PalindromeValidator.getSanitizedLength("l-e-v-e-l"));
    }

    @Test
    @DisplayName("getSanitizedLength: with spaces")
    void testGetSanitizedLengthWithSpaces() {
        assertEquals(21, PalindromeValidator.getSanitizedLength("a man a plan a canal panama"));
    }

    @Test
    @DisplayName("getSanitizedLength: complex string")
    void testGetSanitizedLengthComplex() {
        assertEquals(29, PalindromeValidator.getSanitizedLength("Was it a car or a cat I saw?"));
    }

    @Test
    @DisplayName("getSanitizedLength: zero for special chars only")
    void testGetSanitizedLengthSpecialCharsOnly() {
        assertEquals(0, PalindromeValidator.getSanitizedLength("!@#$%^&*()"));
    }
}
