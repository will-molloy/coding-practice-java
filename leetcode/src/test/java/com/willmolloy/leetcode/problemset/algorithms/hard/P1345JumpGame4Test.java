package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1345JumpGame4Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1345JumpGame4Test {
  private final P1345JumpGame4 p1345 = new P1345JumpGame4();

  @Test
  void example1() {
    assertThat(p1345.minJumps(new int[] {100, -23, -23, 404, 100, 23, 23, 23, 3, 404}))
        .isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(p1345.minJumps(new int[] {7})).isEqualTo(0);
  }

  @Test
  void example3() {
    assertThat(p1345.minJumps(new int[] {7, 6, 9, 6, 9, 6, 9, 7})).isEqualTo(1);
  }

  @Test
  void example4() {
    assertThat(p1345.minJumps(new int[] {6, 1, 9})).isEqualTo(2);
  }
}
