package com.wilmol.hackerrank.interview_preparation_kit.warmup.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class SockMerchantTest {

  @Test
  void _4Colours3Pairs() {
    assertThat(SockMerchant.sockMerchant(new int[] {10, 20, 20, 10, 10, 30, 50, 10, 20}))
        .isEqualTo(3);
  }
}
