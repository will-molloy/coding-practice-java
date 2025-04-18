package com.willmolloy.hackerrank.regex.assertions.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * PositiveLookaheadTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class PositiveLookaheadTest {

  @Test
  void testMatchCount() {
    assertThat(new PositiveLookahead().containsCount("gooooo!")).isEqualTo(3L);
    assertThat(new PositiveLookahead().containsCount("oooooogooo")).isEqualTo(5L);
    assertThat(new PositiveLookahead().containsCount("googoogoogooo")).isEqualTo(1L);
    assertThat(new PositiveLookahead().containsCount("goooglooo!")).isEqualTo(2L);
  }
}
