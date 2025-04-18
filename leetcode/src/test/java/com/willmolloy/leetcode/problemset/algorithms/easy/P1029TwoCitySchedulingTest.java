package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1029TwoCitySchedulingTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1029TwoCitySchedulingTest {

  private final P1029TwoCityScheduling p1029 = new P1029TwoCityScheduling();

  @Test
  void example1AlwaysPickMin() {
    assertThat(p1029.twoCitySchedCost(new int[][] {{10, 20}, {30, 200}, {400, 50}, {30, 20}}))
        .isEqualTo(110);
  }

  @Test
  void pickSomeLargerFromCityA() {
    assertThat(
            p1029.twoCitySchedCost(
                new int[][] {
                  {259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}
                }))
        .isEqualTo(1859);
  }

  @Test
  void pickSomeLargerFromCityB() {
    assertThat(
            p1029.twoCitySchedCost(
                new int[][] {
                  {770, 259}, {54, 448}, {667, 926}, {139, 184}, {118, 840}, {469, 577}
                }))
        .isEqualTo(1859);
  }
}
