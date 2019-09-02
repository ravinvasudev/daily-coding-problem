package io.codingproblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem4Test {

    @Test
    public void allZeros() {
        int[] items = {0, 0, 0, 0};
        int actual = Problem4.twoArrayApproach(items);

        Assertions.assertEquals(1, actual);
    }

    @Test
    public void allPositiveNumbers() {
        int[] items = {1, 4, 3, 1, 4};
        int actual = Problem4.twoArrayApproach(items);

        Assertions.assertEquals(2, actual);
    }

    @Test
    public void allNegativeNumbers() {
        int[] items = {-1, -2, -3, -4};
        int actual = Problem4.twoArrayApproach(items);

        Assertions.assertEquals(1, actual);
    }

    @Test
    public void mixedNumbers() {
        int[] items = {3, -4, -1, 1};
        int actual = Problem4.twoArrayApproach(items);

        Assertions.assertEquals(2, actual);
    }

    @Test
    public void onlyOneNumber() {
        int[] items = {2};
        int actual = Problem4.twoArrayApproach(items);

        Assertions.assertEquals(1, actual);
    }

    @Test
    public void sortedPositiveNumbers() {
        int[] items = {1, 2, 3, 4, 5, 6};
        int actual = Problem4.twoArrayApproach(items);

        Assertions.assertEquals(7, actual);
    }

    @Test
    public void onePositiveOneNegativeNumber() {
        int[] items = {1, -1};
        int actual = Problem4.twoArrayApproach(items);

        Assertions.assertEquals(2, actual);
    }

    @Test
    public void largeNumbers() {
        int[] items = {223, 732, 3232, 231, 2324, 623};
        int actual = Problem4.twoArrayApproach(items);

        Assertions.assertEquals(1, actual);
    }

}
