package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a
 * href=https://leetcode.com/problems/reconstruct-itinerary>https://leetcode.com/problems/reconstruct-itinerary/</a>
 *
 * <p>Runtime: O(|v| + |e|)
 *
 * <p>Extra memory: O(|v|)
 *
 * <p>Key: Topological sort.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P332ReconstructItinerary {

  public List<String> findItinerary(List<List<String>> tickets) {
    // topological sort, except there can be cycles

    // create adj list, use sorted data structure so traverse in sorted (lexicographical) order
    // priority queue = sorted list, need (rather than TreeSet) cause can have duplicate tickets
    Map<String, PriorityQueue<String>> adjList = new HashMap<>();
    for (List<String> ticket : tickets) {
      String from = ticket.get(0);
      String to = ticket.get(1);
      adjList.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
    }

    List<String> result = new ArrayList<>();
    dfs(adjList, result, "JFK");
    // reverse since node is added after its children are processed
    // (definition of topological sort)
    Collections.reverse(result);
    return result;
  }

  private void dfs(Map<String, PriorityQueue<String>> adjList, List<String> result, String from) {
    if (adjList.containsKey(from)) {
      PriorityQueue<String> tos = adjList.get(from);
      while (!tos.isEmpty()) {
        // remove edge so don't get stuck in cycle
        dfs(adjList, result, tos.remove());
      }
    }
    // node is processed after its children are processed
    // otherwise result may appear to use edges out of order
    // (definition of topological sort)
    result.add(from);
  }
}
