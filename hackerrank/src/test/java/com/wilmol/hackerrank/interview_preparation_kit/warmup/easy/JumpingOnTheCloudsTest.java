package com.wilmol.hackerrank.interview_preparation_kit.warmup.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class JumpingOnTheCloudsTest
{

  @Test
  void _2BadClouds()
  {
    assertThat(JumpingOnTheClouds.jumpingOnClouds(new int[]{ 0, 0, 1, 0, 0, 1, 0 })).isEqualTo(4);
  }

  @Test
  void _2BadCloudsAndSkip1GoodCloud()
  {
    assertThat(JumpingOnTheClouds.jumpingOnClouds(new int[]{ 0, 0, 0, 0, 1, 0 })).isEqualTo(3);
  }

}
