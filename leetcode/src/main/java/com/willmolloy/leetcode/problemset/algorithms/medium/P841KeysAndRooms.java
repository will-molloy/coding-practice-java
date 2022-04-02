package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/keys-and-rooms>https://leetcode.com/problems/keys-and-rooms/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Starting with room 0, traverse (BFS or DFS etc) and see if each room is seen.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P841KeysAndRooms {

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    Set<Integer> seen = new HashSet<>();
    seen.add(0);

    while (!queue.isEmpty()) {
      int node = queue.remove();
      for (int adjNode : rooms.get(node)) {
        if (seen.add(adjNode)) {
          queue.add(adjNode);
        }
      }
    }
    return seen.size() == rooms.size();
  }
}
