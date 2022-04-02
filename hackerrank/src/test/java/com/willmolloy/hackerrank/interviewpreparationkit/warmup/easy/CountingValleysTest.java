package com.willmolloy.hackerrank.interviewpreparationkit.warmup.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * CountingValleysTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class CountingValleysTest {

  @Test
  void oneValley() {
    assertThat(CountingValleys.countingValleys("UDDDUDUU")).isEqualTo(1);
  }

  @Test
  void twoValleys() {
    assertThat(CountingValleys.countingValleys("DDUUDDUDUUUD")).isEqualTo(2);
  }
}
