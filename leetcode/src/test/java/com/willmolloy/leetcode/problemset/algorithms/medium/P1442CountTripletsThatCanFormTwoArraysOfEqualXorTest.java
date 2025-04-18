package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1442CountTripletsThatCanFormTwoArraysOfEqualXorTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1442CountTripletsThatCanFormTwoArraysOfEqualXorTest {

  private final P1442CountTripletsThatCanFormTwoArraysOfEqualXor p1442 =
      new P1442CountTripletsThatCanFormTwoArraysOfEqualXor();

  @Test
  void example1() {
    assertThat(p1442.countTriplets(new int[] {2, 3, 1, 6, 7})).isEqualTo(4);
  }

  @Test
  void example2() {
    assertThat(p1442.countTriplets(new int[] {1, 1, 1, 1, 1})).isEqualTo(10);
  }

  @Test
  void example3() {
    assertThat(p1442.countTriplets(new int[] {2, 3})).isEqualTo(0);
  }

  @Test
  void example4() {
    assertThat(p1442.countTriplets(new int[] {1, 3, 5, 7, 9})).isEqualTo(3);
  }

  @Test
  void example5() {
    assertThat(p1442.countTriplets(new int[] {7, 11, 12, 9, 5, 2, 7, 17, 22})).isEqualTo(8);
  }
}
