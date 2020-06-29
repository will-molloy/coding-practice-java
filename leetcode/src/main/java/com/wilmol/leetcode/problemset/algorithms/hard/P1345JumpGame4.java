package com.wilmol.leetcode.problemset.algorithms.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/jump-game-iv>https://leetcode.com/problems/jump-game-iv/</a>
 *
 * <p>Difficulty: Hard.
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: {@code Map neighboursMap} to make the BFS more efficient when adding neighbours to queue.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P55JumpGame
 * @see P45JumpGame2
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P1306JumpGame3
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1345JumpGame4 {

  public int minJumps(int[] arr) {
    int n = arr.length;
    if (n <= 1) {
      return 0;
    }

    // dump indices into map so know where we can try jumping
    Map<Integer, List<Integer>> neighboursMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      neighboursMap.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
    }

    // perform BFS so get minimum jumps (all edge costs are 1 so it is the same as Dijkstra's)
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    int jumps = 0;

    Set<Integer> seen = new HashSet<>();
    seen.add(0);

    while (!queue.isEmpty()) {

      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int node = queue.remove();
        if (node == n - 1) {
          return jumps;
        }

        // standard BFS; add neighbours (reachable nodes) to queue
        if (node > 0 && seen.add(node - 1)) {
          queue.add(node - 1);
        }
        if (node < n - 1 && seen.add(node + 1)) {
          queue.add(node + 1);
        }
        List<Integer> neighbours = neighboursMap.get(arr[node]);
        if (neighbours != null) {
          for (int neighbour : neighbours) {
            if (seen.add(neighbour)) {
              queue.add(neighbour);
            }
          }
        }
        // remove processed node from map
        // avoids repeating above for loop over neighbours list which wouldn't add anything to the
        // queue due to seen set check
        neighboursMap.remove(arr[node]);
      }

      // jumps = number of levels in BFS (0 indexed)
      jumps++;
    }

    throw new IllegalArgumentException("Final index unreachable");
  }
}
