package com.willmolloy.projecteuler.problems.difficulty10;

import static com.willmolloy.projecteuler.common.Collections.zipWithIndex;
import static java.lang.Math.min;
import static java.util.Arrays.stream;
import static java.util.Comparator.comparingInt;

import com.google.common.graph.ImmutableValueGraph;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraph;
import com.google.common.graph.ValueGraphBuilder;
import com.willmolloy.projecteuler.common.Tuples;
import com.willmolloy.projecteuler.problems.difficulty20.P82PathSumThreeWays;
import com.willmolloy.projecteuler.problems.difficulty25.P83PathSumFourWays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;

/**
 * <a href=https://projecteuler.net/problem=81>https://projecteuler.net/problem=81</a>
 *
 * <p>Runtime: TODO
 *
 * @see P81PathSumTwoWays
 * @see P82PathSumThreeWays
 * @see P83PathSumFourWays
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public final class P81PathSumTwoWays {

  private P81PathSumTwoWays() {}

  /**
   * Supplies a {@link BiConsumer} which will construct the edges of the graph.
   *
   * <p>E.g. via. {@link MutableValueGraph#putEdgeValue(Object, Object, Object)}.
   */
  @FunctionalInterface
  public interface EdgeConstructorSupplier {
    BiConsumer<Integer, Integer> getEdgeConstructor(
        int rowColSize,
        List<Pair<Integer, Integer>> nodes,
        MutableValueGraph<Integer, Integer> graph);
  }

  /**
   * Common method between {@link P81PathSumTwoWays}, {@link P82PathSumThreeWays}, {@link
   * P83PathSumFourWays}.
   *
   * @param matrix 2d array (i.e. {@code matrix}) representation of the graph
   * @param edgeConstructorSupplier {@link EdgeConstructorSupplier}
   * @return {@link ImmutableValueGraph} representation of the graph
   */
  public static ImmutableValueGraph<Integer, Integer> constructGraph(
      int[][] matrix, EdgeConstructorSupplier edgeConstructorSupplier) {
    // given matrix where num rows = num cols
    int rowColSize = matrix[0].length;

    // flatten the matrix so each node can be labelled [0..size)
    Stream<Integer> flatMatrix = stream(matrix).flatMap(row -> stream(row).boxed());

    // label the nodes 1..size with their cost (i.e. pairs of [cost, index])
    List<Pair<Integer, Integer>> nodesWithCosts = zipWithIndex(flatMatrix).toList();

    // build the weighted directed graph
    MutableValueGraph<Integer, Integer> graph =
        ValueGraphBuilder.directed().allowsSelfLoops(false).build();
    nodesWithCosts.forEach(
        Tuples.consumer(
            edgeConstructorSupplier.getEdgeConstructor(rowColSize, nodesWithCosts, graph)));

    return ImmutableValueGraph.copyOf(graph);
  }

  /**
   * Common method between {@link P81PathSumTwoWays}, {@link P82PathSumThreeWays}, {@link
   * P83PathSumFourWays}.
   *
   * @param graph {@link ValueGraph} representation of the graph
   * @param source source node
   * @return costs from source node to every other node (will be {@link Integer#MAX_VALUE} if no
   *     path between nodes)
   */
  public static int[] shortestPathsDijkstra(ValueGraph<Integer, Integer> graph, int source) {
    // set costs to max, want to determine minimums
    int[] costs = new int[graph.nodes().size()];
    for (int i = 0; i < costs.length; i++) {
      costs[i] = Integer.MAX_VALUE;
    }
    costs[source] = 0;

    // going to iterate all nodes
    Set<Integer> vertices = new HashSet<>(graph.nodes());

    while (!vertices.isEmpty()) {
      // get next node based on minimum cost so far (greedy)
      int node = vertices.stream().min(comparingInt(i -> costs[i])).get();
      vertices.remove(node);
      // iterate each neighbour
      graph
          .successors(node)
          .forEach(
              neighbour -> {
                // update cost for neighbour if possible
                int currentCost = costs[neighbour];
                int altCost = costs[node] + graph.edgeValue(node, neighbour).get();
                costs[neighbour] = min(currentCost, altCost);
              });
    }
    return costs;
  }

  static int shortestPath(int[][] matrix) {
    // given matrix where num rows = num cols
    int size = matrix[0].length * matrix[0].length;

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
                });

    return matrix[0][0] + shortestPathsDijkstra(graph, 0)[size - 1];
  }
}
