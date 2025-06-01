package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/partition-labels>https://leetcode.com/problems/partition-labels/</a>
 *
 * @see P56MergeIntervals
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P57InsertInterval
 * @see P435NonOverlappingIntervals
 * @see P452MinimumNumberOfArrowsToBurstBalloons
 * @see P986IntervalListIntersections
 * @see P1288RemoveCoveredIntervals
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
sealed interface P763PartitionLabels {

  List<Integer> partitionLabels(String s);

  /**
   * Runtime: O(n) (constant number of characters/ranges)
   *
   * <p>Extra memory: O(1) (constant number of characters/ranges)
   *
   * <p>Key idea: Identify intervals for each character and then merge them.
   *
   * <p>Merge intervals: sort by start, then intervals which overlap will be contiguous.
   */
  final class MergeIntervals implements P763PartitionLabels {

    @Override
    public List<Integer> partitionLabels(String s) {
      // merge at most 26 ranges (1 for each char)

      // create ranges
      Map<Character, List<Integer>> ranges = new HashMap<>();
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (!ranges.containsKey(c)) {
          List<Integer> list = new ArrayList<>(Collections.nCopies(2, i));
          ranges.put(c, list);
        } else {
          ranges.get(c).set(1, i);
        }
      }

      // merge intervals
      // sort by start
      List<List<Integer>> sortedRanges = new ArrayList<>(ranges.values());
      sortedRanges.sort(Comparator.comparing(l -> l.getFirst()));

      List<List<Integer>> result = new ArrayList<>();

      for (List<Integer> range : sortedRanges) {
        if (result.isEmpty()) {
          // init
          result.add(range);
        } else {
          List<Integer> prevRange = result.getLast();
          if (prevRange.get(1) < range.get(0)) {
            // doesn't overlap
            result.add(range);
          } else {
            // overlaps, merge
            prevRange.set(1, Math.max(prevRange.get(1), range.get(1)));
          }
        }
      }
      return result.stream()
          .map(list -> list.get(1) - list.getFirst() + 1)
          .collect(Collectors.toList());
    }
  }

  /**
   * Runtime: O(n)
   *
   * <p>Extra memory: O(1) (constant number of characters)
   *
   * <p>Key idea: Pre compute last index of each character.
   */
  final class Greedy implements P763PartitionLabels {

    // what makes this greedy?
    // 1. the fact we extend the range to the end of each character processed (greedily skip over in
    // between characters)
    // 2. the fact we begin working on a new range immediately upon finding the end (greedily create
    // as many ranges as possible)

    @Override
    public List<Integer> partitionLabels(String s) {
      // store last index of each character
      Map<Character, Integer> last = new HashMap<>();
      for (int i = 0; i < s.length(); i++) {
        last.put(s.charAt(i), i);
      }

      int start = 0;
      int end = 0;
      List<Integer> result = new ArrayList<>();
      for (int i = 0; i < s.length(); i++) {
        // range must end at maximum last index of each character in the range
        end = Math.max(end, last.get(s.charAt(i)));
        if (i == end) {
          // found end of range
          result.add(end - start + 1);
          start = i + 1;
        }
      }
      return result;
    }
  }
}
