package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P877StoneGameTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P877StoneGameTest {

  private final P877StoneGame fun = new P877StoneGame();

  @Test
  void example1() {
    assertThat(fun.stoneGame(new int[] {5, 3, 4, 5})).isTrue();
  }
}
