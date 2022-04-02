package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/find-right-interval>https://leetcode.com/problems/find-right-interval/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Store original indices some how (object or map) as they're needed for the result. Then
 * binary search on interval start points.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P436FindRightInterval {

  int[] findRightInterval(int[][] intervals);

  /**
   * Approach which uses a custom object to track original interval indices and a manual binary
   * search over interval start points.
   */
  class WithCustomObjectAndBinarySearch implements P436FindRightInterval {

    @Override
    public int[] findRightInterval(int[][] intervals) {
      List<ArrayIndex> list =
          IntStream.range(0, intervals.length)
              .mapToObj(i -> new ArrayIndex(intervals[i], i))
              // sort by start point so we can binary search on start points
              .sorted(Comparator.comparingInt(arrayIndex -> arrayIndex.array[0]))
              .collect(Collectors.toList());

      for (int i = 0; i < list.size(); i++) {
        int end = list.get(i).array[1];
        int best = -1;

        int l = i + 1;
        int r = list.size() - 1;
        while (l <= r) {
          int m = l + (r - l) / 2;
          int start = list.get(m).array[0];
          if (start >= end) {
            best = list.get(m).index;
            // try find smaller start point
            r = m - 1;
          } else {
            // try find a start point
            l = m + 1;
          }
        }

        list.get(i).rightIndex = best;
      }

      return list.stream()
          .sorted(Comparator.comparingInt(arrayIndex -> arrayIndex.index))
          .mapToInt(arrayIndex -> arrayIndex.rightIndex)
          .toArray();
    }

    private static final class ArrayIndex {
      private final int[] array;

      private final int index;

      private int rightIndex = -1;

      private ArrayIndex(int[] a, int i) {
        this.array = a;
        this.index = i;
      }
    }
  }

  /**
   * Approach which uses a {@code TreeMap} to both track original interval indices and also provide
   * efficient searches of interval start points.
   */
  class WithTreeMap implements P436FindRightInterval {

    @Override
    public int[] findRightInterval(int[][] intervals) {
      int n = intervals.length;

      NavigableMap<Integer, Integer> map = new TreeMap<>();
      for (int i = 0; i < n; i++) {
        // key by start point so internally the red-black tree sorts by start point
        map.put(intervals[i][0], i);
      }

      int[] result = new int[n];
      for (int i = 0; i < n; i++) {
        int end = intervals[i][1];
        // find least start point greater than or equal to end (exactly what ceilingEntry does)
        int minStart =
            Optional.ofNullable(map.ceilingEntry(end)).map(Map.Entry::getValue).orElse(-1);
        result[i] = minStart;
      }
      return result;
    }
  }
}
