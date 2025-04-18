package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P171ExcelSheetColumnNumberTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P171ExcelSheetColumnNumberTest {

  private final P171ExcelSheetColumnNumber p171 = new P171ExcelSheetColumnNumber();

  @Test
  void example1() {
    assertThat(p171.titleToNumber("A")).isEqualTo(1);
  }

  @Test
  void example2() {
    assertThat(p171.titleToNumber("AB")).isEqualTo(28);
  }

  @Test
  void example3() {
    assertThat(p171.titleToNumber("ZY")).isEqualTo(701);
  }

  @Test
  void z() {
    assertThat(p171.titleToNumber("Z")).isEqualTo(26);
  }

  @Test
  void aa() {
    assertThat(p171.titleToNumber("ABCDEF")).isEqualTo(12850896);
  }

  @Test
  void az() {
    assertThat(p171.titleToNumber("AZ")).isEqualTo(52);
  }

  @Test
  void abcdef() {
    assertThat(p171.titleToNumber("ABCDEF")).isEqualTo(12850896);
  }
}
