package com.wilmol.hackerrank.regex.assertions.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class PositiveLookbehindTest
{
  @Test
  void testMatchCount()
  {
    assertThat(new PositiveLookbehind().matchCount("123Go!")).isEqualTo(1L);
    assertThat(new PositiveLookbehind().matchCount("123456789")).isEqualTo(4L);
  }
}
