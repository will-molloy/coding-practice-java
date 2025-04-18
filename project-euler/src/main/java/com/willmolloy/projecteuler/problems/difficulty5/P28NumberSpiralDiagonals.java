package com.willmolloy.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=28>https://projecteuler.net/problem=28</a>
 *
 * <p>Runtime: O(n)
 *
 * @see P58SpiralPrimes
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P28NumberSpiralDiagonals {
  int sumDiagonals(int n) {
    Preconditions.checkArgument(n > 0 && n % 2 == 1, "Spiral can only hold odd width x height.");
    return sumDiagonals(n, 0);
  }

  // the spiral always ends at odd squares
  // solve by spiralling inwards
  private int sumDiagonals(int sideLength, int totalSum) {
    if (sideLength == 1) {
      // base case, centre of the spiral is 1
      return 1 + totalSum;
    }
    // add sum of this side lengths 4 diagonals
    // 4 corners = [square, prevCorner - sideLength + 1 (3 times)]
    totalSum +=
        IntStream.iterate(sideLength * sideLength, corner -> corner - sideLength + 1)
            .limit(4)
            .sum();
    return sumDiagonals(sideLength - 2, totalSum);
  }
}
