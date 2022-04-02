package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P923ThreeSumWithMultiplicityTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P923ThreeSumWithMultiplicityTest {

  private final P923ThreeSumWithMultiplicity p923ThreeSumWithMultiplicity =
      new P923ThreeSumWithMultiplicity();

  @ParameterizedTest
  @MethodSource
  void examples(int[] arr, int target, int expected) {
    assertThat(p923ThreeSumWithMultiplicity.threeSumMulti(arr, target)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8, 20),
        Arguments.of(new int[] {1, 1, 2, 2, 2, 2}, 5, 12));
  }

  @Test
  void intOverflow() {
    assertThat(p923ThreeSumWithMultiplicity.threeSumMulti(new int[3000], 0)).isEqualTo(495500972);
  }
}
