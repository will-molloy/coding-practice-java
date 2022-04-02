package com.willmolloy.projecteuler.problems.difficulty5;

import com.willmolloy.projecteuler.common.Maths;
import java.math.BigInteger;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;

/**
 * <a href=https://projecteuler.net/problem=57>https://projecteuler.net/problem=57</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P57SquareRootConvergents {

  private P57SquareRootConvergents() {}

  static int solve(int limit) {
    // formula: 1 + (NEXT = 1/(2 + (PREVIOUS)))
    // where initially PREVIOUS is: 1/2

    // use pair to track the fraction (will need denominator/numerator separately)
    // ??? never need to reduce the fraction because root 2 is irrational ???
    return (int)
        Stream.iterate(
                Pair.of(BigInteger.valueOf(1), BigInteger.valueOf(2)),
                previous -> {
                  BigInteger d = previous.getRight();
                  // add 2; fractions: adding '1' is adding denominator to numerator
                  BigInteger n = previous.getLeft().add(d).add(d);
                  // take inverse (i.e. 1/...)
                  return Pair.of(d, n);
                })
            // ??? need separate map operation for 1 + ... (otherwise include extra 1 in inverse
            // part of the sum) ???
            .map(
                next -> {
                  BigInteger d = next.getRight();
                  // add 1
                  BigInteger n = next.getLeft().add(d);
                  return Pair.of(n, d);
                })
            .limit(limit)
            .filter(
                fraction -> {
                  BigInteger n = fraction.getLeft();
                  BigInteger d = fraction.getRight();
                  return Maths.digitLength(n) > Maths.digitLength(d);
                })
            .count();
  }
}
