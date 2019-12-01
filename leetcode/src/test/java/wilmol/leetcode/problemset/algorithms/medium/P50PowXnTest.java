package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2019-12-01. */
class P50PowXnTest {

  @ParameterizedTest
  @MethodSource("testLinear")
  void testLinear(double x, int n, double expected) {
    P50PowXn fun = new P50PowXn.LinearRecursive();
    assertThat(fun.myPow(x, n)).isWithin(0.1).of(expected);
  }

  static Stream<Arguments> testLinear() {
    return Stream.of(
        Arguments.of(2, 10, 1024), Arguments.of(2.1, 3, 9.261), Arguments.of(2, -2, 0.25));
  }

  @ParameterizedTest
  @MethodSource("testLog2")
  void testLog2(double x, int n, double expected) {
    P50PowXn fun = new P50PowXn.Log2Recursive();
    assertThat(fun.myPow(x, n)).isWithin(0.1).of(expected);
  }

  static Stream<Arguments> testLog2() {
    return Stream.of(
        Arguments.of(2, 10, 1024),
        Arguments.of(2.1, 3, 9.261),
        Arguments.of(2, -2, 0.25),
        Arguments.of(1, Integer.MAX_VALUE, 1),
        Arguments.of(1, Integer.MIN_VALUE, 1));
  }
}
