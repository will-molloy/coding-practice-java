package com.wilmol.hackerrank.interviewpreparationkit.greedyalgorithms.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.interviewpreparationkit.greedyalgorithms.easy.LuckBalance.luckBalance;

import org.junit.jupiter.api.Test;

/** Created by Will on 28/03/2019. */
class LuckBalanceTest {

  @Test
  void threeContestsTwoImportantCanLoseAll() {
    // 5 + 1 + 4
    assertThat(luckBalance(2, new int[][] {{5, 1}, {1, 1}, {4, 0}})).isEqualTo(10);
  }

  @Test
  void threeContestsTwoImportantMustWinOne() {
    // 5 - 1 + 4
    assertThat(luckBalance(1, new int[][] {{5, 1}, {1, 1}, {4, 0}})).isEqualTo(8);
  }

  @Test
  void sixContestsFourImportantMustWinOne() {
    // 5 + 2 - 1 + 8 + 10 + 5
    assertThat(luckBalance(3, new int[][] {{5, 1}, {2, 1}, {1, 1}, {8, 1}, {10, 0}, {5, 0}}))
        .isEqualTo(29);
  }

  @Test
  void sixContestsFourImportantMustWinTwo() {
    // 5 - 2 - 1 + 8 + 10 + 5
    assertThat(luckBalance(2, new int[][] {{5, 1}, {2, 1}, {1, 1}, {8, 1}, {10, 0}, {5, 0}}))
        .isEqualTo(25);
  }

  @Test
  void sixContestsFourImportantMustWinThemAll() {
    // - 5 - 2 - 1 - 8 + 10 + 5
    assertThat(luckBalance(0, new int[][] {{5, 1}, {2, 1}, {1, 1}, {8, 1}, {10, 0}, {5, 0}}))
        .isEqualTo(-1);
  }
}
