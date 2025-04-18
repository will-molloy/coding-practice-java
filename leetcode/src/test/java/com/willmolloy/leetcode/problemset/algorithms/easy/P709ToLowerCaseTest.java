package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P709ToLowerCaseTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P709ToLowerCaseTest {

  private final P709ToLowerCase p709 = new P709ToLowerCase();

  @Test
  void example1() {
    assertThat(p709.toLowerCase("Hello")).isEqualTo("hello");
  }

  @Test
  void example2() {
    assertThat(p709.toLowerCase("here")).isEqualTo("here");
  }

  @Test
  void example3() {
    assertThat(p709.toLowerCase("LOVELY")).isEqualTo("lovely");
  }
}
