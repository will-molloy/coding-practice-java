package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.primitives.Ints;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P870AdvantageShuffleTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P870AdvantageShuffleTest {

  private final P870AdvantageShuffle p870AdvantageShuffle = new P870AdvantageShuffle();

  @ParameterizedTest
  @MethodSource
  void examples(int[] a, int[] b, List<Integer> expected) {
    assertThat(p870AdvantageShuffle.advantageCount(a, b))
        .asList()
        .containsExactlyElementsIn(expected)
        .inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {2, 7, 11, 15}, new int[] {1, 10, 4, 11}, Ints.asList(2, 11, 7, 15)),
        Arguments.of(
            new int[] {12, 24, 8, 32}, new int[] {13, 25, 32, 11}, Ints.asList(24, 32, 8, 12)));
  }
}
