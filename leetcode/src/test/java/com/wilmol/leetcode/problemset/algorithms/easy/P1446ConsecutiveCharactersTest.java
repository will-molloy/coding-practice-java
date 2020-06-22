package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-17. */
class P1446ConsecutiveCharactersTest {

  private final P1446ConsecutiveCharacters p1446 = new P1446ConsecutiveCharacters();

  @Test
  void example1() {
    assertThat(p1446.maxPower("leetcode")).isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(p1446.maxPower("abbcccddddeeeeedcba")).isEqualTo(5);
  }

  @Test
  void example3() {
    assertThat(p1446.maxPower("triplepillooooow")).isEqualTo(5);
  }

  @Test
  void example4() {
    assertThat(p1446.maxPower("hooraaaaaaaaaaay")).isEqualTo(11);
  }

  @Test
  void example5() {
    assertThat(p1446.maxPower("tourist")).isEqualTo(1);
  }
}
