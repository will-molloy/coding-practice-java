package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href=https://leetcode.com/problems/clone-graph>https://leetcode.com/problems/clone-graph/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key idea: Only create the copied nodes once. Used a {@code HashMap} to achieve this.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P133CloneGraph {

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    return dfs(node, new HashMap<>());
  }

  private Node dfs(Node node, Map<Integer, Node> nodeCopies) {
    Node copy = nodeCopies.get(node.val);
    if (copy == null) {
      copy = new Node(node.val);
      nodeCopies.put(node.val, copy);
      for (Node adjNode : node.neighbors) {
        copy.neighbors.add(dfs(adjNode, nodeCopies));
      }
    }
    return copy;
  }

  /** Node. */
  static final class Node {
    private final int val;
    private final List<Node> neighbors;

    Node(int val) {
      this.val = val;
      this.neighbors = new ArrayList<>();
    }

    int val() {
      return val;
    }

    List<Node> neighbors() {
      return neighbors;
    }
  }
}
