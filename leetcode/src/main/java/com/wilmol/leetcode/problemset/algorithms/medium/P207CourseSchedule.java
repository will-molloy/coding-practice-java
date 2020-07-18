package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/course-schedule>https://leetcode.com/problems/course-schedule/</a>
 *
 * <p>Runtime: O(n + p) - {@code dfs} is O(n + p)
 *
 * <p>Extra space: O(n + p) - {@code dfs} stack space is O(n), {@code adjList} is O(p)
 *
 * <p>Key: Topological sort (via DFS), considering each node as the source (could test which nodes
 * are source nodes (those with no incoming edges)).
 *
 * <p>Performance boost by marking nodes as {@code DONE} (drops runtime from O(n<sup>2</sup>) to
 * O(n)) because it memoises the result; when a node is {@code DONE} we know we have already
 * traversed its neighbours.
 *
 * @see P210CourseSchedule2
 * @see P332ReconstructItinerary
 * @see P785IsGraphBipartite
 * @see P886PossibleBipartition
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P207CourseSchedule {

  // TODO BFS can be used too

  public boolean canFinish(int numCourses, int[][] prerequisites) {

    Map<Integer, Set<Integer>> adjList = new LinkedHashMap<>();

    for (int[] edge : prerequisites) {
      // directed graph
      adjList.computeIfAbsent(edge[0], k -> new LinkedHashSet<>()).add(edge[1]);
    }

    Seen[] seen = new Seen[numCourses];
    for (int source = 0; source < numCourses; source++) {
      if (!dfs(source, seen, adjList)) {
        return false;
      }
    }
    return true;
  }

  private enum Seen {
    NOT_SEEN,
    SEEN,
    DONE;
  }

  private boolean dfs(int node, Seen[] seen, Map<Integer, Set<Integer>> adjList) {
    if (seen[node] == Seen.SEEN) {
      return false;
    }
    if (seen[node] == Seen.DONE) {
      return true;
    }

    seen[node] = Seen.SEEN;
    for (int adjNode : adjList.getOrDefault(node, Collections.emptySet())) {
      if (!dfs(adjNode, seen, adjList)) {
        return false;
      }
    }

    // mark as DONE so we know we've already traversed this nodes children without detecting a cycle
    // can't keep as SEEN because we may see it again via another path and we don't want to confuse
    // such a path with a cycle
    seen[node] = Seen.DONE;
    return true;
  }
}
