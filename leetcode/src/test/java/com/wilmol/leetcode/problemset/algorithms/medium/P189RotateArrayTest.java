package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.collect.ImmutableList.toImmutableList;
import static com.google.common.truth.Truth.assertThat;

import com.google.common.primitives.ImmutableIntArray;
import com.wilmol.testlib.TestLib;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P189RotateArrayTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P189RotateArrayTest {

  @ParameterizedTest
  @MethodSource
  void examples(P189RotateArray p189, ImmutableIntArray nums, int k, ImmutableIntArray expected) {
    int[] a = nums.toArray();
    p189.rotate(a, k);
    assertThat(a).asList().containsExactlyElementsIn(expected.asList()).inOrder();
  }

  static Stream<Arguments> examples() {
    return TestLib.cartesianProduct(solutions(), examplesArgs());
  }

  static List<Arguments> examplesArgs() {
    return List.of(
        Arguments.of(
            ImmutableIntArray.of(1, 2, 3, 4, 5, 6, 7),
            3,
            ImmutableIntArray.of(5, 6, 7, 1, 2, 3, 4)),
        Arguments.of(
            ImmutableIntArray.of(-1, -100, 3, 99), 2, ImmutableIntArray.of(3, 99, -1, -100)));
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void kBiggerThanN(P189RotateArray p189) {
    int[] nums = {1, 2};
    p189.rotate(nums, 3);
    assertThat(nums).asList().containsExactly(2, 1).inOrder();
  }

  static List<Arguments> solutions() {
    return Stream.of(new P189RotateArray.CopyArray(), new P189RotateArray.ReverseArray())
        .map(Arguments::of)
        .collect(toImmutableList());
  }
}
