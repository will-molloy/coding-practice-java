package com.willmolloy.hackerrank.regex.assertions.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * PositiveLookbehindTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class PositiveLookbehindTest {

  @Test
  void testMatchCount() {
    assertThat(new PositiveLookbehind().containsCount("123Go!")).isEqualTo(1L);
    assertThat(new PositiveLookbehind().containsCount("123456789")).isEqualTo(4L);
  }
}
