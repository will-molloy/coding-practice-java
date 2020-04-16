package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-17. */
class P392IsSubsequenceTest {

  private final P392IsSubsequence p392 = new P392IsSubsequence();

  @Test
  void example1() {
    assertThat(p392.isSubsequence("abc", "ahbgdc")).isTrue();
  }

  @Test
  void example2() {
    assertThat(p392.isSubsequence("axc", "ahbgdc")).isFalse();
  }
}
