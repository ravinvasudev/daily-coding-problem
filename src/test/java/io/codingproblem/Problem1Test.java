package io.codingproblem;

import java.util.stream.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem1Test {

    @Test
    public void test() {

        // edge case
        Assertions.assertFalse(Problem1.findTwoNumbersSum(null, 1));
        Assertions.assertFalse(Problem1.findTwoNumbersSum(IntStream.of().toArray(), 1));

        // with zero
        Assertions.assertTrue(Problem1.findTwoNumbersSum(IntStream.of(5, 0, 6, 7, 0, 0, 8).toArray(), 15));

        // with positive numbers
        Assertions.assertTrue(Problem1.findTwoNumbersSum(IntStream.of(10, 5, 3, 7).toArray(), 17));
        Assertions.assertTrue(Problem1.findTwoNumbersSum(IntStream.of(25, 16, 7, 18).toArray(), 32));

        // with negative numbers
        Assertions.assertTrue(Problem1.findTwoNumbersSum(IntStream.of(-1, 3, -8, 2).toArray(), -9));
        Assertions.assertTrue(Problem1.findTwoNumbersSum(IntStream.of(3, -5, -6, -7, 9).toArray(), -11));

        // with positive numbers
        Assertions.assertFalse(Problem1.findTwoNumbersSum(IntStream.of(10, 6, 4, 8, 6).toArray(), 34));
        Assertions.assertFalse(Problem1.findTwoNumbersSum(IntStream.of(23, 56, 12, 23).toArray(), 23));

        // with negative numbers
        Assertions.assertFalse(Problem1.findTwoNumbersSum(IntStream.of(-2, 8, -1, 5, -4).toArray(), 12));
        Assertions.assertFalse(Problem1.findTwoNumbersSum(IntStream.of(-15, 6, 3, -10, 2).toArray(), 23));
    }
}
