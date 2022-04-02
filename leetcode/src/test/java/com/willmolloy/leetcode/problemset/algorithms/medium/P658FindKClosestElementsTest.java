package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P658FindKClosestElementsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P658FindKClosestElementsTest {

  private final P658FindKClosestElements p658FindKClosestElements = new P658FindKClosestElements();

  @ParameterizedTest
  @MethodSource
  void examples(int[] arr, int k, int x, List<Integer> expected) {
    assertThat(p658FindKClosestElements.findClosestElements(arr, k, x))
        .containsExactlyElementsIn(expected)
        .inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 4, 5}, 4, 3, List.of(1, 2, 3, 4)),
        Arguments.of(new int[] {1, 2, 3, 4, 5}, 4, -1, List.of(1, 2, 3, 4)));
  }
}
