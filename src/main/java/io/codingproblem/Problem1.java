package io.codingproblem;

import java.util.*;

/**
 * Given a list of numbers and sum value, return whether any two numbers from the list add up to sum.
 * <p>
 * For example, given [10, 15, 3, 7] and sum = 17, return true since 10 + 7 is 17.
 * <p>
 * Bonus: Can you do this in one pass?
 */
public class Problem1 {

    public static void main(String[] args) {
        int[] numbers = {10, 15, 3, 7};
        int sum = 9;

        boolean result = findTwoNumbersSum(numbers, sum);
        System.out.println("result: " + result);
    }

    protected static boolean findTwoNumbersSum(int[] numbers, int sum) {
        // edge cases - worth to mention during interviews
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        // ds to hold visited numbers from list
        Set<Integer> visitedNumbers = new HashSet<>();

        // iterate through the array - only 1 pass is enough
        for (int i = 0; i < numbers.length; i++) {

            // check & return true if (sum - current index number) already seen
            if (visitedNumbers.contains(sum - numbers[i])) {
                return true;
            }
            // add current seen number
            visitedNumbers.add(numbers[i]);
        }
        // there are no 2 numbers in list to form sum if we reach this point
        return false;
    }

}