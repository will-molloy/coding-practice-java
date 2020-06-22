package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2019-12-15. */
class P509FibonacciNumberTest {

  private final P509FibonacciNumber fun = new P509FibonacciNumber();

  @ParameterizedTest
  @MethodSource("test")
  void test(int n, int fn) {
    assertThat(fun.fib(n)).isEqualTo(fn);
  }

  static Stream<Arguments> test() {
    return Stream.of(
        Arguments.of(0, 0),
        Arguments.of(1, 1),
        Arguments.of(2, 1),
        Arguments.of(3, 2),
        Arguments.of(4, 3));
  }
}
