package com.willmolloy.hackerrank.interviewpreparationkit.dynamicprogramming.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MaxArraySumTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class MaxArraySumTest {

  @Test
  void listOfSize5() {
    assertThat(MaxArraySum.maxSubsetSum(2, 1, 5, 8, 4)).isEqualTo(11);
    assertThat(MaxArraySum.maxSubsetSum(3, 7, 4, 6, 5)).isEqualTo(13);
  }

  @Test
  void negativeValuesInList() {
    assertThat(MaxArraySum.maxSubsetSum(3, 5, -7, 8, 10)).isEqualTo(15);
  }
}
