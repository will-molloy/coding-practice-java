package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.primitives.ImmutableIntArray;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P228SummaryRangesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P228SummaryRangesTest {

  private final P228SummaryRanges p228 = new P228SummaryRanges();

  @ParameterizedTest
  @MethodSource
  void examples(ImmutableIntArray nums, List<String> expected) {
    assertThat(p228.summaryRanges(nums.toArray())).containsExactlyElementsIn(expected).inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(ImmutableIntArray.of(0, 1, 2, 4, 5, 7), List.of("0->2", "4->5", "7")),
        Arguments.of(ImmutableIntArray.of(0, 2, 3, 4, 6, 8, 9), List.of("0", "2->4", "6", "8->9")),
        Arguments.of(ImmutableIntArray.of(), List.of()),
        Arguments.of(ImmutableIntArray.of(-1), List.of("-1")),
        Arguments.of(ImmutableIntArray.of(0), List.of("0")));
  }
}
