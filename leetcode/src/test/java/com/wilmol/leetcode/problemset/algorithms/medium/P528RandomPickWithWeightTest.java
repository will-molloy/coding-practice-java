package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.collect.ImmutableMap.toImmutableMap;
import static com.google.common.truth.Truth.assertThat;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P528RandomPickWithWeightTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P528RandomPickWithWeightTest {

  private static final int NUM_TRIALS = 1_000_000;

  private static final double TOLERANCE = 0.02;

  @ParameterizedTest
  @MethodSource("solutions")
  void example1(Function<int[], P528RandomPickWithWeight.Solution> solutionFunction) {
    Map<Integer, Double> actualProbabilities =
        getActualProbabilities(solutionFunction.apply(new int[] {1}));
    assertThat(actualProbabilities.keySet()).containsExactly(0);
    assertThat(actualProbabilities.values().stream().mapToDouble(i -> i).sum()).isEqualTo(1);
    assertThat(actualProbabilities.get(0)).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void example2(Function<int[], P528RandomPickWithWeight.Solution> solutionFunction) {
    Map<Integer, Double> actualProbabilities =
        getActualProbabilities(solutionFunction.apply(new int[] {1, 3}));
    assertThat(actualProbabilities.keySet()).containsExactly(0, 1);
    assertThat(actualProbabilities.values().stream().mapToDouble(i -> i).sum())
        .isWithin(TOLERANCE)
        .of(1);
    assertThat(actualProbabilities.get(0)).isWithin(TOLERANCE).of(0.25);
    assertThat(actualProbabilities.get(1)).isWithin(TOLERANCE).of(0.75);
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void codeCommentExample(Function<int[], P528RandomPickWithWeight.Solution> solutionFunction) {
    Map<Integer, Double> actualProbabilities =
        getActualProbabilities(solutionFunction.apply(new int[] {2, 5, 3}));
    assertThat(actualProbabilities.keySet()).containsExactly(0, 1, 2);
    assertThat(actualProbabilities.values().stream().mapToDouble(i -> i).sum())
        .isWithin(TOLERANCE)
        .of(1);
    assertThat(actualProbabilities.get(0)).isWithin(TOLERANCE).of(0.2);
    assertThat(actualProbabilities.get(1)).isWithin(TOLERANCE).of(0.5);
    assertThat(actualProbabilities.get(2)).isWithin(TOLERANCE).of(0.3);
  }

  // helper method to run random trials
  private Map<Integer, Double> getActualProbabilities(P528RandomPickWithWeight.Solution solution) {

    Map<Integer, Long> indexCounts =
        IntStream.range(0, NUM_TRIALS)
            .mapToObj(i -> solution.pickIndex())
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return indexCounts.entrySet().stream()
        .collect(toImmutableMap(Map.Entry::getKey, e -> (double) e.getValue() / NUM_TRIALS));
  }

  static Stream<Function<int[], P528RandomPickWithWeight.Solution>> solutions() {
    return Stream.of(
        P528RandomPickWithWeight.BinarySearch::new, P528RandomPickWithWeight.TreeMap::new);
  }
}
