package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P455AssignCookiesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P455AssignCookiesTest {

  private final P455AssignCookies p455 = new P455AssignCookies();

  @Test
  void example1() {
    assertThat(p455.findContentChildren(new int[] {1, 2, 3}, new int[] {1, 1})).isEqualTo(1);
  }

  @Test
  void example2() {
    assertThat(p455.findContentChildren(new int[] {1, 2}, new int[] {1, 2, 3})).isEqualTo(2);
  }

  @Test
  void someCookiesTooSmall() {
    assertThat(p455.findContentChildren(new int[] {10, 9, 8, 7}, new int[] {5, 6, 7, 8}))
        .isEqualTo(2);
  }
}
