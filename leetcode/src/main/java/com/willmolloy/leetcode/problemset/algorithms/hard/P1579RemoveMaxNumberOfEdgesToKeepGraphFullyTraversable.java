package com.willmolloy.leetcode.problemset.algorithms.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable>https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/</a>
 *
 * <p>Runtime: O(n + e)
 *
 * <p>Extra memory: O(n + e)
 *
 * <p>Key: Get combined MST for both Alice and Bob favouring the shared edges.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P1584MinCostToConnectAllPoints
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1579RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {

  public int maxNumEdgesToRemove(int n, int[][] edges) {
    // solution:
    // 1. make MST for both alice and bob
    // 2. combine MSTs by taking intersection
    // 3. difference of total num edges - combined MST = num edges can be removed

    // {cost, src, dst}
    List<List<Integer>> aliceEdges = new ArrayList<>();
    List<List<Integer>> bobEdges = new ArrayList<>();
    // add shared edges first so they're favoured in the MST
    for (int[] edge : edges) {
      if (edge[0] == 3) {
        aliceEdges.add(Arrays.asList(1, edge[1], edge[2]));
        bobEdges.add(Arrays.asList(1, edge[1], edge[2]));
      }
    }
    // add unshared edges
    for (int[] edge : edges) {
      if (edge[0] == 1) {
        aliceEdges.add(Arrays.asList(2, edge[1], edge[2]));
      } else {
        // use different cost to alice so combined mst considers them differently (i.e. in the
        // Set.addAll)
        bobEdges.add(Arrays.asList(3, edge[1], edge[2]));
      }
    }

    Set<List<Integer>> aliceMst = mst(n, aliceEdges);
    if (aliceMst.size() != n - 1) {
      return -1;
    }
    Set<List<Integer>> bobMst = mst(n, bobEdges);
    if (bobMst.size() != n - 1) {
      return -1;
    }

    // intersection
    Set<List<Integer>> combinedMst = new HashSet<>();
    combinedMst.addAll(aliceMst);
    combinedMst.addAll(bobMst);

    return edges.length - combinedMst.size();
  }

  private int[] parent;

  // kruskals algorithm
  // assumed edges already sorted
  private Set<List<Integer>> mst(int n, List<List<Integer>> edges) {
    // make n sets
    parent = IntStream.rangeClosed(0, n).toArray();

    Set<List<Integer>> mstEdges = new HashSet<>();

    // process edges until mst found or ran out of edges
    for (int i = 0; i < edges.size() && mstEdges.size() < n - 1; i++) {
      List<Integer> edge = edges.get(i);
      int src = edge.get(1);
      int dst = edge.get(2);

      int srcSet = find(src);
      int dstSet = find(dst);

      if (srcSet != dstSet) {
        // nodes in different tree, merge trees
        union(srcSet, dstSet);
        mstEdges.add(edge);
      }
    }
    return mstEdges;
  }

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
