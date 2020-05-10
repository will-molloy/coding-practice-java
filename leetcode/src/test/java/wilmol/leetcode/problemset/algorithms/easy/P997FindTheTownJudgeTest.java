package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-10. */
class P997FindTheTownJudgeTest {

  private final P997FindTheTownJudge p997 = new P997FindTheTownJudge();

  @Test
  void example1() {
    assertThat(p997.findJudge(2, new int[][] {{1, 2}})).isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(p997.findJudge(3, new int[][] {{1, 3}, {2, 3}})).isEqualTo(3);
  }

  @Test
  void example3() {
    assertThat(p997.findJudge(3, new int[][] {{1, 3}, {2, 3}, {3, 1}})).isEqualTo(-1);
  }

  @Test
  void example4() {
    assertThat(p997.findJudge(3, new int[][] {{1, 2}, {2, 3}})).isEqualTo(-1);
  }

  @Test
  void example5() {
    assertThat(p997.findJudge(4, new int[][] {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}))
        .isEqualTo(3);
  }
}
