package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-17. */
class P717OneBitAndTwoBitCharactersTest {

  private final P717OneBitAndTwoBitCharacters fun = new P717OneBitAndTwoBitCharacters();

  @Test
  void example1() {
    assertThat(fun.isOneBitCharacter(new int[] {1, 0, 0})).isTrue();
  }

  @Test
  void example2() {
    assertThat(fun.isOneBitCharacter(new int[] {1, 1, 1, 0})).isFalse();
  }
}
