package com.wilmol.hackerrank.interviewpreparationkit.graphs.hard;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs>https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs</a>
 *
 * <p>Runtime: TODO
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class BfsShortestReachInAGraph {

  private BfsShortestReachInAGraph() {}

  private static final int EDGE_COST = 6;

  static int[] bfsAdjList(final int[][] adjList, final int source) {
    int[] costs = new int[adjList.length];
    for (int i = 0; i < costs.length; i++) {
      costs[i] = -1;
    }
    costs[source] = 0;

    // perform the BFS, finding distance to every node from the source
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(source);
    while (!queue.isEmpty()) {
      int node = queue.remove();
      // list directly stores adjNode
      for (int adjNode : adjList[node]) {
        // only process unvisited nodes
        if (costs[adjNode] != -1) {
          continue;
        }
        costs[adjNode] = costs[node] + EDGE_COST;
        queue.add(adjNode);
      }
    }
    // exclude source node
    return IntStream.range(0, adjList.length)
        .filter(node -> node != source)
        .map(node -> costs[node])
        .toArray();
  }

  static int[] bfsAdjMatrix(final int[][] adjMatrix, final int source) {
    int[] costs = new int[adjMatrix.length];
    for (int i = 0; i < costs.length; i++) {
      costs[i] = -1;
    }
    costs[source] = 0;

    // perform the BFS, finding distance to every node from the source
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(source);
    while (!queue.isEmpty()) {
      int node = queue.remove();
      // must iterate all nodes (matrix stores 1 if adjNode, else 0)
      for (int adjNode = 0; adjNode < adjMatrix[node].length; adjNode++) {
        int costToAdjNode = adjMatrix[node][adjNode];
        // only process reachable (i.e. neighbouring) and unvisited nodes
        if (costToAdjNode == 0 || costs[adjNode] != -1) {
          continue;
        }
        costs[adjNode] = costs[node] + costToAdjNode * EDGE_COST;
        queue.add(adjNode);
      }
    }
    // exclude source node
    return IntStream.range(0, adjMatrix.length)
        .filter(node -> node != source)
        .map(node -> costs[node])
        .toArray();
  }
}
