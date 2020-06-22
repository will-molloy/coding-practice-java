package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2019-11-03. */
class P55JumpGameTest {

  @ParameterizedTest
  @MethodSource("functions")
  void example1CanPass(P55JumpGame fun) {
    assertThat(fun.canJump(new int[] {2, 3, 1, 1, 4})).isTrue();
  }

  @ParameterizedTest
  @MethodSource("functions")
  void example2CannotPass(P55JumpGame fun) {
    assertThat(fun.canJump(new int[] {3, 2, 1, 0, 4})).isFalse();
  }

  @ParameterizedTest
  @MethodSource("functions")
  void singleZero(P55JumpGame fun) {
    // true because already at the end!
    assertThat(fun.canJump(new int[] {0})).isTrue();
  }

  static Stream<Arguments> functions() {
    return Stream.of(
        Arguments.of(new P55JumpGame.BackTracking()), Arguments.of(new P55JumpGame.Greedy()));
  }
}
