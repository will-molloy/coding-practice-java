package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P967NumbersWithSameConsecutiveDifferencesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P967NumbersWithSameConsecutiveDifferencesTest {

  private final P967NumbersWithSameConsecutiveDifferences p967 =
      new P967NumbersWithSameConsecutiveDifferences();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int k, Set<Integer> expected) {
    assertThat(p967.numsSameConsecDiff(n, k)).asList().containsExactlyElementsIn(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(3, 7, ImmutableSet.of(181, 292, 707, 818, 929)),
        Arguments.of(
            2,
            1,
            ImmutableSet.of(10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98)));
  }

  @Test
  void nEquals0() {
    assertThat(p967.numsSameConsecDiff(0, 9))
        .asList()
        .containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
  }

  @Test
  void kEquals0() {
    assertThat(p967.numsSameConsecDiff(9, 0))
        .asList()
        .containsExactly(
            111111111, 222222222, 333333333, 444444444, 555555555, 666666666, 777777777, 888888888,
            999999999);
  }
}
