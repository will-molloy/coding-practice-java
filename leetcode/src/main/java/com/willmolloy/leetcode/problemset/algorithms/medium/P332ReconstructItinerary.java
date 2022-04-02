package com.willmolloy.leetcode.problemset.algorithms.medium;

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
 * <p>Runtime: O(|e|)
 *
 * <p>Extra memory: O(|e|)
 *
 * <p>Key: Eulerian path (variation of topological sort, except it works with cycles); remove edges
 * as they're used such that cycles are ignored and each edge is used exactly once. It is exactly
 * what this problem wants.
 *
 * <p>Note that Eulerian path/circuit doesn't apply to every graph. For Eulerian circuit each node
 * must have even degree. For Eulerian path there must be zero or two nodes with odd degree (for the
 * former it means the Eulerian path is also an Eulerian circuit, start node and end node are same).
 *
 * <p>This problem makes it a bit easier by providing a valid graph and the start node.
 *
 * @see P207CourseSchedule
 * @see P210CourseSchedule2
 * @see P785IsGraphBipartite
 * @see P886PossibleBipartition
 * @see <a href=https://en.wikipedia.org/wiki/Eulerian_path>Wikipedia: Eulerian path</a>
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P332ReconstructItinerary {

  public List<String> findItinerary(List<List<String>> tickets) {
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
    // alternatively could use linked list and add to front
    Collections.reverse(result);
    return result;
  }

  private void dfs(Map<String, PriorityQueue<String>> adjList, List<String> result, String from) {
    if (adjList.containsKey(from)) {
      PriorityQueue<String> tos = adjList.get(from);
      while (!tos.isEmpty()) {
        // remove edge as its processed, this means we won't get stuck in cycles and we'll use all
        // edges exactly once
        dfs(adjList, result, tos.remove());
      }
    }
    // node is processed after its children are processed
    // otherwise result may appear to use edges out of order
    // (definition of topological sort)
    result.add(from);
  }
}
