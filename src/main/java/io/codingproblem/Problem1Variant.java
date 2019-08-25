package io.codingproblem;

import java.util.*;

/**
 * Instead of returning true/false, return the position of two numbers from the list which add up to sum.
 *
 * For example, given [10, 15, 3, 7] and sum = 17, return [0, 3] since 10 + 7 is 17, otherwise return [-1, -1]
 */
public class Problem1Variant {

    public static void main(String[] args) {
        int[] numbers = {10, 15, 3, 7};
        int sum = 17;

        int[] result = findPositionTwoNumbersSum(numbers, sum);
        System.out.println("result: " + result);
    }

    protected static int[] findPositionTwoNumbersSum(int[] numbers, int sum) {
        // edge cases - worth to mention during interviews
        if (numbers == null || numbers.length == 0) {
            return new int[] {-1, -1};
        }

        // ds to hold visited numbers from list and it's position
        Map<Integer, Integer> visitedNumbers = new HashMap<>();

        // iterate through the array - only 1 pass is enough
        for (int i = 0; i < numbers.length; i++) {

            // check if (sum - current index number) already seen
            // and return visited number position from map and current index
            if (visitedNumbers.containsKey(sum - numbers[i])) {
                return new int[] {visitedNumbers.get(sum - numbers[i]), i};
            }
            // add current seen number & position
            visitedNumbers.put(numbers[i], i);
        }
        // there are no 2 numbers in list to form sum if we reach this point
        return new int[] {-1, -1};
    }

}