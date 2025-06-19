package com.willmolloy.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import com.willmolloy.projecteuler.common.Collections;
import com.willmolloy.projecteuler.common.Maths;
import java.util.List;

/**
 * <a href=https://projecteuler.net/problem=11>https://projecteuler.net/problem=11</a>
 *
 * <p>Runtime: ??? O(n * m * k) ? but larger k means less sliding windows.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P11LargestProductInAGrid {

  public long apply(List<List<Long>> grid, int numAdjacent) {
    Preconditions.checkNotNull(grid);
    Preconditions.checkArgument(
        numAdjacent >= 0
            && numAdjacent <= grid.size()
            && (grid.isEmpty()
                || grid.stream().allMatch(list -> grid.getFirst().size() == list.size())));

    return allDirections(grid, numAdjacent);
  }

  private long allDirections(List<List<Long>> grid, int numAdjacent) {
    return Long.max(
        Long.max(leftOrRight(grid, numAdjacent), upOrDown(grid, numAdjacent)),
        diagonal(grid, numAdjacent));
  }

  private long leftOrRight(List<List<Long>> grid, int numAdjacent) {
    return grid.stream()
        .mapToLong(
            row ->
                Collections.sliding(row, numAdjacent).stream()
                    .mapToLong(Maths::product)
                    .max()
                    .orElse(0))
        .max()
        .orElse(0);
  }

  private long upOrDown(List<List<Long>> grid, int numAdjacent) {
    return leftOrRight(Collections.transpose(grid), numAdjacent);
  }

  private long diagonal(List<List<Long>> grid, int numAdjacent) {
    return Math.max(upSlopes(grid, numAdjacent), downSlopes(grid, numAdjacent));
  }

  private long upSlopes(List<List<Long>> grid, int numAdjacent) {
    List<List<Long>> upSlopes =
        Collections.diagonalForwardSlopes(grid).stream()
            .filter(list -> list.size() >= numAdjacent)
            .toList();

    return leftOrRight(upSlopes, numAdjacent);
  }

  private long downSlopes(List<List<Long>> grid, int numAdjacent) {
    List<List<Long>> downSlopes =
        Collections.diagonalBackwardSlopes(grid).stream()
            .filter(list -> list.size() >= numAdjacent)
            .toList();

    return leftOrRight(downSlopes, numAdjacent);
  }
}
