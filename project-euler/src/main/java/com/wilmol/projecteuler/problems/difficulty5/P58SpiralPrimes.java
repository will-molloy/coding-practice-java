package com.wilmol.projecteuler.problems.difficulty5;

import com.google.common.math.LongMath;
import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=58>https://projecteuler.net/problem=58</a>
 *
 * <p>Runtime: unknown ... cannot predict % of primes versus side length, iterations are O(1)
 * however
 *
 * @see P28NumberSpiralDiagonals
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class P58SpiralPrimes {

  private P58SpiralPrimes() {}

  // java is trash and doesn't support tail recursion, hence need loop
  static int solve() {
    // only interested in the diagonals... figured this out in P28...
    // except this time we increase the side length (spiral outwards)

    final int[] primeCount = {0};
    // start from 3 (1 has 0% primes...)
    return IntStream.iterate(3, sideLength -> sideLength + 2)
        .filter(
            sideLength -> {
              // check primality of the 4 diagonals
              // 4 corners = [square, prevCorner - sideLength + 1 (3 times)]
              primeCount[0] +=
                  IntStream.iterate(sideLength * sideLength, corner -> corner - sideLength + 1)
                      .limit(4)
                      .filter(LongMath::isPrime)
                      .count();
              int diagonalLength = sideLength * 2 - 1;
              return diagonalLength > 10 * primeCount[0];
            })
        .findFirst()
        .getAsInt();
  }
}
