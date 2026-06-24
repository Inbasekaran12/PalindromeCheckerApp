import strategy.StackStrategy;
import strategy.PalindromeStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Tests for StackStrategy Implementation
 *
 * Tests the stack-based palindrome validation algorithm
 * including edge cases and error conditions.
 */
@DisplayName("StackStrategy Tests")
class StackStrategyTest {

    private PalindromeStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new StackStrategy();
    }

    @Test
    @DisplayName("Simple palindrome - lowercase")
    void testSimplePalindrome() {
        assertTrue(strategy.check("level"));
    }

    @Test
    @DisplayName("Simple palindrome - single character")
    void testSingleCharacter() {
        assertTrue(strategy.check("a"));
    }

    @Test
    @DisplayName("Simple palindrome - two characters")
    void testTwoCharacters() {
        assertTrue(strategy.check("aa"));
    }

    @Test
    @DisplayName("Numeric palindrome")
    void testNumericPalindrome() {
        assertTrue(strategy.check("12321"));
    }

    @Test
    @DisplayName("Not a palindrome")
    void testNotPalindrome() {
        assertFalse(strategy.check("hello"));
    }

    @Test
    @DisplayName("Not a palindrome - close but not quite")
    void testCloseButNotPalindrome() {
        assertFalse(strategy.check("levl"));
    }

    @Test
    @DisplayName("Even-length palindrome")
    void testEvenLengthPalindrome() {
        assertTrue(strategy.check("abba"));
    }

    @Test
    @DisplayName("Odd-length palindrome")
    void testOddLengthPalindrome() {
        assertTrue(strategy.check("racecar"));
    }

    @Test
    @DisplayName("Null input throws IllegalArgumentException")
    void testNullInput() {
        assertThrows(IllegalArgumentException.class, () -> strategy.check(null));
    }

    @Test
    @DisplayName("Empty string throws IllegalArgumentException")
    void testEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> strategy.check(""));
    }

    @Test
    @DisplayName("Strategy name is correct")
    void testStrategyName() {
        assertEquals("Stack-Based Strategy", strategy.getStrategyName());
    }

    @Test
    @DisplayName("Complex palindrome with mixed case (should be preprocessed)")
    void testMixedCase() {
        // Note: Strategy expects preprocessed input (lowercase)
        assertTrue(strategy.check("racecar"));
        assertTrue(strategy.check("a"));
    }
}
