package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label>https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/</a>
 *
 * <p>Runtime: O(n) ({@code edges.length} = n - 1)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Figuring out how to represent the tree; using {@code Map} so any node can be
 * retrieved in O(1) and {@code Node} class helped.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1519NumberOfNodesInTheSubTreeWithTheSameLabel {

  public int[] countSubTrees(int n, int[][] edges, String labels) {
    // build tree data structure
    Map<Integer, Node> nodes = new HashMap<>();
    for (int i = 0; i < n; i++) {
      nodes.put(i, new Node(i, labels.charAt(i)));
    }
    for (int[] edge : edges) {
      nodes.get(edge[0]).children.add(nodes.get(edge[1]));
      nodes.get(edge[1]).children.add(nodes.get(edge[0]));
    }

    int[] result = new int[n];
    // DFS on root and bubble up counts
    dfs(nodes.get(0), result, new HashSet<>());
    return result;
  }

  // return char counts for tree rooted at 'node'
  private Map<Character, Integer> dfs(Node node, int[] result, Set<Integer> seen) {
    if (node == null || !seen.add(node.num)) {
      return Collections.emptyMap();
    }
    seen.add(node.num);

    Map<Character, Integer> map = new HashMap<>();
    for (Node child : node.children) {
      Map<Character, Integer> childMap = dfs(child, result, seen);
      // merge child counts
      for (Map.Entry<Character, Integer> e : childMap.entrySet()) {
        map.merge(e.getKey(), e.getValue(), Integer::sum);
      }
    }
    // tree rooted at 'node' includes itself
    map.merge(node.label, 1, Integer::sum);

    result[node.num] = map.get(node.label);

    return map;
  }

  private static final class Node {
    final int num;
    final char label;
    final List<Node> children = new ArrayList<>();

    Node(int num, char label) {
      this.num = num;
      this.label = label;
    }
  }
}
