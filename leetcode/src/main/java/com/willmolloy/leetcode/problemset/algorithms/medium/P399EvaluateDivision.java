package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/evaluate-division>https://leetcode.com/problems/evaluate-division/</a>
 *
 * <p>Runtime: O({@code equations} + {@code queries} * (nodes + edges)) (nodes = number of unique
 * variables, edges = number of edges (proportional to {@code equations}?))
 *
 * <p>Extra memory: O(nodes + edges)
 *
 * <p>Key idea: Represent the equations as a graph. Variables = nodes, edge costs = values. Path
 * cost = product of edge costs.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P399EvaluateDivision {

  // TODO disjoint set version

  public double[] calcEquation(
      List<List<String>> equations, double[] values, List<List<String>> queries) {

    // build graph
    Map<String, Map<String, Double>> adjList = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      String a = equations.get(i).get(0);
      String b = equations.get(i).get(1);
      double k = values[i];
      adjList.computeIfAbsent(a, x -> new HashMap<>()).put(b, k);
      adjList.computeIfAbsent(b, x -> new HashMap<>()).put(a, 1 / k);
    }

    // evaluate queries
    double[] result = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      String a = queries.get(i).get(0);
      String b = queries.get(i).get(1);
      result[i] = pathCost(a, b, adjList);
    }
    return result;
  }

  private double pathCost(String a, String b, Map<String, Map<String, Double>> adjList) {
    if (!adjList.containsKey(a) || !adjList.containsKey(b)) {
      return -1;
    }
    if (a.equals(b)) {
      return 1;
    }

    // BFS

    Queue<String> queue = new ArrayDeque<>();
    queue.add(a);
    Set<String> seen = new HashSet<>();
    seen.add(a);
    Map<String, Map.Entry<String, Double>> predecessors = new HashMap<>();

    while (!queue.isEmpty()) {
      String node = queue.remove();

      for (Map.Entry<String, Double> adj : adjList.get(node).entrySet()) {
        String adjNode = adj.getKey();
        if (!seen.add(adjNode)) {
          continue;
        }
        double adjNodeCost = adj.getValue();

        predecessors.put(adjNode, Map.entry(node, 1 / adjNodeCost));
        queue.add(adjNode);

        if (adjNode.equals(b)) {
          // traverse predecessor tree from b to a
          // cost is product of edges
          double cost = 1;
          String n = b;
          while (!n.equals(a)) {
            Map.Entry<String, Double> predecessor = predecessors.get(n);
            cost *= predecessor.getValue();
            n = predecessor.getKey();
          }
          // reciprocal because cost is from b -> a, but we want a -> b
          return 1 / cost;
        }
      }
    }
    // a and b are in different connected components
    return -1;
  }
}
