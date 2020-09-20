package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1291SequentialDigitsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1291SequentialDigitsTest {

  private final P1291SequentialDigits p1291 = new P1291SequentialDigits();

  @ParameterizedTest
  @MethodSource
  void examples(int low, int high, List<Integer> expected) {
    assertThat(p1291.sequentialDigits(low, high)).containsExactlyElementsIn(expected).inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(100, 300, ImmutableList.of(123, 234)),
        Arguments.of(1000, 13000, ImmutableList.of(1234, 2345, 3456, 4567, 5678, 6789, 12345)));
  }
}
