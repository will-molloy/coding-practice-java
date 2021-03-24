package com.wilmol.testlib;

import static com.google.common.collect.ImmutableMap.toImmutableMap;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Utility for running random trials in tests.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
public final class RandomTrials {

  private static final int NUM_TRIALS = 1_000_000;

  /**
   * Runs random trials for some {@code randomEventGenerator}. Collects the actual probability of
   * each event.
   *
   * @param randomEventGenerator the {@code randomEventGenerator}, generates a random event
   * @param <T> the type of the random events
   * @return the actual probabilities of each event
   */
  public static <T> ImmutableMap<T, Double> getActualProbabilities(
      Supplier<? extends T> randomEventGenerator) {
    // run trials, collecting distribution of each event
    Map<? extends T, Long> map =
        IntStream.range(0, NUM_TRIALS)
            .mapToObj(i -> randomEventGenerator.get())
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    // convert distribution to probability percentage
    return map.entrySet().stream()
        .collect(toImmutableMap(Map.Entry::getKey, e -> (double) e.getValue() / NUM_TRIALS));
  }

  private RandomTrials() {}
}
