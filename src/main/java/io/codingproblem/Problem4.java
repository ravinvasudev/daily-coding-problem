package io.codingproblem;

import java.util.*;

/*
    Given an array of integers, find the first missing positive integer in linear time and constant space.
    In other words, find the lowest positive integer that does not exist in the array.
    The array can contain duplicates and negative numbers as well.

    For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

    You can modify the input array in-place.
*/
public class Problem4 {

    public static void main(String[] args) {
        int[] a = {2, 7, 3, 1, 4, 6};
        System.out.println(naiveApproach(a));
        System.out.println(sortingApproach(a));
        System.out.println(hashingApproach(a));
        System.out.println(twoArrayApproach(a));
    }

    // O(N^2) + constant space
    protected static int naiveApproach(int[] items) {
        int min = 1;
        int newmin = 1;
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items.length; j++) {
                if (min == items[j]) {
                    newmin = min + 1;
                    break;
                }
            }
            if (min != newmin) {
                min = newmin;
            } else {
                break;
            }
        }
        return newmin;
    }

    // O(N log(N)) for Sorting + O(N) + constant space
    protected static int sortingApproach(int[] items) {
        //3,2,-1,1,4,6
        Arrays.sort(items);
        //-1,1,2,3,4,6

        int min = 1;
        for (int i = 0; i < items.length; i++) {
            if (items[i] > 0) {
                if (min == items[i]) {
                    min++;
                } else {
                    break;
                }
            }
        }
        return min;
    }

    // O(N) + N extra space
    protected static int hashingApproach(int[] items) {

        Map<Integer, Integer> map = new HashMap<>();

        // O(N)
        for (int i = 0; i < items.length; i++) {
            if (items[i] > 0) {
                map.put(items[i], -1);
            }
        }

        int min = 1;
        for (Integer item : map.keySet()) {
            if (min == item) {
                min++;
            } else {
                break;
            }
        }
        return min;

    }

    // O(N) + M extra space
    protected static int twoArrayApproach(int[] items) {

        // O(N) - Find max value
        int max = Arrays.stream(items).max().getAsInt();

        if(max < 0) {
            return 1;
        }

        int[] a2 = new int[max + 1];

        // O(N)
        for (int i = 0; i < items.length; i++) {
            if (items[i] > 0) {
                a2[items[i]] = 1;
            }
        }

        // O(N)
        for (int i = 1; i < a2.length; i++) {
            if (a2[i] == 0) {
                return i;
            }
        }
        return a2.length;
    }

    // O(N) + constant extra space
    protected static int inPlaceApproach(int[] items) {
        // 3, 2, 0
        return -1;
    }
}
