package strategy;

import java.util.Stack;

/**
 * CLASS - StackStrategy
 *
 * Stack-based palindrome validation implementation.
 * Uses a LIFO (Last-In-First-Out) data structure to compare characters.
 *
 * Algorithm:
 * 1. Push the first half of characters onto the stack
 * 2. Pop from stack and compare with second half
 * 3. If all match, it's a palindrome
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author Inbasekaran S
 * @version 2.0
 */
public class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) throws IllegalArgumentException {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        Stack<Character> stack = new Stack<>();
        int length = input.length();

        // Push first half of the string onto stack
        for (int i = 0; i < length / 2; i++) {
            stack.push(input.charAt(i));
        }

        // For odd-length strings, skip the middle character
        int startIndex = (length % 2 == 0) ? length / 2 : length / 2 + 1;

        // Compare second half with popped characters from stack
        for (int i = startIndex; i < length; i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getStrategyName() {
        return "Stack-Based Strategy";
    }
}
