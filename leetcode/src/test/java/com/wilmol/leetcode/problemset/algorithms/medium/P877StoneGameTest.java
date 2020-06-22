package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-04. */
class P877StoneGameTest {

  private final P877StoneGame fun = new P877StoneGame();

  @Test
  void example1() {
    assertThat(fun.stoneGame(new int[] {5, 3, 4, 5})).isTrue();
  }
}
