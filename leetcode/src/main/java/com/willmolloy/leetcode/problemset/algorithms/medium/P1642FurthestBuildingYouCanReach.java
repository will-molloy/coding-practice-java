package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.PriorityQueue;

/**
 * <a
 * href=https://leetcode.com/problems/furthest-building-you-can-reach>https://leetcode.com/problems/furthest-building-you-can-reach/</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P1642FurthestBuildingYouCanReach {

  int furthestBuilding(int[] heights, int bricks, int ladders);

  /**
   * DFS brute force.
   *
   * <p>Runtime: O(2<sup>n</sup>)
   *
   * <p>Extra memory: O(n)
   *
   * <p>Choice of ladder or bricks creates a tree.
   */
  class Dfs implements P1642FurthestBuildingYouCanReach {

    private int max;

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
      max = 0;
      dfs(0, heights, bricks, ladders);
      return max;
    }

    private void dfs(int i, int[] heights, int bricks, int ladders) {
      // need this pruning to pass TLE, it should TLE but leetcode has poor test cases
      if (max == heights.length - 1) {
        return;
      }

      // precondition to updating max
      if (bricks < 0 || ladders < 0) {
        return;
      }

      max = Math.max(max, i);

      // bounds guard
      if (i == heights.length - 1) {
        return;
      }

      if (heights[i] >= heights[i + 1]) {
        dfs(i + 1, heights, bricks, ladders);
      } else {
        // use ladder
        dfs(i + 1, heights, bricks, ladders - 1);
        // use bricks
        dfs(i + 1, heights, bricks - (heights[i + 1] - heights[i]), ladders);
      }
    }
  }

  /**
   * Greedy approach.
   *
   * <p>Runtime: O(n * log(n))
   *
   * <p>Extra memory: O(n)
   *
   * <p>Key: Greedy. Prefer to use ladders, if forced to use bricks then use on smallest height
   * diff. Use priority queue to track height diffs.
   */
  class Greedy implements P1642FurthestBuildingYouCanReach {

    @Override
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
      PriorityQueue<Integer> pq = new PriorityQueue<>();

      for (int i = 0; i < heights.length - 1; i++) {
        if (heights[i] >= heights[i + 1]) {
          continue;
        }
        pq.add(heights[i + 1] - heights[i]);
        if (pq.size() > ladders) {
          // must use bricks to reach here, use bricks on smallest diff
          bricks -= pq.remove();
        }
        if (bricks < 0) {
          return i;
        }
      }
      // reached end
      return heights.length - 1;
    }
  }
}
