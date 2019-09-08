package io.codingproblem;

import java.util.function.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem5Test {

    @Test
    public void test() {
        Problem5<Integer, Integer, Integer> problem = new Problem5<>();
        Function<BiFunction<Integer, Integer, Integer>, Integer> pair = problem.cons(1, 2);

        Integer car = problem.car(pair);
        Integer cdr = problem.cdr(pair);

        Assertions.assertEquals(1, car);
        Assertions.assertEquals(2, cdr);

    }
}
