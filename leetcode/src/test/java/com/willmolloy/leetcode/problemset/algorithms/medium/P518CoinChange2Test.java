package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P518CoinChange2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P518CoinChange2Test {

  @ParameterizedTest
  @MethodSource("funs")
  void example1(P518CoinChange2 fun) {
    assertThat(fun.change(5, new int[] {1, 2, 5})).isEqualTo(4);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example2(P518CoinChange2 fun) {
    assertThat(fun.change(3, new int[] {2})).isEqualTo(0);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example3(P518CoinChange2 fun) {
    assertThat(fun.change(10, new int[] {10})).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example1CoinsUnsorted(P518CoinChange2 fun) {
    assertThat(fun.change(5, new int[] {5, 1, 2})).isEqualTo(4);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void zeroAmount(P518CoinChange2 fun) {
    assertThat(fun.change(0, new int[] {1, 2, 3})).isEqualTo(1);
  }

  static Stream<P518CoinChange2> funs() {
    return Stream.of(new P518CoinChange2.InitialDp(), new P518CoinChange2.OptimisedDp());
  }
}
