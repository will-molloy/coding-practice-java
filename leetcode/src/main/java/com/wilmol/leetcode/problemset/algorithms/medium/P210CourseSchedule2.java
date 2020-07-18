package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/course-schedule-ii>https://leetcode.com/problems/course-schedule-ii/</a>
 *
 * <p>Runtime: O(n + p) - {@code dfs} is O(n + p)
 *
 * <p>Extra memory: O(n + p) - {@code dfs} stack space is O(n), {@code adjList} is O(p)
 *
 * <p>Key: Topological sort (extension to {@link P207CourseSchedule}), remember to reverse list at
 * the end!
 *
 * @see P207CourseSchedule
 * @see P785IsGraphBipartite
 * @see P886PossibleBipartition
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P210CourseSchedule2 {

  // TODO BFS can be used too

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> adjList = buildGraph(prerequisites);

    // white = unseen
    // grey = seen (not finished)
    // black = seen (finished)
    Map<Integer, Colour> colour = new HashMap<>();
    for (int node = 0; node < numCourses; node++) {
      colour.put(node, Colour.WHITE);
    }
    List<Integer> order = new ArrayList<>();

    for (int source = 0; source < numCourses; source++) {
      if (!dfs(adjList, colour, order, source)) {
        return new int[0];
      }
    }

    // reverse as DFS marks sinks as black first
    Collections.reverse(order);
    return order.stream().mapToInt(i -> i).toArray();
  }

  private boolean dfs(
      Map<Integer, List<Integer>> adjList,
      Map<Integer, Colour> colour,
      List<Integer> order,
      int node) {
    if (colour.get(node) == Colour.GREY) {
      // seen before finishing its children, must be cycle
      return false;
    }
    if (colour.get(node) == Colour.BLACK) {
      // already processed this node
      return true;
    }

    colour.put(node, Colour.GREY);
    for (int adjNode : adjList.getOrDefault(node, Collections.emptyList())) {
      if (!dfs(adjList, colour, order, adjNode)) {
        return false;
      }
    }

    colour.put(node, Colour.BLACK);
    order.add(node);
    return true;
  }

  private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    for (int[] edge : edges) {
      // edge is backwards in this problem
      adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
    }
    return Collections.unmodifiableMap(adjList);
  }

  private enum Colour {
    WHITE,
    GREY,
    BLACK;
  }
}
