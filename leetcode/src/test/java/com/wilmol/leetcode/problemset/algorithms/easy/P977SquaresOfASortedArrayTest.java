package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P977SquaresOfASortedArrayTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P977SquaresOfASortedArrayTest {

  private final P977SquaresOfASortedArray p977 = new P977SquaresOfASortedArray();

  @ParameterizedTest
  @MethodSource
  void examples(int[] a, List<Integer> expected) {
    assertThat(p977.sortedSquares(a)).asList().containsExactlyElementsIn(expected).inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {-4, -1, 0, 3, 10}, ImmutableList.of(0, 1, 9, 16, 100)),
        Arguments.of(new int[] {-7, -3, 2, 3, 11}, ImmutableList.of(4, 9, 9, 49, 121)));
  }

  @Test
  void needIndexCheckWhenFindingStartOfPositiveRegion() {
    assertThat(p977.sortedSquares(new int[] {-1})).asList().containsExactly(1);
  }
}
