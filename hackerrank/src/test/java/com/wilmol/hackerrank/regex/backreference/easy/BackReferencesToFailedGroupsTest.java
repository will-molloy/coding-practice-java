package com.wilmol.hackerrank.regex.backreference.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-06 at 19:54. */
class BackReferencesToFailedGroupsTest {

  @Test
  void testMatches() {
    assertThat(new BackReferencesToFailedGroups().matches("12345678")).isTrue();
    assertThat(new BackReferencesToFailedGroups().matches("12-34-56-87")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new BackReferencesToFailedGroups().matches("1-234-56-78")).isFalse();
    assertThat(new BackReferencesToFailedGroups().matches("12-45-7810")).isFalse();
    assertThat(new BackReferencesToFailedGroups().matches("12-34-56-87-")).isFalse();
    assertThat(new BackReferencesToFailedGroups().matches("-12-34-56-87")).isFalse();
  }
}
