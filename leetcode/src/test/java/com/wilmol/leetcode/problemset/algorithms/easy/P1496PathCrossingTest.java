package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1496PathCrossingTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1496PathCrossingTest {

  private final P1496PathCrossing p1496 = new P1496PathCrossing();

  @Test
  void example1DoesntCross() {
    assertThat(p1496.isPathCrossing("NES")).isFalse();
  }

  @Test
  void example2Crosses() {
    assertThat(p1496.isPathCrossing("NESWW")).isTrue();
  }
}
