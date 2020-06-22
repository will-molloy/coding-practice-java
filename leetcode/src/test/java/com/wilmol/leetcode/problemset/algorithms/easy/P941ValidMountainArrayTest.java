package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-06-09. */
class P941ValidMountainArrayTest {

  private final P941ValidMountainArray p941 = new P941ValidMountainArray();

  @Test
  void example1InvalidLessThan3Elements() {
    assertThat(p941.validMountainArray(new int[] {2, 1})).isFalse();
  }

  @Test
  void example2InvalidDescentNotStrictlyDecreasing() {
    assertThat(p941.validMountainArray(new int[] {3, 5, 5})).isFalse();
  }

  @Test
  void example3ValidMountain() {
    assertThat(p941.validMountainArray(new int[] {0, 3, 2, 1})).isTrue();
  }

  @Test
  void invalidClimbNotStrictlyIncreasing() {
    assertThat(p941.validMountainArray(new int[] {5, 5, 3})).isFalse();
  }

  @Test
  void invalidPeakFirst() {
    assertThat(p941.validMountainArray(new int[] {3, 2, 1, 0})).isFalse();
  }

  @Test
  void validPeakSecond() {
    assertThat(p941.validMountainArray(new int[] {2, 3, 1, 0})).isTrue();
  }

  @Test
  void invalidPeakLast() {
    assertThat(p941.validMountainArray(new int[] {0, 1, 2, 3})).isFalse();
  }

  @Test
  void validPeakSecondLast() {
    assertThat(p941.validMountainArray(new int[] {0, 1, 3, 2})).isTrue();
  }
}
