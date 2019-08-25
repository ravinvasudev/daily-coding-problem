package io.codingproblem;

/*
    Given an array of integers, return a new array such that each element at index i of the new array is the product of
    all the numbers in the original array except the one at i.

    For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was
    [3, 2, 1], the expected output would be [2, 3, 6].

    Follow-up: what if you can't use division?
 */
public class Problem2 {

    public static void main(String[] args) {
        int[] items = {0, 1, 1};

        int[] newItems = multiplyArrayItemsExceptIthPosition(items);
        printArrayItems(newItems);

//        int[] newItemsBruteForce = multiplyArrayItemsExceptIthPositionBruteForce(items);
//        printArrayItems(newItemsBruteForce);
    }

    // O(n) solution with division approach
    // removed certain conditions to help understand the logic
    // follow next method for complete functionality
    private static int[] multiplyArrayItemsExceptIthPosition(int[] items) {
        // edge cases
        if (items == null || items.length == 0) {
            return null;
        }

        // using auxiliary space of n
        int[] newItems = new int[items.length];
        int product = 1;

        // O(n)
        for (int i = 0; i < items.length; i++) {
            product *= items[i];
        }
        // O(n)
        for (int i = 0; i < items.length; i++) {
            newItems[i] = product / items[i];
        }
        return newItems;
    }

    // O(n) solution with division approach and special case of zeros
    protected static int[] multiplyArrayItemsExceptIthPositionWithSpecialCase(int[] items) {
        // edge cases
        if (items == null || items.length == 0) {
            return null;
        }

        int[] newItems = new int[items.length];
        int zeroCount = 0;
        int product = 1;

        // iterate through array, calculate product of items except if it's zero and count number of zeros
        for (int i = 0; i < items.length; i++) {
            if (items[i] == 0) {
                zeroCount++;
            } else {
                product *= items[i];
            }
        }

        // if no zero appears, calculate new array values by dividing the product with current index value in original
        // array
        if (zeroCount == 0) {
            for (int i = 0; i < items.length; i++) {
                newItems[i] = product / items[i];
            }
            return newItems;
        }

        // if zero appears just once, then that index in new array will contain product of all other items and other
        // indices will have all zero
        if (zeroCount == 1) {
            for (int i = 0; i < items.length; i++) {
                if (items[i] == 0) {
                    newItems[i] = product;
                } else {
                    newItems[i] = 0;
                }
            }
            return newItems;
        }

        // you will reach here only if zero appears more than once, in that case new array will have all zeros
        for (int i = 0; i < items.length; i++) {
            newItems[i] = 0;
        }
        return newItems;
    }

    // O(n ^ 2) solution without division approach
    protected static int[] multiplyArrayItemsExceptIthPositionBruteForce(int[] items) {
        // edge cases
        if (items == null || items.length == 0) {
            return null;
        }

        int[] newItems = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            int m = 1;
            for (int j = 0; j < items.length; j++) {
                if (i == j) {
                    continue;
                }
                m *= items[j];
            }
            newItems[i] = m;
        }
        return newItems;
    }

    // util method to print array items
    private static void printArrayItems(int[] items) {
        if (items != null && items.length != 0) {
            for (int i = 0; i < items.length; i++) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();
    }
}