package com.wilmol.projecteuler.problems.difficulty5;

import static com.wilmol.projecteuler.common.Strings.reverse;

import com.wilmol.projecteuler.common.Strings;
import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <a href=https://projecteuler.net/problem=55>https://projecteuler.net/problem=55</a>
 *
 * <p>Runtime: O(n) - iterate all numbers, check caps out at 50 iterations
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class P55LychrelNumbers {

  private P55LychrelNumbers() {}

  // should cache results, i.e. the sums below 10,000 are recomputed, but runs in 100ms anyway
  static int countLychrelNumbersBelow(int below) {
    // use BigInteger since the sums overflow even long values
    return (int)
        IntStream.range(1, below)
            .filter(
                n ->
                    Stream.iterate(
                            String.valueOf(n),
                            forward ->
                                (new BigInteger(forward).add(new BigInteger(reverse(forward))))
                                    .toString())
                        // skip n itself (e.g. 4994 is palindrome and lychrel)
                        .skip(1)
                        // simply test none of the first 50 'reverse and add sums' are palindromic
                        .limit(51)
                        .noneMatch(Strings::isPalindrome))
            .count();
  }
}
