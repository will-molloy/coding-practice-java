package com.willmolloy.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * AlienUserNameTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class AlienUserNameTest {

  @Test
  void testMatches() {
    assertThat(AlienUserName.isValidUserName("_0898989811abced_")).isTrue();
    assertThat(AlienUserName.isValidUserName("_0898989811_")).isTrue();
    assertThat(AlienUserName.isValidUserName("_0")).isTrue();
    assertThat(AlienUserName.isValidUserName(".0898989811abced_")).isTrue();
    assertThat(AlienUserName.isValidUserName(".0898989811_")).isTrue();
    assertThat(AlienUserName.isValidUserName(".0")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(AlienUserName.isValidUserName("0898989811abced_")).isFalse();
    assertThat(AlienUserName.isValidUserName("#0898989811_")).isFalse();
    assertThat(AlienUserName.isValidUserName("$0")).isFalse();
    assertThat(AlienUserName.isValidUserName("abced_")).isFalse();
    assertThat(AlienUserName.isValidUserName("_0898989811abced_f")).isFalse();
    assertThat(AlienUserName.isValidUserName("_0898989811abced__")).isFalse();
  }
}
