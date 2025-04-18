package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P717OneBitAndTwoBitCharactersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P717OneBitAndTwoBitCharactersTest {

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
