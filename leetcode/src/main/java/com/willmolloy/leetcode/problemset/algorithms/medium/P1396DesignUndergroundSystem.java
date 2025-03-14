package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a
 * href=https://leetcode.com/problems/design-underground-system>https://leetcode.com/problems/design-underground-system/</a>
 *
 * <p>Runtime: each operation is O(1)
 *
 * <p>Extra memory: each operation is O(1)
 *
 * <p>Key idea: Two maps, one to store check in values, and one to store average time for each
 * station pair as a fraction.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1396DesignUndergroundSystem {

  /** UndergroundSystem. */
  static class UndergroundSystem {

    private final Map<Integer, Pair<String, Integer>> checkIn;
    private final Map<Pair<String, String>, Pair<Integer, Integer>> avgTime;

    UndergroundSystem() {
      checkIn = new HashMap<>();
      avgTime = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
      checkIn.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
      Pair<String, Integer> checkIn = this.checkIn.get(id);
      avgTime.merge(
          new Pair<>(checkIn.a, stationName),
          new Pair<>(t - checkIn.b, 1),
          (a, b) -> new Pair<>(a.a + b.a, a.b + b.b));
    }

    public double getAverageTime(String startStation, String endStation) {
      Pair<Integer, Integer> avgTime = this.avgTime.get(new Pair<>(startStation, endStation));
      return (double) avgTime.a / avgTime.b;
    }

    /**
     * Pair.
     *
     * @param <A> a type
     * @param <B> b type
     */
    private static final class Pair<A, B> {
      final A a;
      final B b;

      Pair(A a, B b) {
        this.a = a;
        this.b = b;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(a, pair.a) && Objects.equals(b, pair.b);
      }

      @Override
      public int hashCode() {
        return Objects.hash(a, b);
      }
    }
  }
}
