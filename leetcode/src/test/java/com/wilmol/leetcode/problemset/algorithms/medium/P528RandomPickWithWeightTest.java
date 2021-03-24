package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableMap;
import com.wilmol.testlib.RandomTrials;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P528RandomPickWithWeightTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P528RandomPickWithWeightTest {

  private static final double TOLERANCE = 0.02;

  @ParameterizedTest
  @MethodSource("solutions")
  void example1(Function<int[], P528RandomPickWithWeight.Solution> solutionFunction) {
    P528RandomPickWithWeight.Solution solution = solutionFunction.apply(new int[] {1});

    ImmutableMap<Integer, Double> actualProbabilities =
        RandomTrials.getActualProbabilities(() -> solution.pickIndex());

    assertThat(actualProbabilities.keySet()).containsExactly(0);
    assertThat(actualProbabilities.get(0)).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void example2(Function<int[], P528RandomPickWithWeight.Solution> solutionFunction) {
    P528RandomPickWithWeight.Solution solution = solutionFunction.apply(new int[] {1, 3});

    ImmutableMap<Integer, Double> actualProbabilities =
        RandomTrials.getActualProbabilities(() -> solution.pickIndex());

    assertThat(actualProbabilities.keySet()).containsExactly(0, 1);
    assertThat(actualProbabilities.get(0)).isWithin(TOLERANCE).of(0.25);
    assertThat(actualProbabilities.get(1)).isWithin(TOLERANCE).of(0.75);
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void codeCommentExample(Function<int[], P528RandomPickWithWeight.Solution> solutionFunction) {
    P528RandomPickWithWeight.Solution solution = solutionFunction.apply(new int[] {2, 5, 3});

    ImmutableMap<Integer, Double> actualProbabilities =
        RandomTrials.getActualProbabilities(() -> solution.pickIndex());

    assertThat(actualProbabilities.keySet()).containsExactly(0, 1, 2);
    assertThat(actualProbabilities.get(0)).isWithin(TOLERANCE).of(0.2);
    assertThat(actualProbabilities.get(1)).isWithin(TOLERANCE).of(0.5);
    assertThat(actualProbabilities.get(2)).isWithin(TOLERANCE).of(0.3);
  }

  static Stream<Function<int[], P528RandomPickWithWeight.Solution>> solutions() {
    return Stream.of(
        P528RandomPickWithWeight.BinarySearch::new, P528RandomPickWithWeight.TreeMap::new);
  }
}
