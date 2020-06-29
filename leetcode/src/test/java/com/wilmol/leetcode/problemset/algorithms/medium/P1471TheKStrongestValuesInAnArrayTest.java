package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1471TheKStrongestValuesInAnArrayTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1471TheKStrongestValuesInAnArrayTest {

  private final P1471TheKStrongestValuesInAnArray p1471 = new P1471TheKStrongestValuesInAnArray();

  @ParameterizedTest
  @MethodSource
  void examples(int[] arr, int k, List<Integer> expected) {
    assertThat(p1471.getStrongest(arr, k)).asList().containsExactlyElementsIn(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 4, 5}, 2, ImmutableList.of(5, 1)),
        Arguments.of(new int[] {1, 1, 3, 5, 5}, 2, ImmutableList.of(5, 5)),
        Arguments.of(new int[] {6, 7, 11, 7, 6, 8}, 5, ImmutableList.of(11, 8, 6, 6, 7)),
        Arguments.of(new int[] {6, -3, 7, 2, 11}, 3, ImmutableList.of(-3, 11, 2)),
        Arguments.of(new int[] {-7, 22, 17, 3}, 2, ImmutableList.of(22, 17)));
  }
}
