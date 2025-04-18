package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P451SortCharactersByFrequencyTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P451SortCharactersByFrequencyTest {

  private final P451SortCharactersByFrequency p451 = new P451SortCharactersByFrequency();

  @Test
  void example1() {
    assertThat(p451.frequencySort("tree")).isAnyOf("eert", "eetr");
  }

  @Test
  void example2() {
    assertThat(p451.frequencySort("cccaaa")).isAnyOf("cccaaa", "aaaccc");
  }

  @Test
  void example3() {
    assertThat(p451.frequencySort("Aabb")).isAnyOf("bbAa", "bbaA");
  }
}
