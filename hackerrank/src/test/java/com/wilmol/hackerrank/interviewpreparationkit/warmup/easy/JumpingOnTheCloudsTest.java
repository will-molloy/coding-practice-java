package com.wilmol.hackerrank.interviewpreparationkit.warmup.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class JumpingOnTheCloudsTest {

  @Test
  void twoBadClouds() {
    assertThat(JumpingOnTheClouds.jumpingOnClouds(new int[] {0, 0, 1, 0, 0, 1, 0})).isEqualTo(4);
  }

  @Test
  void twoBadCloudsAndSkipOneGoodCloud() {
    assertThat(JumpingOnTheClouds.jumpingOnClouds(new int[] {0, 0, 0, 0, 1, 0})).isEqualTo(3);
  }
}
