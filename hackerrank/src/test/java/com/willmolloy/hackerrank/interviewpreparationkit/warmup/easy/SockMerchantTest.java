package com.willmolloy.hackerrank.interviewpreparationkit.warmup.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * SockMerchantTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class SockMerchantTest {

  @Test
  void fourColoursThreePairs() {
    assertThat(SockMerchant.sockMerchant(new int[] {10, 20, 20, 10, 10, 30, 50, 10, 20}))
        .isEqualTo(3);
  }
}
