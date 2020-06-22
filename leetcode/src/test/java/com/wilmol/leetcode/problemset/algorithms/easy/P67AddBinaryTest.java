package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-01-13. */
class P67AddBinaryTest {

  private final P67AddBinary func = new P67AddBinary();

  @Test
  void example1() {
    assertThat(func.addBinary("11", "1")).isEqualTo("100");
  }

  @Test
  void example2() {
    assertThat(func.addBinary("1010", "1011")).isEqualTo("10101");
  }

  @Test
  void onePlusOne() {
    assertThat(func.addBinary("1", "1")).isEqualTo("10");
  }

  @Test
  void zeroPlusZero() {
    assertThat(func.addBinary("0", "0")).isEqualTo("0");
  }

  @Test
  void differentSizeBy2() {
    assertThat(func.addBinary("100", "110010")).isEqualTo("110110");
  }
}
