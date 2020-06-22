package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.problemset.algorithms.medium.P380InsertDeleteGetRandomO1.RandomizedSet;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-06-13. */
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
    Map<Integer, Integer> counts = new HashMap<>();
    for (int i = 0; i < NUM_TRIALS; i++) {
      int random = randomSet.getRandom();
      counts.put(random, counts.getOrDefault(random, 0) + 1);
    }

    Map<Integer, Double> actualProbabilities = new HashMap<>();
    for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
      actualProbabilities.put(e.getKey(), (double) e.getValue() / NUM_TRIALS);
    }
    return actualProbabilities;
  }
}
