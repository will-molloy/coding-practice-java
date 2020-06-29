package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1437CheckIfAll1sAreAtLeastKPlacesAwayTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1437CheckIfAll1sAreAtLeastKPlacesAwayTest {

  private final P1437CheckIfAll1sAreAtLeastKPlacesAway p1437 =
      new P1437CheckIfAll1sAreAtLeastKPlacesAway();

  @Test
  void example1() {
    assertThat(p1437.kLengthApart(new int[] {1, 0, 0, 0, 1, 0, 0, 1}, 2)).isTrue();
  }

  @Test
  void example2() {
    assertThat(p1437.kLengthApart(new int[] {1, 0, 0, 1, 0, 1}, 2)).isFalse();
  }

  @Test
  void example3() {
    assertThat(p1437.kLengthApart(new int[] {1, 1, 1, 1, 1}, 0)).isTrue();
  }

  @Test
  void example4() {
    assertThat(p1437.kLengthApart(new int[] {0, 1, 0, 1}, 1)).isTrue();
  }
}
