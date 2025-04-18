package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P278FirstBadVersionTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P278FirstBadVersionTest {

  @Test
  void example() {
    P278FirstBadVersion.Solution solution = new P278FirstBadVersion.Solution(4);
    assertThat(solution.firstBadVersion(5)).isEqualTo(4);
  }

  @Test
  void oneVersion() {
    P278FirstBadVersion.Solution solution = new P278FirstBadVersion.Solution(1);
    assertThat(solution.firstBadVersion(1)).isEqualTo(1);
  }
}
