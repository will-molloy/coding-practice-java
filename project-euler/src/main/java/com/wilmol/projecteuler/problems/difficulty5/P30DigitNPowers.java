package com.wilmol.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.wilmol.projecteuler.common.Maths;
import com.wilmol.projecteuler.common.Strings;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Created by Will on 23/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=30>https://projecteuler.net/problem=30</a>
 *
 * <p>Runtime: O(n ^ 9) ??? potentially, but many short circuits
 *
 * @see P34DigitFactorials
 */
class P30DigitNPowers {

  private static final List<String> DIGITS_SEQUENCE =
      IntStream.rangeClosed(0, 9)
          .mapToObj(String::valueOf)
          .collect(ImmutableList.toImmutableList());

  long apply(final int exp) {
    Preconditions.checkArgument(exp <= 9 && exp >= 0);
    long maxSumPerDigit = (long) Math.pow(9, exp);
    return digitPowers(exp, maxSumPerDigit, 2, 0, DIGITS_SEQUENCE);
  }

  private long digitPowers(
      final int exp,
      long maxSumPerDigit,
      int numDigits,
      long totalSum,
      List<String> digitsSequence) {
    if (numDigits > Maths.digitLength(maxSumPerDigit * numDigits)) {
      // base case, clearly there is an upper limit
      // the sum of powers out grows the number of digits available
      return totalSum;
    }
    // Generator: i = [0 .. 9], j = [i .. 9], k = [j .. 9], l = [k .. 9] ... etc.
    // I.e. recursively generate nested loops (numDigits deep)
    List<String> nextSequence =
        digitsSequence.stream()
            .flatMap(
                a ->
                    IntStream.rangeClosed(Character.getNumericValue(a.charAt(a.length() - 1)), 9)
                        .mapToObj(n -> a + n))
            .collect(ImmutableList.toImmutableList());

    long validSumsSum =
        nextSequence.stream()
            // Addition is associative/commutative; f(9664) = f(4669) = f(4696) etc.
            // I.e. only need to check once per permutation
            .map(s -> sumOfDigitPowersThatMatchAPermutation(s, exp))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .mapToLong(Long::valueOf)
            .sum();
    return digitPowers(exp, maxSumPerDigit, numDigits + 1, totalSum + validSumsSum, nextSequence);
  }

  private Optional<String> sumOfDigitPowersThatMatchAPermutation(String s, int exp) {
    // Reverse to put largest digits first (allows an upper limit to be applied to the summing
    // procedure)
    s = Strings.reverse(s);
    long limit = Long.parseLong(s);

    List<Integer> digits =
        s.chars().mapToObj(Character::getNumericValue).collect(ImmutableList.toImmutableList());

    long digitPowerSum = 0;
    for (Integer digit : digits) {
      digitPowerSum += Math.pow(digit, exp);
      if (digitPowerSum > limit) {
        return Optional.empty();
      }
    }

    String sumAsString = String.valueOf(digitPowerSum);
    return Strings.permutations(s).stream()
        .filter(string -> string.equals(sumAsString))
        .findFirst();
  }
}
