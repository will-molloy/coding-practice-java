package com.willmolloy.hackerrank.interviewpreparationkit.greedyalgorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * GreedyFloristTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class GreedyFloristTest {

  @Test
  void buyAllAtBasePrice() {
    assertThat(GreedyFlorist.getMinimumCost(3, new int[] {2, 5, 6})).isEqualTo(13);
  }

  @Test
  void buyInTwoSets() {
    assertThat(GreedyFlorist.getMinimumCost(2, new int[] {2, 5, 6})).isEqualTo(15);
  }

  @Test
  void buyAllSeparately() {
    assertThat(GreedyFlorist.getMinimumCost(1, new int[] {3, 3, 3})).isEqualTo(18);
  }
}
