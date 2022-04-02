package com.willmolloy.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import com.willmolloy.projecteuler.problems.difficulty15.P51PrimeDigitReplacements;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=52>https://projecteuler.net/problem=52</a>
 *
 * <p>Runtime: none - search is linear but can't predict when 'multiple family' of size will be
 * found
 *
 * @see P51PrimeDigitReplacements
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public final class P52PermutedMultiples {

  private P52PermutedMultiples() {}

  static int smallestMultipleOfNSizedMultipleFamilyWithSameDigits(int multipleFamilySize) {
    Preconditions.checkArgument(multipleFamilySize > 1 && multipleFamilySize <= 6);

    return IntStream.iterate(1, x -> x + 1)
        .filter(
            x -> {
              int[] xDigits = getDigits(x);
              return IntStream.rangeClosed(2, multipleFamilySize)
                  .allMatch(multiple -> Arrays.equals(xDigits, getDigits(x * multiple)));
            })
        .findFirst()
        .orElseThrow();
  }

  private static int[] getDigits(int n) {
    // sort so digit counts are comparable
    return String.valueOf(n).chars().sorted().toArray();
  }
}
