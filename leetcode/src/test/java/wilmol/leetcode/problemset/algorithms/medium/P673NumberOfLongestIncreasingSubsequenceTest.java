package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-15. */
class P673NumberOfLongestIncreasingSubsequenceTest {

  private final P673NumberOfLongestIncreasingSubsequence fun =
      new P673NumberOfLongestIncreasingSubsequence();

  @Test
  void example1() {
    assertThat(fun.findNumberOfLis(new int[] {1, 3, 5, 4, 7})).isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(fun.findNumberOfLis(new int[] {2, 2, 2, 2, 2})).isEqualTo(5);
  }
}
