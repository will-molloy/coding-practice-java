package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P347TopKFrequentElementsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P347TopKFrequentElementsTest {

  private final P347TopKFrequentElements p347 = new P347TopKFrequentElements();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int k, List<Integer> expected) {
    assertThat(p347.topKFrequent(nums, k)).asList().containsExactlyElementsIn(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 1, 1, 2, 2, 3}, 2, ImmutableList.of(1, 2)),
        Arguments.of(new int[] {1}, 1, ImmutableList.of(1)));
  }
}
