package com.willmolloy.hackerrank.regex.assertions.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * NegativeLookAheadTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class NegativeLookAheadTest {

  @Test
  void testMatchCount() {
    assertThat(new NegativeLookAhead().containsCount("gooooo")).isEqualTo(2L);
    assertThat(new NegativeLookAhead().containsCount("gooloo")).isEqualTo(4L);
    assertThat(new NegativeLookAhead().containsCount("###$$$$")).isEqualTo(2L);
    assertThat(new NegativeLookAhead().containsCount("goluo")).isEqualTo(5L);
    assertThat(new NegativeLookAhead().containsCount("abc")).isEqualTo(3L);
  }
}
