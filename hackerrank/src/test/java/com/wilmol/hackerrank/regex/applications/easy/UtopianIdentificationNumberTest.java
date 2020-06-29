package com.wilmol.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * UtopianIdentificationNumberTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class UtopianIdentificationNumberTest {

  @Test
  void testCase0() {
    assertThat(UtopianIdentificationNumber.isValid("abc012333ABCDEEEE")).isTrue();
    assertThat(UtopianIdentificationNumber.isValid("0123AB")).isFalse();
  }
}
