package com.willmolloy.projecteuler.problems.difficulty25;

import static com.willmolloy.projecteuler.problems.difficulty10.P81PathSumTwoWays.constructGraph;
import static com.willmolloy.projecteuler.problems.difficulty10.P81PathSumTwoWays.shortestPathsDijkstra;

import com.google.common.graph.ValueGraph;
import com.willmolloy.projecteuler.problems.difficulty10.P81PathSumTwoWays;
import com.willmolloy.projecteuler.problems.difficulty20.P82PathSumThreeWays;
import org.apache.commons.lang3.tuple.Pair;

/**
 * <a href=https://projecteuler.net/problem=83>https://projecteuler.net/problem=83</a>
 *
 * <p>Runtime: TODO
 *
 * @see P81PathSumTwoWays
 * @see P82PathSumThreeWays
 * @see P83PathSumFourWays
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public final class P83PathSumFourWays {

  private P83PathSumFourWays() {}

  static int shortestPath(int[][] matrix) {
    // given matrix where num rows = num cols
    int size = matrix[0].length * matrix[0].length;

    // reuse P81 graph builder
    ValueGraph<Integer, Integer> graph =
        constructGraph(
            matrix,
            (rowColSize, nodesWithCosts, mutableValueGraph) ->
                (costIgnored, node) -> {
                  if ((node + 1) % rowColSize != 0) { // need modulo since flattened to 1D array
                    // right (not in last col)
                    Pair<Integer, Integer> costNode = nodesWithCosts.get(node + 1);
                    mutableValueGraph.putEdgeValue(node, costNode.getRight(), costNode.getLeft());
                  }
                  if (node + rowColSize < size) {
                    // down (not in last row)
                    Pair<Integer, Integer> costNode = nodesWithCosts.get(node + rowColSize);
                    mutableValueGraph.putEdgeValue(node, costNode.getRight(), costNode.getLeft());
                  }
                  if ((node - rowColSize) > 0) {
                    // up (not in first row)
                    Pair<Integer, Integer> costNode = nodesWithCosts.get(node - rowColSize);
                    mutableValueGraph.putEdgeValue(node, costNode.getRight(), costNode.getLeft());
                  }
                  if (node % rowColSize != 0) {
                    // left (not in first col)
                    Pair<Integer, Integer> costNode = nodesWithCosts.get(node - 1);
                    mutableValueGraph.putEdgeValue(node, costNode.getRight(), costNode.getLeft());
                  }
                });

    // reuse P81 dijkstra
    return matrix[0][0] + shortestPathsDijkstra(graph, 0)[size - 1];
  }
}
