package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-06-14. */
class P785IsGraphBipartiteTest {

  private final P785IsGraphBipartite p785 = new P785IsGraphBipartite();

  @Test
  void example1IsBipartite() {
    assertThat(p785.isBipartite(new int[][] {{1, 3}, {0, 2}, {1, 3}, {0, 2}})).isTrue();
  }

  @Test
  void example2IsNotBipartite() {
    assertThat(p785.isBipartite(new int[][] {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}})).isFalse();
  }
}
