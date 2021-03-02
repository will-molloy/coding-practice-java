package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.testlib.TestLib.cartesianProduct;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P645SetMismatchTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P645SetMismatchTest {

  @ParameterizedTest
  @MethodSource
  void examples(
      P645SetMismatch p645SetMismatch, int[] nums, int expectedDuplicate, int expectedMissing) {
    assertThat(p645SetMismatch.findErrorNums(nums))
        .asList()
        .containsExactly(expectedDuplicate, expectedMissing)
        .inOrder();
  }

  static Stream<Arguments> examples() {
    return cartesianProduct(solutions(), examplesArgs());
  }

  static Stream<Arguments> examplesArgs() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 2, 4}, 2, 3), Arguments.of(new int[] {1, 1}, 1, 2));
  }

  static Stream<P645SetMismatch> solutions() {
    return Stream.of(new P645SetMismatch.LinearSpace(), new P645SetMismatch.ConstantSpace());
  }
}
