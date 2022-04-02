package com.willmolloy.projecteuler.problems.difficulty5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

/**
 * <a href=https://projecteuler.net/problem=14>https://projecteuler.net/problem=14</a>
 *
 * <p>Runtime: O(n) ..
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P14LongestCollatzSequence {

  private final Map<Long, Integer> cache = new HashMap<>();

  public long apply(final long startingBelow) {
    // Fill the cache
    LongStream.range(1, startingBelow).forEach(this::collatzSequenceLength);

    // Find key (starting point) for the maximum value (longest chain)
    return cache.entrySet().stream()
        .filter(e -> e.getKey() < startingBelow)
        .max(Comparator.comparingInt(Map.Entry::getValue))
        .map(Map.Entry::getKey)
        .orElse(-1L);
  }

  private long collatzSequenceLength(final long n) {
    if (cache.containsKey(n)) {
      return cache.get(n);
    }
    int length;
    if (n == 1) {
      length = 0;
    } else {
      length = 1 + (int) collatzSequenceLength(nextInCollatzSequence(n));
    }
    cache.put(n, length);
    return length;
  }

  private long nextInCollatzSequence(long n) {
    if (n % 2 == 0) {
      return n / 2;
    } else {
      return n * 3 + 1;
    }
  }
}
