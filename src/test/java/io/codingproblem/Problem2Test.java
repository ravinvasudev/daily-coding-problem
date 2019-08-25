package io.codingproblem;

import java.util.stream.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem2Test {

    @Test
    public void edgeCaseTest() {
        // edge case
        Assertions.assertNull(Problem2.multiplyArrayItemsExceptIthPositionWithSpecialCase(null));
        Assertions.assertNull(Problem2.multiplyArrayItemsExceptIthPositionWithSpecialCase(IntStream.of().toArray()));
    }

    @Test
    public void noZeroTest() {
        int[] result = Problem2.multiplyArrayItemsExceptIthPositionWithSpecialCase(IntStream.of(1, 2, 3).toArray());

        Assertions.assertArrayEquals(IntStream.of(6, 3, 2).toArray(), result);
    }

    @Test
    public void oneZeroTest() {
        // with one zero
        int[] result = Problem2.multiplyArrayItemsExceptIthPositionWithSpecialCase(IntStream.of(0, 3, 2).toArray());

        Assertions.assertArrayEquals(IntStream.of(6, 0, 0).toArray(), result);
    }

    @Test
    public void twoZeroTest() {
        // with two zeros
        int[] result = Problem2.multiplyArrayItemsExceptIthPositionWithSpecialCase(IntStream.of(0, 3, 3, 0).toArray());

        Assertions.assertArrayEquals(IntStream.of(0, 0, 0, 0).toArray(), result);
    }

    @Test
    public void allZerosTest() {
        // with zero
        int[] r = Problem2.multiplyArrayItemsExceptIthPositionWithSpecialCase(IntStream.of(0, 0, 0).toArray());

        Assertions.assertArrayEquals(IntStream.of(0, 0, 0).toArray(), r);
    }
}
