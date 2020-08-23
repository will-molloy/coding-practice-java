package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.collect.ImmutableMap.toImmutableMap;
import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.problemset.algorithms.medium.P380InsertDeleteGetRandomO1.RandomizedSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * P380InsertDeleteGetRandomO1Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P380InsertDeleteGetRandomO1Test {

  private static final int NUM_TRIALS = 1_000_000;

  private static final double TOLERANCE = 0.02d;

  @Test
  void example() {
    RandomizedSet randomSet = new RandomizedSet();

    assertThat(randomSet.insert(1)).isTrue();
    assertThat(randomSet.remove(2)).isFalse();
    assertThat(randomSet.insert(2)).isTrue();

    Map<Integer, Double> firstGetRandomResult = runRandomTrials(randomSet);
    assertThat(firstGetRandomResult.keySet()).containsExactly(1, 2);
    assertThat(firstGetRandomResult.values().stream().mapToDouble(i -> i).sum())
        .isWithin(TOLERANCE)
        .of(1);
    assertThat(firstGetRandomResult.get(1)).isWithin(TOLERANCE).of(0.5);
    assertThat(firstGetRandomResult.get(2)).isWithin(TOLERANCE).of(0.5);

    assertThat(randomSet.remove(1)).isTrue();
    assertThat(randomSet.insert(2)).isFalse();

    Map<Integer, Double> secondGetRandomResult = runRandomTrials(randomSet);
    assertThat(secondGetRandomResult.keySet()).containsExactly(2);
    assertThat(secondGetRandomResult.values().stream().mapToDouble(i -> i).sum()).isEqualTo(1);
    assertThat(secondGetRandomResult.get(2)).isEqualTo(1);
  }

  private static Map<Integer, Double> runRandomTrials(RandomizedSet randomSet) {
    Map<Integer, Long> counts =
        IntStream.range(0, NUM_TRIALS)
            .mapToObj(i -> randomSet.getRandom())
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return counts.entrySet().stream()
        .collect(toImmutableMap(Map.Entry::getKey, e -> (double) e.getValue() / NUM_TRIALS));
  }
}
