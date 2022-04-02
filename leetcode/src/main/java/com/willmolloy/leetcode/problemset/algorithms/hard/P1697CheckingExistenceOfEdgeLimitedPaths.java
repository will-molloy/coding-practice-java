package com.willmolloy.leetcode.problemset.algorithms.hard;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths>https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/</a>
 *
 * <p>Runtime: O(n + q * log(q) + e * log(e))
 *
 * <p>Extra memory: O(n + q)
 *
 * <p>Key: Build up a shared disjoint set for all the queries. Do this by sorting the queries/edges
 * (smallest first) so only the edges allowed for the current query are in the set.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
class P1697CheckingExistenceOfEdgeLimitedPaths {

  public boolean[] distanceLimitedPathsExist(int n, int[][] edges, int[][] queries) {
    Map<int[], Integer> original = new IdentityHashMap<>();
    for (int i = 0; i < queries.length; i++) {
      original.put(queries[i], i);
    }

    // start with smaller queries then union allowed edges and so on
    parent = IntStream.rangeClosed(0, n).toArray();

    Map<Integer, Boolean> result = new HashMap<>();
    Arrays.sort(queries, Comparator.comparingInt(a -> a[2]));
    Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

    int qI = 0;
    int eI = 0;
    for (; qI < queries.length; qI++) {
      int[] query = queries[qI];
      while (eI < edges.length && edges[eI][2] < query[2]) {
        union(edges[eI][0], edges[eI][1]);
        eI++;
      }
      result.put(qI, find(query[0]) == find(query[1]));
    }

    // result needs to be in original query order
    boolean[] r = new boolean[queries.length];
    for (int i = 0; i < queries.length; i++) {
      r[original.get(queries[i])] = result.get(i);
    }
    return r;
  }

  private int[] parent;

  private void union(int a, int b) {
    parent[find(a)] = find(b);
  }

  private int find(int a) {
    if (a != parent[a]) {
      parent[a] = find(parent[a]);
    }
    return parent[a];
  }
}
