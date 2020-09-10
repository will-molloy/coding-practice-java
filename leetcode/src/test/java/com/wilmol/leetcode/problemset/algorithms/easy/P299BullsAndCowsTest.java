package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P299BullsAndCowsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P299BullsAndCowsTest {

  private final P299BullsAndCows p299 = new P299BullsAndCows();

  @Test
  void example1() {
    assertThat(p299.getHint("1807", "7810")).isEqualTo("1A3B");
  }

  @Test
  void example2() {
    assertThat(p299.getHint("1123", "0111")).isEqualTo("1A1B");
  }
}
