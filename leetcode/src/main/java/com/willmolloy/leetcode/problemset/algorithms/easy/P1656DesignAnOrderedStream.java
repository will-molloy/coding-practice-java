package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/design-an-ordered-stream>https://leetcode.com/problems/design-an-ordered-stream/</a>
 *
 * <p>Runtime: O(n) - exactly n calls to insert - ptr only moves forward [1, n] so each value is
 * read at most once, so that while loop is amortised O(n) over all calls to insert
 *
 * <p>Extra memory: O(n) - exactly n calls to insert
 *
 * <p>Key: Reading the question carefully:
 *
 * <ul>
 *   <li>Sequence must be contiguous - as soon as key not in map, stop collecting.
 *   <li>Update ptr to the last id + 1 - so just beyond the list we collected.
 * </ul>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1656DesignAnOrderedStream {

  /** OrderedStream. */
  static class OrderedStream {

    private int ptr;
    private final Map<Integer, String> map;

    OrderedStream(int n) {
      ptr = 1;
      map = new HashMap<>();
    }

    public List<String> insert(int id, String value) {
      map.put(id, value);

      List<String> list = new ArrayList<>();
      while (map.containsKey(ptr)) {
        list.add(map.get(ptr));
        ptr++;
      }
      return list;
    }
  }
}
