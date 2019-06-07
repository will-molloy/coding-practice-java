package com.wilmol.hackerrank.regex.assertions.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class NegativeLookAheadTest
{

  @Test
  void testMatchCount()
  {
    assertThat(new NegativeLookAhead().matchCount("gooooo")).isEqualTo(2L);
    assertThat(new NegativeLookAhead().matchCount("gooloo")).isEqualTo(4L);
    assertThat(new NegativeLookAhead().matchCount("###$$$$")).isEqualTo(2L);
    assertThat(new NegativeLookAhead().matchCount("goluo")).isEqualTo(5L);
    assertThat(new NegativeLookAhead().matchCount("abc")).isEqualTo(3L);
  }

}
