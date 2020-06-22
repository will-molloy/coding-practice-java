package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-04. */
class P1342NumberOfStepsToReduceANumberToZeroTest {

  private final P1342NumberOfStepsToReduceANumberToZero fun =
      new P1342NumberOfStepsToReduceANumberToZero();

  @Test
  void example1() {
    assertThat(fun.numberOfSteps(14)).isEqualTo(6);
  }

  @Test
  void example2() {
    assertThat(fun.numberOfSteps(8)).isEqualTo(4);
  }

  @Test
  void example3() {
    assertThat(fun.numberOfSteps(123)).isEqualTo(12);
  }

  @Test
  void alreadyZero() {
    assertThat(fun.numberOfSteps(0)).isEqualTo(0);
  }
}
