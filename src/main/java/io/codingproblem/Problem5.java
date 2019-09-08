package io.codingproblem;

import java.util.function.*;

/*
cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair.
For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

Given this implementation of cons:

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair

Implement car and cdr
 */
public class Problem5<T, U, R> {

    public Function<BiFunction<T, U, R>, R> cons(T a, U b) {
        return f -> f.apply(a, b);
    }

    public T car(Function<BiFunction<T, U, T>, T> pair) {
        return pair.apply((a, b) -> a);
    }

    public U cdr(Function<BiFunction<T, U, U>, U> pair) {
        return pair.apply((a, b) -> b);
    }

}
