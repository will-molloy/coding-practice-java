package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1470ShuffleTheArrayTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1470ShuffleTheArrayTest {

  private final P1470ShuffleTheArray p1470 = new P1470ShuffleTheArray();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int n, List<Integer> expected) {
    assertThat(p1470.shuffle(nums, n)).asList().containsExactlyElementsIn(expected).inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {2, 5, 1, 3, 4, 7}, 3, List.of(2, 3, 5, 4, 1, 7)),
        Arguments.of(new int[] {1, 2, 3, 4, 4, 3, 2, 1}, 4, List.of(1, 4, 2, 3, 3, 2, 4, 1)),
        Arguments.of(new int[] {1, 1, 2, 2}, 2, List.of(1, 2, 1, 2)));
  }
}
