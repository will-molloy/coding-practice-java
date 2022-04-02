package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P771JewelsAndStonesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P771JewelsAndStonesTest {

  private final P771JewelsAndStones fun = new P771JewelsAndStones();

  @Test
  void example1() {
    assertThat(fun.numJewelsInStones("aA", "aAAbbbb")).isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(fun.numJewelsInStones("z", "ZZ")).isEqualTo(0);
  }
}
