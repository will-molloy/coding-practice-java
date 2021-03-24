package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.collect.ImmutableList.toImmutableList;
import static com.google.common.collect.ImmutableMap.toImmutableMap;
import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.Range;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P478GenerateRandomPointInACircleTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P478GenerateRandomPointInACircleTest {

  private static final int NUM_TRIALS = 1_000_000;

  private static final double TOLERANCE = 0.02;

  @ParameterizedTest
  @MethodSource("solutions")
  void example(SolutionSupplier solutionSupplier) {
    // Given
    double radius = 1;
    double xCentre = 0;
    double yCentre = 0;

    // When
    Map<List<Double>, Double> actualProbabilities =
        getActualProbabilities(radius, xCentre, yCentre, solutionSupplier);

    // Then
    // verify uniformly random
    assertThat(actualProbabilities.values().stream().mapToDouble(Double::doubleValue).sum())
        .isWithin(TOLERANCE)
        .of(1);
    double max =
        actualProbabilities.values().stream().mapToDouble(Double::doubleValue).max().orElseThrow();
    double min =
        actualProbabilities.values().stream().mapToDouble(Double::doubleValue).min().getAsDouble();
    double diff = max - min;
    assertThat(diff).isWithin(TOLERANCE).of(0);

    // verify all random points are in the circle
    for (List<Double> points : actualProbabilities.keySet()) {
      double x = points.get(0) - xCentre;
      double y = points.get(1) - yCentre;
      assertThat(x * x + y * y).isIn(Range.closed(0d, radius * radius));
    }
  }

  // helper method to run random trials
  private Map<List<Double>, Double> getActualProbabilities(
      double radius, double xCentre, double yCentre, SolutionSupplier solutionSupplier) {
    P478GenerateRandomPointInACircle solution = solutionSupplier.get(radius, xCentre, yCentre);

    Map<? extends List<Double>, Long> pointCounts =
        IntStream.range(0, NUM_TRIALS)
            .mapToObj(i -> solution.randPoint())
            .map(a -> Arrays.stream(a).boxed().collect(toImmutableList()))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return pointCounts.entrySet().stream()
        .collect(toImmutableMap(Map.Entry::getKey, e -> (double) e.getValue() / NUM_TRIALS));
  }

  static Stream<SolutionSupplier> solutions() {
    return Stream.of(
        P478GenerateRandomPointInACircle.RejectionSamplingFromSquare::new,
        P478GenerateRandomPointInACircle.PolarCoordinates::new);
  }

  @FunctionalInterface
  private interface SolutionSupplier {
    P478GenerateRandomPointInACircle get(double radius, double xCentre, double yCentre);
  }
}
