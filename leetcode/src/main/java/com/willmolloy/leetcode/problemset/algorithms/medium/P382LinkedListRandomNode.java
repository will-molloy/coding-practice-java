package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.ListNode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <a
 * href=https://leetcode.com/problems/linked-list-random-node>https://leetcode.com/problems/linked-list-random-node/</a>
 *
 * <p>Runtime: O(n) ctr O(1) {@code getRandom()}.
 *
 * <p>Extra memory: O(n) TODO O(1) space
 *
 * <p>Key: Store nodes in table for O(1) lookup.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P382LinkedListRandomNode {

  /** Solution class. */
  static class Solution {

    private final Map<Integer, ListNode> map;

    private final int n;

    Solution(ListNode head) {
      Map<Integer, ListNode> map = new HashMap<>();
      int i = 0;
      while (head != null) {
        map.put(i, head);
        head = head.next;
        i++;
      }
      this.map = Collections.unmodifiableMap(map);
      n = i;
    }

    int getRandom() {
      int i = ThreadLocalRandom.current().nextInt(n);
      return map.get(i).val;
    }
  }
}
