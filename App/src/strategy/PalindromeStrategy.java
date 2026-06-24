package strategy;

/**
 * INTERFACE - PalindromeStrategy
 *
 * Defines the contract for palindrome validation strategies.
 * Implementations should provide different algorithms for checking
 * whether a given string is a palindrome.
 *
 * @author Inbasekaran S
 * @version 2.0
 */
public interface PalindromeStrategy {

    /**
     * Checks if the provided string is a palindrome.
     *
     * @param input The string to validate (should be pre-processed)
     * @return true if the input is a palindrome, false otherwise
     * @throws IllegalArgumentException if input is null or empty
     */
    boolean check(String input) throws IllegalArgumentException;

    /**
     * Returns the name of the strategy implementation.
     *
     * @return The strategy name
     */
    String getStrategyName();
}
