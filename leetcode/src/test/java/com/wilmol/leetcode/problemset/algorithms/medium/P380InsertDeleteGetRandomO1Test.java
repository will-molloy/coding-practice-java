package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableMap;
import com.wilmol.leetcode.problemset.algorithms.medium.P380InsertDeleteGetRandomO1.RandomizedSet;
import com.wilmol.testlib.RandomTrials;
import org.junit.jupiter.api.Test;

/**
 * P380InsertDeleteGetRandomO1Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P380InsertDeleteGetRandomO1Test {

  private static final double TOLERANCE = 0.02d;

  @Test
  void example() {
    RandomizedSet randomSet = new RandomizedSet();

    assertThat(randomSet.insert(1)).isTrue();
    assertThat(randomSet.remove(2)).isFalse();
    assertThat(randomSet.insert(2)).isTrue();

    ImmutableMap<Integer, Double> firstGetRandomResult =
        RandomTrials.getActualProbabilities(() -> randomSet.getRandom());
    assertThat(firstGetRandomResult.keySet()).containsExactly(1, 2);
    assertThat(firstGetRandomResult.get(1)).isWithin(TOLERANCE).of(0.5);
    assertThat(firstGetRandomResult.get(2)).isWithin(TOLERANCE).of(0.5);

    assertThat(randomSet.remove(1)).isTrue();
    assertThat(randomSet.insert(2)).isFalse();

    ImmutableMap<Integer, Double> secondGetRandomResult =
        RandomTrials.getActualProbabilities(() -> randomSet.getRandom());
    assertThat(secondGetRandomResult.keySet()).containsExactly(2);
    assertThat(secondGetRandomResult.get(2)).isEqualTo(1);
  }
}
