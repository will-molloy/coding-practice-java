package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P791CustomSortStringTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P791CustomSortStringTest {

  private final P791CustomSortString p791CustomSortString = new P791CustomSortString();

  @Test
  void example1() {
    assertThat(p791CustomSortString.customSortString("cba", "abcd")).isEqualTo("cbad");
  }

  @Test
  void example2() {
    assertThat(p791CustomSortString.customSortString("cbafg", "abcd")).isEqualTo("cbad");
  }
}
