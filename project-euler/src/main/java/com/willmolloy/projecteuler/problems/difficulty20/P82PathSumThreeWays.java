package com.willmolloy.projecteuler.problems.difficulty20;

import static com.willmolloy.projecteuler.common.Collections.zipWithIndex;
import static com.willmolloy.projecteuler.problems.difficulty10.P81PathSumTwoWays.constructGraph;
import static com.willmolloy.projecteuler.problems.difficulty10.P81PathSumTwoWays.shortestPathsDijkstra;
import static java.util.Arrays.stream;

import com.google.common.graph.ValueGraph;
import com.willmolloy.projecteuler.common.Tuples;
import com.willmolloy.projecteuler.problems.difficulty10.P81PathSumTwoWays;
import com.willmolloy.projecteuler.problems.difficulty25.P83PathSumFourWays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;

/**
 * <a href=https://projecteuler.net/problem=82>https://projecteuler.net/problem=82</a>
 *
 * <p>Runtime: TODO
 *
 * @see P81PathSumTwoWays
 * @see P82PathSumThreeWays
 * @see P83PathSumFourWays
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public final class P82PathSumThreeWays {

  private P82PathSumThreeWays() {}

  static int shortestPath(int[][] matrix) {
    // given matrix where num rows = num cols
    int rowColSize = matrix[0].length;
    int size = rowColSize * rowColSize;

    // reuse P81 graph builder
    ValueGraph<Integer, Integer> graph =
        constructGraph(
            matrix,
            (ignored, nodesWithCosts, mutableValueGraph) ->
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
                });

    // flatten the matrix so each node can be labelled [0..size)
    List<Integer> flatMatrix = stream(matrix).flatMap(row -> stream(row).boxed()).toList();

    // bit different, source can be any node in the left and sink is any node in the right
    // so do dijkstra from all nodes on the left side (TODO maybe a better way??)
    IntStream leftNodes = IntStream.range(0, size).filter(i -> i % rowColSize == 0);
    return leftNodes
        .map(
            leftNode -> {
              // reuse P81 dijkstra
              Stream<Integer> shortestPaths =
                  stream(shortestPathsDijkstra(graph, leftNode)).boxed();
              Stream<Integer> shortestPathsToRightNodes =
                  zipWithIndex(shortestPaths)
                      .filter(Tuples.predicate((costIgnored, node) -> (node + 1) % rowColSize == 0))
                      .map(Pair::getLeft);
              // pick shortest path to any right node
              return flatMatrix.get(leftNode)
                  + shortestPathsToRightNodes
                      .mapToInt(Integer::intValue)
                      .min()
                      .orElse(Integer.MAX_VALUE);
            })
        .min()
        .orElse(Integer.MAX_VALUE); // pick shortest path from any left node to any right node
  }
}
