package wilmol.leetcode.problemset.algorithms.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wilmol on 2020-05-27.
 *
 * <p><a
 * href=https://leetcode.com/problems/possible-bipartition>https://leetcode.com/problems/possible-bipartition/</a>
 *
 * <p>Runtime: O(n + d) - creating adj list is O(d), DFS is O(n + d)
 *
 * <p>Extra space: O(n + d) - colours map and DFS stack space is O(n), adj list is O(d)
 *
 * <p>Key: Track node colours in hashmap. Colour with DFS. Consider that any node could be a source
 * node.
 *
 * @see P207CourseSchedule
 * @see P785IsGraphBipartite
 */
class P886PossibleBipartition {

  private enum Colour {
    BLACK,
    WHITE;
  }

  public boolean possibleBipartition(int n, int[][] dislikes) {
    // colour graph with 2 colours
    Map<Integer, Colour> colours = new HashMap<>();

    // convert to adjacency list graph representation
    Map<Integer, Set<Integer>> adjList = new HashMap<>();
    for (int[] edge : dislikes) {
      // undirected graph
      adjList.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
      adjList.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
    }

    // graph may be disjoint so need to try each node as the source
    for (int source = 1; source <= n; source++) {
      if (!colours.containsKey(source)) {
        if (!dfs(source, Colour.BLACK, colours, adjList)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean dfs(
      int node, Colour colour, Map<Integer, Colour> colours, Map<Integer, Set<Integer>> adjList) {
    // colour the node
    if (colours.containsKey(node)) {
      // node is already coloured, check its not trying to be coloured differently
      return colours.get(node) == colour;
    }
    colours.put(node, colour);

    // traverse adjacent nodes, DFS
    Colour nextColour = colour == Colour.BLACK ? Colour.WHITE : Colour.BLACK;
    for (int adjNode : adjList.getOrDefault(node, Collections.emptySet())) {
      if (!dfs(adjNode, nextColour, colours, adjList)) {
        return false;
      }
    }
    return true;
  }
}
