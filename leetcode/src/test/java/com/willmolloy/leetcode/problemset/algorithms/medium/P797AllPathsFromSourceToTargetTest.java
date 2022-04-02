package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/**
 * P797AllPathsFromSourceToTargetTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P797AllPathsFromSourceToTargetTest {

  private final P797AllPathsFromSourceToTarget p797 = new P797AllPathsFromSourceToTarget();

  @Test
  void example() {
    assertThat(p797.allPathsSourceTarget(new int[][] {{1, 2}, {3}, {3}, {}}))
        .containsExactly(ImmutableList.of(0, 1, 3), ImmutableList.of(0, 2, 3));
  }
}
