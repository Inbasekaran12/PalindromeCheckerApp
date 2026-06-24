
/**
 * Unit Tests for TwoPointerStrategy Implementation
 *
 * Tests the two-pointer palindrome validation algorithm
 * including edge cases and error conditions.
 */
@DisplayName("TwoPointerStrategy Tests")
class TwoPointerStrategyTest {

    private PalindromeStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new TwoPointerStrategy();
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
    @DisplayName("Long palindrome")
    void testLongPalindrome() {
        assertTrue(strategy.check("amanaplanacanalpanama"));
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
        assertEquals("Two-Pointer Strategy", strategy.getStrategyName());
    }

    @Test
    @DisplayName("Performance: Two-pointer should be efficient")
    void testPerformance() {
        String longString = "a".repeat(10000) + "b" + "a".repeat(10000);
        long startTime = System.nanoTime();
        boolean result = strategy.check(longString);
        long endTime = System.nanoTime();

        assertFalse(result);
        // Should complete in reasonable time (< 100 microseconds)
        assertTrue((endTime - startTime) < 100000);
    }
}
