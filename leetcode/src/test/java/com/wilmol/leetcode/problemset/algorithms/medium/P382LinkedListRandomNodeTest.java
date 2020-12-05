package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.ListNode;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * P382LinkedListRandomNodeTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P382LinkedListRandomNodeTest {

  private static final int NUM_TRIALS = 1_000_000;

  private static final double TOLERANCE = 0.02;

  @Test
  void example() {
    ListNode node = ListNode.of(1, 2, 3);
    Map<Integer, Double> actualProbabilities = getActionProbabilities(node);

    assertThat(actualProbabilities.keySet()).containsExactly(1, 2, 3);
    assertThat(actualProbabilities.values().stream().mapToDouble(Double::doubleValue).sum())
        .isEqualTo(1);
    for (Integer i : List.of(1, 2, 3)) {
      assertThat(actualProbabilities.get(i)).isWithin(TOLERANCE).of(1d / 3);
    }
  }

  private Map<Integer, Double> getActionProbabilities(ListNode node) {
    P382LinkedListRandomNode.Solution solution = new P382LinkedListRandomNode.Solution(node);
    return IntStream.range(0, NUM_TRIALS)
        .mapToObj(i -> solution.getRandom())
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .collect(Collectors.toMap(Map.Entry::getKey, e -> (double) e.getValue() / NUM_TRIALS));
  }
}
