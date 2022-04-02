package com.willmolloy.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import com.willmolloy.projecteuler.common.Maths;
import java.util.stream.LongStream;

/**
 * <a href=https://projecteuler.net/problem=45>https://projecteuler.net/problem=45</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P45TriangularPentagonalHexagonalNumber {

  private P45TriangularPentagonalHexagonalNumber() {}

  static long nTriangularPentagonalHexagonalNumber(long n) {
    Preconditions.checkArgument(n >= 1);

    return LongStream.iterate(1, i -> i + 1)
        // more efficient to only test triangle numbers
        .map(P45TriangularPentagonalHexagonalNumber::triangleNumber)
        .filter(
            triangleNumber ->
                isPentagonalNumber(triangleNumber) && isHexagonalNumber(triangleNumber))
        // take last element of stream
        .limit(n)
        .skip(n - 1)
        .iterator()
        .next();
  }

  private static long triangleNumber(long n) {
    return (n * (n + 1)) / 2;
  }

  private static boolean isPentagonalNumber(long pn) {
    // quadratic formula used
    double inversePentagon = (1 + Math.sqrt(1 + 24 * pn)) / 6;
    return inversePentagon > 0 && Maths.isInteger(inversePentagon);
  }

  private static boolean isHexagonalNumber(long hn) {
    // quadratic formula used
    double inverseHexagon = (1 + Math.sqrt(1 + 8 * hn)) / 4;
    return inverseHexagon > 0 && Maths.isInteger(inverseHexagon);
  }
}
