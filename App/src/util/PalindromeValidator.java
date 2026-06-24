package util;

/**
 * CLASS - PalindromeValidator
 *
 * Utility class for palindrome input validation and sanitization.
 * Handles preprocessing of strings to ensure proper palindrome checking.
 *
 * Features:
 * - Removes spaces and special characters
 * - Converts to lowercase for case-insensitive checking
 * - Validates input format
 *
 * @author Inbasekaran S
 * @version 2.0
 */
public class PalindromeValidator {

    /**
     * Removes all non-alphanumeric characters and converts to lowercase.
     *
     * @param input The raw input string
     * @return Sanitized string with only alphanumeric characters in lowercase
     * @throws IllegalArgumentException if input is null
     */
    public static String sanitize(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        // Remove all non-alphanumeric characters and convert to lowercase
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    /**
     * Validates if the input string can be checked for palindrome.
     *
     * @param input The input string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }

        // After sanitization, should have at least 1 character
        String sanitized = input.replaceAll("[^a-zA-Z0-9]", "");
        return sanitized.length() > 0;
    }

    /**
     * Gets the length of the input after sanitization.
     *
     * @param input The input string
     * @return Length of sanitized string
     */
    public static int getSanitizedLength(String input) {
        return sanitize(input).length();
    }
}
