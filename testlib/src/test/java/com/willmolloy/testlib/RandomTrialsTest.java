package com.willmolloy.testlib;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Ints;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * RandomTrialsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class RandomTrialsTest {

  private static final double TOLERANCE = 0.02;

  @Test
  void testGetActualProbabilitiesSingleEvent() {
    ImmutableMap<Integer, Double> actualProbabilities =
        RandomTrials.getActualProbabilities(() -> 1);

    assertThat(actualProbabilities).containsExactly(1, 1d);
  }

  @Test
  void testGetActualProbabilitiesUniformDistribution() {
    ImmutableMap<Integer, Double> actualProbabilities =
        RandomTrials.getActualProbabilities(() -> ThreadLocalRandom.current().nextInt(5));

    assertThat(actualProbabilities.values().stream().mapToDouble(Double::doubleValue).sum())
        .isEqualTo(1);

    assertThat(actualProbabilities.keySet())
        .containsExactlyElementsIn(Ints.asList(IntStream.range(0, 5).toArray()));
    for (int i : IntStream.range(0, 5).toArray()) {
      assertThat(actualProbabilities.get(i)).isWithin(TOLERANCE).of(0.2);
    }
  }

  @Test
  void testGetActualProbabilitiesSkewedDistribution() {
    // rolling 2 dice
    ImmutableMap<Integer, Double> actualProbabilities =
        RandomTrials.getActualProbabilities(
            () ->
                ThreadLocalRandom.current().nextInt(1, 7)
                    + ThreadLocalRandom.current().nextInt(1, 7));

    assertThat(actualProbabilities.values().stream().mapToDouble(Double::doubleValue).sum())
        .isEqualTo(1);

    assertThat(actualProbabilities.keySet())
        .containsExactlyElementsIn(Ints.asList(IntStream.rangeClosed(2, 12).toArray()));
    assertThat(actualProbabilities.get(2)).isWithin(TOLERANCE).of(1d / 36);
    assertThat(actualProbabilities.get(3)).isWithin(TOLERANCE).of(2d / 36);
    assertThat(actualProbabilities.get(4)).isWithin(TOLERANCE).of(3d / 36);
    assertThat(actualProbabilities.get(5)).isWithin(TOLERANCE).of(4d / 36);
    assertThat(actualProbabilities.get(6)).isWithin(TOLERANCE).of(5d / 36);
    assertThat(actualProbabilities.get(7)).isWithin(TOLERANCE).of(6d / 36);
    assertThat(actualProbabilities.get(8)).isWithin(TOLERANCE).of(5d / 36);
    assertThat(actualProbabilities.get(9)).isWithin(TOLERANCE).of(4d / 36);
    assertThat(actualProbabilities.get(10)).isWithin(TOLERANCE).of(3d / 36);
    assertThat(actualProbabilities.get(11)).isWithin(TOLERANCE).of(2d / 36);
    assertThat(actualProbabilities.get(12)).isWithin(TOLERANCE).of(1d / 36);
  }
}
