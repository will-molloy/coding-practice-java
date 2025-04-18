package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P461HammingDistanceTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P461HammingDistanceTest {

  private final P461HammingDistance p461 = new P461HammingDistance();

  @Test
  void example() {
    assertThat(p461.hammingDistance(1, 4)).isEqualTo(2);
  }

  @Test
  void bothMaxLength() {
    assertThat(p461.hammingDistance(Integer.MAX_VALUE, Integer.MAX_VALUE)).isEqualTo(0);
  }

  @Test
  void oneMaxLengthOtherMinLength() {
    assertThat(p461.hammingDistance(Integer.MAX_VALUE, 0)).isEqualTo(31);
  }
}
