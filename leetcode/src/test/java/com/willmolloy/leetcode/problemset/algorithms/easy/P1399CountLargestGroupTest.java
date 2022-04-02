package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1399CountLargestGroupTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1399CountLargestGroupTest {

  private final P1399CountLargestGroup p1399 = new P1399CountLargestGroup();

  @Test
  void example1() {
    assertThat(p1399.countLargestGroup(13)).isEqualTo(4);
  }

  @Test
  void example2() {
    assertThat(p1399.countLargestGroup(2)).isEqualTo(2);
  }

  @Test
  void example3() {
    assertThat(p1399.countLargestGroup(15)).isEqualTo(6);
  }

  @Test
  void example4() {
    assertThat(p1399.countLargestGroup(24)).isEqualTo(5);
  }
}
