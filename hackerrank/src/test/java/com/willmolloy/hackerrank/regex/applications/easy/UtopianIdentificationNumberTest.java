package com.willmolloy.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * UtopianIdentificationNumberTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class UtopianIdentificationNumberTest {

  @Test
  void testCase0() {
    assertThat(UtopianIdentificationNumber.isValid("abc012333ABCDEEEE")).isTrue();
    assertThat(UtopianIdentificationNumber.isValid("0123AB")).isFalse();
  }
}
