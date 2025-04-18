package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1551MinimumOperationsToMakeArrayEqualTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1551MinimumOperationsToMakeArrayEqualTest {

  private final P1551MinimumOperationsToMakeArrayEqual p1551 =
      new P1551MinimumOperationsToMakeArrayEqual();

  @Test
  void example1OddLen() {
    assertThat(p1551.minOperations(3)).isEqualTo(2);
  }

  @Test
  void example2EvenLen() {
    assertThat(p1551.minOperations(6)).isEqualTo(9);
  }
}
