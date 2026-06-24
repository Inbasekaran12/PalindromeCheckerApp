import strategy.PalindromeStrategy;
import strategy.StackStrategy;
import strategy.TwoPointerStrategy;
import util.PalindromeValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration Tests for PalindromeCheckerApp
 *
 * Tests the overall application functionality and integration
 * between different components.
 */
@DisplayName("PalindromeCheckerApp Integration Tests")
class PalindromeCheckerAppTest {

    @Test
    @DisplayName("Verify both strategies produce consistent results")
    void testStrategiesConsistency() {
        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy twoPointerStrategy = new TwoPointerStrategy();

        String[] testCases = {
            "level",
            "racecar",
            "hello",
            "12321",
            "abcba"
        };

        for (String testCase : testCases) {
            boolean result1 = stackStrategy.check(testCase);
            boolean result2 = twoPointerStrategy.check(testCase);
            assertEquals(result1, result2, 
                        "Strategies should produce same result for: " + testCase);
        }
    }

    @Test
    @DisplayName("Full workflow: sanitize and check palindrome")
    void testFullWorkflow() {
        String input = "A man, a plan, a canal: Panama";
        
        // Validate
        assertTrue(PalindromeValidator.isValidInput(input));
        
        // Sanitize
        String sanitized = PalindromeValidator.sanitize(input);
        assertEquals("amanaplanacanalpanama", sanitized);
        
        // Check with strategy
        PalindromeStrategy strategy = new TwoPointerStrategy();
        boolean result = strategy.check(sanitized);
        assertTrue(result);
    }

    @Test
    @DisplayName("Complex palindrome handling")
    void testComplexPalindromes() {
        String[] complexPalindromes = {
            "Was it a car or a cat I saw?",
            "Madam, I'm Adam",
            "12321",
            "A1B1A"
        };

        for (String palindrome : complexPalindromes) {
            assertTrue(PalindromeValidator.isValidInput(palindrome),
                      "Should be valid: " + palindrome);
            
            String sanitized = PalindromeValidator.sanitize(palindrome);
            assertTrue(new TwoPointerStrategy().check(sanitized),
                      "Should be palindrome: " + palindrome);
        }
    }

    @Test
    @DisplayName("Non-palindromes are correctly identified")
    void testNonPalindromes() {
        String[] nonPalindromes = {
            "hello",
            "world",
            "java",
            "12345"
        };

        PalindromeStrategy strategy = new TwoPointerStrategy();
        for (String nonPalindrome : nonPalindromes) {
            String sanitized = PalindromeValidator.sanitize(nonPalindrome);
            assertFalse(strategy.check(sanitized),
                       "Should not be palindrome: " + nonPalindrome);
        }
    }

    @Test
    @DisplayName("Error handling for invalid inputs")
    void testErrorHandling() {
        assertThrows(IllegalArgumentException.class, 
                    () -> new StackStrategy().check(null));
        
        assertThrows(IllegalArgumentException.class, 
                    () -> new TwoPointerStrategy().check(null));
        
        assertFalse(PalindromeValidator.isValidInput(null));
        assertFalse(PalindromeValidator.isValidInput(""));
    }

    @Test
    @DisplayName("Performance: StackStrategy vs TwoPointerStrategy")
    void testPerformanceComparison() {
        String testString = "amanaplanacanalpanama";
        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy twoPointerStrategy = new TwoPointerStrategy();

        // Run 1000 iterations for warm-up
        for (int i = 0; i < 1000; i++) {
            stackStrategy.check(testString);
            twoPointerStrategy.check(testString);
        }

        // Measure StackStrategy
        long startStack = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            stackStrategy.check(testString);
        }
        long endStack = System.nanoTime();
        long stackTime = endStack - startStack;

        // Measure TwoPointerStrategy
        long startTwoPointer = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            twoPointerStrategy.check(testString);
        }
        long endTwoPointer = System.nanoTime();
        long twoPointerTime = endTwoPointer - startTwoPointer;

        // TwoPointer should be faster or similar
        assertTrue(twoPointerTime <= stackTime * 1.5,
                  "TwoPointer should be comparable or faster");
    }

    @Test
    @DisplayName("Strategy names are retrievable")
    void testStrategyNames() {
        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy twoPointerStrategy = new TwoPointerStrategy();

        assertEquals("Stack-Based Strategy", stackStrategy.getStrategyName());
        assertEquals("Two-Pointer Strategy", twoPointerStrategy.getStrategyName());
    }
}
