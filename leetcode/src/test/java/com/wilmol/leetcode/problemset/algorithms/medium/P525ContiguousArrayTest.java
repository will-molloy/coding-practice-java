package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P525ContiguousArrayTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P525ContiguousArrayTest {

  private final P525ContiguousArray fun = new P525ContiguousArray();

  @Test
  void example1() {
    assertThat(fun.findMaxLength(new int[] {0, 1})).isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(fun.findMaxLength(new int[] {0, 1, 0})).isEqualTo(2);
  }

  @Test
  void n10Length10() {
    assertThat(fun.findMaxLength(new int[] {0, 1, 0, 1, 0, 1, 0, 1, 0, 1})).isEqualTo(10);
  }

  @Test
  void n10Length10Alternative() {
    assertThat(fun.findMaxLength(new int[] {0, 0, 0, 0, 0, 1, 1, 1, 1, 1})).isEqualTo(10);
  }

  @Test
  void n10Length8() {
    assertThat(fun.findMaxLength(new int[] {0, 1, 0, 1, 0, 1, 0, 1, 0, 0})).isEqualTo(8);
  }

  @Test
  void n0() {
    assertThat(fun.findMaxLength(new int[0])).isEqualTo(0);
  }

  @Test
  void n10Length0() {
    assertThat(fun.findMaxLength(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0})).isEqualTo(0);
  }

  @Test
  void maxLengthExcludesHeadAndLast() {
    assertThat(fun.findMaxLength(new int[] {0, 0, 1, 0, 1, 0, 0, 0})).isEqualTo(4);
  }
}
