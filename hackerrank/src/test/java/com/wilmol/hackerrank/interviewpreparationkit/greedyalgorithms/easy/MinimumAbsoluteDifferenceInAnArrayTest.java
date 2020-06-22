package com.wilmol.hackerrank.interviewpreparationkit.greedyalgorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 28/03/2019. */
class MinimumAbsoluteDifferenceInAnArrayTest {

  @Test
  void sampleInput1() {
    assertThat(
            MinimumAbsoluteDifferenceInAnArray.minimumAbsoluteDifference(
                new int[] {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75}))
        .isEqualTo(1);
  }

  @Test
  void sampleInput2() {
    assertThat(
            MinimumAbsoluteDifferenceInAnArray.minimumAbsoluteDifference(
                new int[] {1, -3, 71, 68, 17}))
        .isEqualTo(3);
  }

  @Test
  void hasDuplicates() {
    assertThat(
            MinimumAbsoluteDifferenceInAnArray.minimumAbsoluteDifference(
                new int[] {1, 17, 71, 68, 17}))
        .isEqualTo(0);
  }
}
