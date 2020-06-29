package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1175PrimeArrangementsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1175PrimeArrangementsTest {

  private final P1175PrimeArrangements p1175 = new P1175PrimeArrangements();

  @Test
  void example1() {
    assertThat(p1175.numPrimeArrangements(5)).isEqualTo(12);
  }

  @Test
  void example2() {
    assertThat(p1175.numPrimeArrangements(100)).isEqualTo(682289015);
  }

  @Test
  void n1() {
    assertThat(p1175.numPrimeArrangements(1)).isEqualTo(1);
  }

  @Test
  void n2() {
    assertThat(p1175.numPrimeArrangements(2)).isEqualTo(1);
  }
}
