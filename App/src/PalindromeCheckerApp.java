import strategy.PalindromeStrategy;
import strategy.StackStrategy;
import strategy.TwoPointerStrategy;
import util.PalindromeValidator;

/**
 * MAIN CLASS - PalindromeCheckerApp
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This application demonstrates and compares the performance of multiple
 * palindrome validation algorithms using the Strategy design pattern.
 *
 * Features:
 * - Input validation and sanitization (removes spaces, special chars)
 * - Case-insensitive palindrome checking
 * - Multiple strategy implementations
 * - Performance benchmarking and comparison
 * - Error handling with descriptive messages
 *
 * Strategies Implemented:
 * 1. StackStrategy: Uses a Stack for comparison
 * 2. TwoPointerStrategy: Uses two-pointer approach (most efficient)
 *
 * Example Usage:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true (after sanitization to "amanaplanacanalpanama")
 *
 * @author Inbasekaran S
 * @version 2.0
 */
public class PalindromeCheckerApp {

    /**
     * Application entry point.
     *
     * Demonstrates palindrome checking with different strategies,
     * includes performance metrics and detailed output.
     *
     * @param args Command-line arguments (not used in this version)
     */
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("PALINDROME CHECKER - PERFORMANCE COMPARISON");
        System.out.println("=".repeat(60));

        // Test cases
        String[] testCases = {
            "Level",
            "A man, a plan, a canal: Panama",
            "Was it a car or a cat I saw?",
            "Hello World",
            "racecar",
            "121"
        };

        // Initialize strategies
        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy twoPointerStrategy = new TwoPointerStrategy();

        // Test each case
        for (String testCase : testCases) {
            System.out.println("\n" + "-".repeat(60));
            testPalindromeWithStrategies(testCase, stackStrategy, twoPointerStrategy);
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("Analysis completed successfully!");
        System.out.println("=".repeat(60));
    }

    /**
     * Tests a palindrome string with multiple strategies and compares performance.
     *
     * @param input The input string to test
     * @param strategy1 First strategy implementation
     * @param strategy2 Second strategy implementation
     */
    private static void testPalindromeWithStrategies(
            String input,
            PalindromeStrategy strategy1,
            PalindromeStrategy strategy2) {

        System.out.println("Original Input: \"" + input + "\"");

        // Validate input
        if (!PalindromeValidator.isValidInput(input)) {
            System.out.println("ERROR: Input contains no alphanumeric characters!");
            return;
        }

        // Sanitize input
        String sanitized = PalindromeValidator.sanitize(input);
        System.out.println("Sanitized Input: \"" + sanitized + "\"");

        try {
            // Test with Strategy 1 (Stack)
            long startTime1 = System.nanoTime();
            boolean result1 = strategy1.check(sanitized);
            long endTime1 = System.nanoTime();
            long executionTime1 = endTime1 - startTime1;

            // Test with Strategy 2 (Two-Pointer)
            long startTime2 = System.nanoTime();
            boolean result2 = strategy2.check(sanitized);
            long endTime2 = System.nanoTime();
            long executionTime2 = endTime2 - startTime2;

            // Display results
            System.out.println("\nResults:");
            System.out.println("  " + strategy1.getStrategyName() + ":");
            System.out.println("    - Is Palindrome: " + result1);
            System.out.println("    - Execution Time: " + executionTime1 + " ns");

            System.out.println("  " + strategy2.getStrategyName() + ":");
            System.out.println("    - Is Palindrome: " + result2);
            System.out.println("    - Execution Time: " + executionTime2 + " ns");

            // Performance comparison
            long difference = Math.abs(executionTime1 - executionTime2);
            String faster = executionTime1 < executionTime2 ? strategy1.getStrategyName() : strategy2.getStrategyName();
            System.out.println("\nPerformance Comparison:");
            System.out.println("  - Faster Algorithm: " + faster);
            System.out.println("  - Time Difference: " + difference + " ns");

        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
