package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P389FindTheDifferenceTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P389FindTheDifferenceTest {

  private final P389FindTheDifference p389 = new P389FindTheDifference();

  @Test
  void example() {
    assertThat(p389.findTheDifference("abcd", "abcde")).isEqualTo('e');
  }
}
