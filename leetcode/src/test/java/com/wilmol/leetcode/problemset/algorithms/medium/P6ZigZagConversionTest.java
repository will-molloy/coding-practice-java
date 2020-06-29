package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P6ZigZagConversionTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P6ZigZagConversionTest {

  private final P6ZigZagConversion function = new P6ZigZagConversion();

  @Test
  void example1OddNumRows() {
    assertThat(function.convert("PAYPALISHIRING", 3)).isEqualTo("PAHNAPLSIIGYIR");
  }

  @Test
  void example2EvenNumRows() {
    assertThat(function.convert("PAYPALISHIRING", 4)).isEqualTo("PINALSIGYAHRPI");
  }

  @Test
  void singleRow() {
    assertThat(function.convert("hello", 1)).isEqualTo("hello");
  }
}
