package com.wilmol.hackerrank.interview_preparation_kit.warmup.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class CountingValleysTest {

  @Test
  void _1Valley() {
    assertThat(CountingValleys.countingValleys("UDDDUDUU")).isEqualTo(1);
  }

  @Test
  void _2Valleys() {
    assertThat(CountingValleys.countingValleys("DDUUDDUDUUUD")).isEqualTo(2);
  }
}
