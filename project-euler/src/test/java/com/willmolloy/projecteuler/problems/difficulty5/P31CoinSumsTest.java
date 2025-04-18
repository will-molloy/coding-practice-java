package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P31CoinSumsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P31CoinSumsTest {

  private static final int[] COINS = new int[] {1, 2, 5, 10, 20, 50, 100, 200};

  @Test
  void waysFor5Pence() {
    assertThat(P31CoinSums.waysToCreateAmount(5, COINS)).isEqualTo(4);
  }

  @Test
  void waysFor2Quid() {
    assertThat(P31CoinSums.waysToCreateAmount(200, COINS)).isEqualTo(73682);
  }
}
