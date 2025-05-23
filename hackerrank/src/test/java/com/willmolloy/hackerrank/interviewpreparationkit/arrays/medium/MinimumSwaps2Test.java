package com.willmolloy.hackerrank.interviewpreparationkit.arrays.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MinimumSwaps2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MinimumSwaps2Test {

  @Test
  void problemDescOneCycle() {
    assertThat(MinimumSwaps2.minimumSwaps(new int[] {7, 1, 3, 2, 4, 5, 6})).isEqualTo(5);
  }

  @Test
  void sampleInput1OneCycle() {
    assertThat(MinimumSwaps2.minimumSwaps(new int[] {2, 3, 4, 1, 5})).isEqualTo(3);
  }

  @Test
  void sampleInput2OneCycle() {
    assertThat(MinimumSwaps2.minimumSwaps(new int[] {1, 3, 5, 2, 4, 6, 7})).isEqualTo(3);
  }

  @Test
  void alreadySortedNoCycles() {
    assertThat(MinimumSwaps2.minimumSwaps(new int[] {1, 2, 3, 4, 5, 6, 7})).isEqualTo(0);
  }

  @Test
  void testCase4TwoCycles() {
    assertThat(
            MinimumSwaps2.minimumSwaps(
                new int[] {
                  2, 31, 1, 38, 29, 5, 44, 6, 12, 18, 39, 9, 48, 49, 13, 11, 7, 27, 14, 33, 50, 21,
                  46, 23, 15, 26, 8, 47, 40, 3, 32, 22, 34, 42, 16, 41, 24, 10, 4, 28, 36, 30, 37,
                  35, 20, 17, 45, 43, 25, 19
                }))
        .isEqualTo(46);
  }

  @Test
  void reverseOrderThreeCycles() {
    assertThat(MinimumSwaps2.minimumSwaps(new int[] {7, 6, 5, 4, 3, 2, 1})).isEqualTo(3);
  }
}
