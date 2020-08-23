package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.collect.ImmutableList.toImmutableList;
import static com.google.common.collect.ImmutableMap.toImmutableMap;
import static com.google.common.collect.ImmutableSet.toImmutableSet;
import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * P497RandomPointInNonOverlappingRectanglesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P497RandomPointInNonOverlappingRectanglesTest {

  private static final int NUM_TRIALS = 1_000_000;

  private static final double TOLERANCE = 0.02;

  @Test
  void example1() {
    int[][] rects = {{1, 1, 5, 5}};
    Map<List<Integer>, Double> actualProbabilities = getActualProbabilities(rects);

    Set<List<Integer>> rectPoints = rectPoints(rects);
    assertThat(actualProbabilities.keySet()).containsExactlyElementsIn(rectPoints);
    assertThat(actualProbabilities.values().stream().mapToDouble(Double::doubleValue).sum())
        .isEqualTo(1);
    for (List<Integer> point : rectPoints) {
      assertThat(actualProbabilities.get(point)).isWithin(TOLERANCE).of(1 / 25d);
    }
  }

  @Test
  void example2() {
    int[][] rects = {{-2, -2, -1, -1}, {1, 0, 3, 0}};
    Map<List<Integer>, Double> actualProbabilities = getActualProbabilities(rects);

    Set<List<Integer>> rectPoints = rectPoints(rects);
    assertThat(actualProbabilities.keySet()).containsExactlyElementsIn(rectPoints);
    assertThat(actualProbabilities.values().stream().mapToDouble(Double::doubleValue).sum())
        .isEqualTo(1);
    for (List<Integer> point : rectPoints) {
      assertThat(actualProbabilities.get(point)).isWithin(TOLERANCE).of(1 / 7d);
    }
  }

  @Test
  void singlePoint() {
    int[][] rects = {{0, 0, 0, 0}};
    Map<List<Integer>, Double> actualProbabilities = getActualProbabilities(rects);
    assertThat(actualProbabilities).containsExactly(ImmutableList.of(0, 0), 1d);
  }

  // helper method to run random trials
  private Map<List<Integer>, Double> getActualProbabilities(int[][] rects) {
    P497RandomPointInNonOverlappingRectangles.Solution p497 =
        new P497RandomPointInNonOverlappingRectangles.Solution(rects);

    // workaround for https://bugs.java.com/bugdatabase/view_bug.do?bug_id=8219318
    Map<? extends List<Integer>, Long> pointCounts =
        IntStream.range(0, NUM_TRIALS)
            .mapToObj(i -> p497.pick())
            .map(a -> Arrays.stream(a).boxed().collect(toImmutableList()))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return pointCounts.entrySet().stream()
        .collect(toImmutableMap(Map.Entry::getKey, e -> (double) e.getValue() / NUM_TRIALS));
  }

  private Set<List<Integer>> rectPoints(int[][] rects) {
    return Arrays.stream(rects)
        .flatMap(
            rect ->
                IntStream.rangeClosed(rect[0], rect[2])
                    .boxed()
                    .flatMap(
                        x ->
                            IntStream.rangeClosed(rect[1], rect[3])
                                .mapToObj(y -> ImmutableList.of(x, y))))
        .collect(toImmutableSet());
  }
}
