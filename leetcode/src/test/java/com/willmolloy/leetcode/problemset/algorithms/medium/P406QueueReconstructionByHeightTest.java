package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P406QueueReconstructionByHeightTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P406QueueReconstructionByHeightTest {

  private final P406QueueReconstructionByHeight p406 = new P406QueueReconstructionByHeight();

  @Test
  void example() {
    assertThat(p406.reconstructQueue(new int[][] {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}))
        .isEqualTo(new int[][] {{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}});
  }
}
