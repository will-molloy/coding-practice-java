package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-05. */
class P451SortCharactersByFrequencyTest {

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
