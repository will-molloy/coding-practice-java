package wilmol.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wilmol on 2020-06-14.
 *
 * <p><a
 * href=https://leetcode.com/problems/is-graph-bipartite>https://leetcode.com/problems/is-graph-bipartite/</a>
 *
 * <p>Runtime: O(|v| + |e|)
 *
 * <p>Extra space: O(|v|) (already given adj list, so not included here)
 *
 * <p>Key: DFS colouring algorithm.
 *
 * @see P886PossibleBipartition
 */
class P785IsGraphBipartite {

  private enum Colour {
    BLACK,
    WHITE;

    Colour next() {
      return Colour.values()[(ordinal() + 1) % Colour.values().length];
    }
  }

  public boolean isBipartite(int[][] graph) {
    // graph is already adj list

    Map<Integer, Colour> nodeColours = new HashMap<>();

    // dfs from every node cause a node may not reach all other nodes
    for (int src = 0; src < graph.length; src++) {
      if (!nodeColours.containsKey(src)) {
        if (!dfs(graph, nodeColours, src, Colour.BLACK)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean dfs(int[][] adjList, Map<Integer, Colour> nodeColours, int node, Colour colour) {
    if (nodeColours.containsKey(node)) {
      // check trying to be coloured same
      return nodeColours.get(node) == colour;
    }
    nodeColours.put(node, colour);

    Colour nextColour = colour.next();

    for (int adjNode : adjList[node]) {
      if (!dfs(adjList, nodeColours, adjNode, nextColour)) {
        return false;
      }
    }
    return true;
  }
}
