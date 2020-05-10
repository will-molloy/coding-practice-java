package wilmol.leetcode.problemset.algorithms.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wilmol on 2020-05-11.
 *
 * <p><a
 * href=https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree>https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(h)
 *
 * <p>Key: When doing DFS think about what should be returned; here, whether or not the subtree has
 * an apple.
 *
 * <p>Also the structure is a tree (not any graph) so nodes only have one parent, so can use simple
 * algorithms like DFS, no need for MST.
 *
 * <p>Also DFS is just recursion; don't need a {@code Stack} or a {@code Node} class, just call the
 * method as soon as child is seen.
 */
class P1443MinimumTimeToCollectAllApplesInATree {

  private int cost;

  public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    Map<Integer, Set<Integer>> adjList = new HashMap<>();
    for (int[] edge : edges) {
      adjList.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
    }

    cost = 0;
    dfs(0, adjList, hasApple);
    // -1 cause already at root node; *2 cause have to travel back to root node
    // (in other words, number of edges * 2)
    return Math.max(0, (cost - 1) * 2);
  }

  // return true if subtree has apple
  private boolean dfs(int node, Map<Integer, Set<Integer>> adjList, List<Boolean> hasApple) {
    boolean childApple = false;
    for (int child : adjList.getOrDefault(node, Collections.emptySet())) {
      // must put childApple second otherwise short circuit could skip the DFS
      childApple = dfs(child, adjList, hasApple) || childApple;
    }

    boolean apple = hasApple.get(node) || childApple;
    if (apple) {
      // if subtree has an apple then we must traverse to this node, so increase cost
      // basically, cost will store the min number of nodes we must visit
      // think of it like, any node has an apple, then all nodes on the path from the root down to
      // it have apples
      cost++;
    }
    return apple;
  }
}
