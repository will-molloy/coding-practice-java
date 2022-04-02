package com.willmolloy.hackerrank.regex.groupingcapturing.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * AlternativeMatchingTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class AlternativeMatchingTest {

  @Test
  void testMatches() {
    assertThat(new AlternativeMatching().matches("Mr.DOSHI")).isTrue();
    assertThat(new AlternativeMatching().matches("Mrs.DOSHI")).isTrue();
    assertThat(new AlternativeMatching().matches("Ms.DOSHI")).isTrue();
    assertThat(new AlternativeMatching().matches("Dr.DOSHI")).isTrue();
    assertThat(new AlternativeMatching().matches("Er.DOSHI")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new AlternativeMatching().matches("Mr#DOSHI")).isFalse();
    assertThat(new AlternativeMatching().matches("1Mr. doshIO")).isFalse();
    assertThat(new AlternativeMatching().matches("Mr.V.K. Doshi")).isFalse();
    assertThat(new AlternativeMatching().matches("Mr.VKDoshi.")).isFalse();
    assertThat(new AlternativeMatching().matches("Ms.")).isFalse();
  }
}
