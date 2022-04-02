package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1507ReformatDateTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1507ReformatDateTest {

  private final P1507ReformatDate p1507 = new P1507ReformatDate();

  @Test
  void thTwoDayDigits() {
    assertThat(p1507.reformatDate("20th Oct 2052")).isEqualTo("2052-10-20");
  }

  @Test
  void thOneDayDigit() {
    assertThat(p1507.reformatDate("6th Jun 1933")).isEqualTo("1933-06-06");
  }

  @Test
  void st() {
    assertThat(p1507.reformatDate("1st Jun 1933")).isEqualTo("1933-06-01");
  }

  @Test
  void nd() {
    assertThat(p1507.reformatDate("2nd Jun 1933")).isEqualTo("1933-06-02");
  }

  @Test
  void rd() {
    assertThat(p1507.reformatDate("3rd Jun 1933")).isEqualTo("1933-06-03");
  }
}
