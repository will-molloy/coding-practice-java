package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1009ComplementOfBase10IntegerTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1009ComplementOfBase10IntegerTest {

  private final P1009ComplementOfBase10Integer p1009 = new P1009ComplementOfBase10Integer();

  @Test
  void example1() {
    assertThat(p1009.bitwiseComplement(5)).isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(p1009.bitwiseComplement(7)).isEqualTo(0);
  }

  @Test
  void example3() {
    assertThat(p1009.bitwiseComplement(10)).isEqualTo(5);
  }

  @Test
  void zero() {
    assertThat(p1009.bitwiseComplement(0)).isEqualTo(1);
  }
}
