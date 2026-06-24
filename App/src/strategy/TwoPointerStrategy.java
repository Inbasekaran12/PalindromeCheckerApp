package strategy;

/**
 * CLASS - TwoPointerStrategy
 *
 * Two-pointer palindrome validation implementation.
 * Uses two pointers moving from both ends towards the center.
 *
 * Algorithm:
 * 1. Initialize left pointer at start and right pointer at end
 * 2. Compare characters at both pointers
 * 3. Move pointers towards center
 * 4. If all match, it's a palindrome
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) - Most efficient
 *
 * @author Inbasekaran S
 * @version 2.0
 */
public class TwoPointerStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) throws IllegalArgumentException {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    @Override
    public String getStrategyName() {
        return "Two-Pointer Strategy";
    }
}
