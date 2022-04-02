package com.willmolloy.testlib;

import com.google.common.collect.ImmutableMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Utility for running random trials in tests.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
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
    // run trials
    return IntStream.range(0, NUM_TRIALS)
        .mapToObj(i -> randomEventGenerator.get())
        // collect probability (percentage) of each event
        .collect(
            Collectors.collectingAndThen(
                Collectors.groupingBy(Function.identity(), percentage(NUM_TRIALS)),
                ImmutableMap::copyOf));
  }

  private static <T> Collector<T, ?, Double> percentage(int totalCount) {
    return Collectors.collectingAndThen(
        Collectors.counting(), count -> (double) count / totalCount);
  }

  private RandomTrials() {}
}
