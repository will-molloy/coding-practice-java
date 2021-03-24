package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.collect.ImmutableSet.toImmutableSet;
import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Ints;
import com.wilmol.testlib.RandomTrials;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * P497RandomPointInNonOverlappingRectanglesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P497RandomPointInNonOverlappingRectanglesTest {

  private static final double TOLERANCE = 0.02;

  @Test
  void example1() {
    int[][] rects = {{1, 1, 5, 5}};
    P497RandomPointInNonOverlappingRectangles.Solution p497 =
        new P497RandomPointInNonOverlappingRectangles.Solution(rects);

    ImmutableMap<List<Integer>, Double> actualProbabilities =
        RandomTrials.getActualProbabilities(() -> Ints.asList(p497.pick()));

    Set<List<Integer>> rectPoints = rectPoints(rects);
    assertThat(actualProbabilities.keySet()).containsExactlyElementsIn(rectPoints);
    for (List<Integer> point : rectPoints) {
      assertThat(actualProbabilities.get(point)).isWithin(TOLERANCE).of(1 / 25d);
    }
  }

  @Test
  void example2() {
    int[][] rects = {{-2, -2, -1, -1}, {1, 0, 3, 0}};
    P497RandomPointInNonOverlappingRectangles.Solution p497 =
        new P497RandomPointInNonOverlappingRectangles.Solution(rects);

    ImmutableMap<List<Integer>, Double> actualProbabilities =
        RandomTrials.getActualProbabilities(() -> Ints.asList(p497.pick()));

    Set<List<Integer>> rectPoints = rectPoints(rects);
    assertThat(actualProbabilities.keySet()).containsExactlyElementsIn(rectPoints);
    for (List<Integer> point : rectPoints) {
      assertThat(actualProbabilities.get(point)).isWithin(TOLERANCE).of(1 / 7d);
    }
  }

  @Test
  void singlePoint() {
    int[][] rects = {{0, 0, 0, 0}};
    P497RandomPointInNonOverlappingRectangles.Solution p497 =
        new P497RandomPointInNonOverlappingRectangles.Solution(rects);

    ImmutableMap<List<Integer>, Double> actualProbabilities =
        RandomTrials.getActualProbabilities(() -> Ints.asList(p497.pick()));

    assertThat(actualProbabilities).containsExactly(ImmutableList.of(0, 0), 1d);
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
