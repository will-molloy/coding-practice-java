package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableMap;
import com.wilmol.leetcode.common.ListNode;
import com.wilmol.testlib.RandomTrials;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P382LinkedListRandomNodeTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P382LinkedListRandomNodeTest {

  private static final double TOLERANCE = 0.02;

  @Test
  void example() {
    ListNode node = ListNode.of(1, 2, 3);
    P382LinkedListRandomNode.Solution solution = new P382LinkedListRandomNode.Solution(node);
    ImmutableMap<Integer, Double> actualProbabilities =
        RandomTrials.getActualProbabilities(() -> solution.getRandom());

    assertThat(actualProbabilities.keySet()).containsExactly(1, 2, 3);
    for (Integer i : List.of(1, 2, 3)) {
      assertThat(actualProbabilities.get(i)).isWithin(TOLERANCE).of(1d / 3);
    }
  }
}
