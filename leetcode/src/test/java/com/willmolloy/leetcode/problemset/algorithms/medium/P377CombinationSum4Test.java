package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.testlib.CartesianProduct;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P377CombinationSum4Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P377CombinationSum4Test {

  @ParameterizedTest
  @MethodSource
  void examples(P377CombinationSum4 p377CombinationSum4, int[] nums, int target, int expected) {
    assertThat(p377CombinationSum4.combinationSum4(nums, target)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return CartesianProduct.cartesianProduct(solutions(), exampleArgs());
  }

  private static Stream<Arguments> exampleArgs() {
    return Stream.of(Arguments.of(new int[] {1, 2, 3}, 4, 7), Arguments.of(new int[] {9}, 3, 0));
  }

  private static Stream<P377CombinationSum4> solutions() {
    return Stream.of(
        new P377CombinationSum4.TopDownRecursive(), new P377CombinationSum4.BottomUpDp());
  }
}
