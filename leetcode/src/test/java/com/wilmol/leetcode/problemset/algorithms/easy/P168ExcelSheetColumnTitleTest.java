package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P168ExcelSheetColumnTitleTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P168ExcelSheetColumnTitleTest {

  private final P168ExcelSheetColumnTitle p168 = new P168ExcelSheetColumnTitle();

  @Test
  void example1() {
    assertThat(p168.convertToTitle(1)).isEqualTo("A");
  }

  @Test
  void example2() {
    assertThat(p168.convertToTitle(28)).isEqualTo("AB");
  }

  @Test
  void example3() {
    assertThat(p168.convertToTitle(701)).isEqualTo("ZY");
  }

  @Test
  void z() {
    assertThat(p168.convertToTitle(26)).isEqualTo("Z");
  }

  @Test
  void aa() {
    assertThat(p168.convertToTitle(27)).isEqualTo("AA");
  }

  @Test
  void az() {
    assertThat(p168.convertToTitle(52)).isEqualTo("AZ");
  }

  @Test
  void abcdef() {
    assertThat(p168.convertToTitle(12850896)).isEqualTo("ABCDEF");
  }
}
