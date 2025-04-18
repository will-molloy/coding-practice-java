package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * P15ThreeSumTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P15ThreeSumTest {

  private final P15ThreeSum function = new P15ThreeSum();

  @Test
  void example() {
    assertThat(function.threeSum(new int[] {-1, 0, 1, 2, -1, -4}))
        .containsExactly(Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2));
  }

  @Test
  void duplicatesZeroes() {
    assertThat(function.threeSum(new int[] {1, 0, 0, 0, 3, 4, -2}))
        .containsExactly(Arrays.asList(0, 0, 0));
  }
}
