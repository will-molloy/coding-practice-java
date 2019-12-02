package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-12-02. */
class P56MergeIntervalsTest {

  private final P56MergeIntervals fun = new P56MergeIntervals();

  @Test
  void example1() {
    assertThat(fun.merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}}))
        .isEqualTo(new int[][] {{1, 6}, {8, 10}, {15, 18}});
  }

  @Test
  void example2() {
    assertThat(fun.merge(new int[][] {{1, 4}, {4, 5}})).isEqualTo(new int[][] {{1, 5}});
  }

  @Test
  void withDoubleMerge() {
    assertThat(fun.merge(new int[][] {{1, 2}, {3, 4}, {2, 3}})).isEqualTo(new int[][] {{1, 4}});
  }

  @Test
  void firstRangeIsEnclosing() {
    assertThat(fun.merge(new int[][] {{1, 4}, {2, 3}})).isEqualTo(new int[][] {{1, 4}});
  }

  @Test
  void secondRangeIsEnclosing() {
    assertThat(fun.merge(new int[][] {{2, 3}, {1, 4}})).isEqualTo(new int[][] {{1, 4}});
  }
}
