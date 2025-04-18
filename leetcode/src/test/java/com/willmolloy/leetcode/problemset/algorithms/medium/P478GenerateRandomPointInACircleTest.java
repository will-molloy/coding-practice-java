package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Range;
import com.google.common.primitives.Doubles;
import com.willmolloy.testlib.RandomTrials;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P478GenerateRandomPointInACircleTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P478GenerateRandomPointInACircleTest {

  private static final double TOLERANCE = 0.02;

  @ParameterizedTest
  @MethodSource("solutions")
  void example(SolutionSupplier solutionSupplier) {
    // Given
    double radius = 1;
    double xCentre = 0;
    double yCentre = 0;

    // When
    P478GenerateRandomPointInACircle solution = solutionSupplier.get(radius, xCentre, yCentre);
    ImmutableMap<List<Double>, Double> actualProbabilities =
        RandomTrials.getActualProbabilities(() -> Doubles.asList(solution.randPoint()));

    // Then
    // verify uniformly random
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
