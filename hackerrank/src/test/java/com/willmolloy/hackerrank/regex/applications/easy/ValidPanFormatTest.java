package com.willmolloy.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * ValidPanFormatTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class ValidPanFormatTest {

  @Test
  void testCase0() {
    assertThat(ValidPanFormat.isValid("ABCDS1234Y")).isTrue();
    // 5th place must be char
    assertThat(ValidPanFormat.isValid("ABAB12345Y")).isFalse();
    // lower case chars
    assertThat(ValidPanFormat.isValid("avCDS1234Y")).isFalse();
  }
}
