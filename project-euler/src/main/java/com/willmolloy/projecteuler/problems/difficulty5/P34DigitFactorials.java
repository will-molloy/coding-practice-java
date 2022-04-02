package com.willmolloy.projecteuler.problems.difficulty5;

import com.google.common.collect.ImmutableList;
import com.google.common.math.LongMath;
import com.willmolloy.projecteuler.common.Maths;
import com.willmolloy.projecteuler.common.Strings;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * <a href=https://projecteuler.net/problem=34>https://projecteuler.net/problem=34</a>
 *
 * <p>Runtime: no input, no scaling
 *
 * @see P30DigitNPowers
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P34DigitFactorials {

  private P34DigitFactorials() {}

  private static final long MAX_ONE_DIGIT = LongMath.factorial(9);

  /**
   * naive solution.
   *
   * <p>iterate from 2 -> max number of digits then iterate min value for num_digits to max value
   * for num_digits (e.g. num_digits = 3; 100 -> 999) then check each number equals factorial sum,
   * and sum those which do
   */
  static long testAllDigitFactorialsUpToLimitAndSum() {
    return IntStream.iterate(2, numDigits -> numDigits + 1)
        .takeWhile(
            numDigits -> {
              // limit reached when num digits of n outgrows num digits of max digit factorial sum
              // i.e. digitLength(n) > digitLength(digitLength(n) * 9!)
              // e.g. 8 * 9! = 2,903,040 (7 digits) -> n will always be larger than the largest
              // digit factorial sum
              int maxFactorialLength = Maths.digitLength(numDigits * MAX_ONE_DIGIT);
              return !(numDigits > maxFactorialLength);
            })
        .mapToLong(
            numDigits -> {
              long start = LongMath.pow(10L, numDigits);
              long end = LongMath.pow(10L, numDigits + 1) - 1;
              return LongStream.rangeClosed(start, end)
                  // parallel works well since testing and summing is disjoint here
                  // (13s -> 2s speedup on amd r7 2700x)
                  // cannot run outer loop in parallel due to takeWhile() (could if hardcode max
                  // digits)
                  .parallel()
                  .filter(n -> n == factorialSum(n))
                  .sum();
            })
        .sum();
  }

  private static long factorialSum(long n) {
    return String.valueOf(n)
        .chars()
        .map(Character::getNumericValue)
        .mapToLong(LongMath::factorial)
        .sum();
  }

  /**
   * better solution.
   *
   * <p>since addition is associative/commutative; f(9664) = f(4669) = f(4696) etc. therefore, still
   * loop all the values (10 -> max) but only compute digit factorial sum for unique combinations of
   * digits
   *
   * @see P30DigitNPowers for similar idea of generating 'infinite' nested loops via. recursion
   */
  static long testDigitFactorialPermutationsUpToLimitAndSum() {
    return digitFactorials(
        2,
        0,
        IntStream.rangeClosed(0, 9)
            .mapToObj(String::valueOf)
            .collect(ImmutableList.toImmutableList()));
  }

  private static long digitFactorials(int numDigits, long sum, List<String> digitsSequence) {
    // same limit check as in naive solution (stop when num digits outgrows max digit factorial sum)
    int maxFactorialLength = Maths.digitLength(numDigits * MAX_ONE_DIGIT);
    if (numDigits > maxFactorialLength) {
      return sum;
    }

    // Generator: i = [0 .. 9], j = [i .. 9], k = [j .. 9], l = [k .. 9] ... etc.
    // I.e. recursively generate nested loops (numDigits deep)

    // generate the next sequence of ints by 'gluing' [int.last..9] with each of the current ints
    // this will avoid duplicate combinations of digits (e.g. will have '16' but NOT '61')
    // e.g. the sequence will look like: [0 .. 9] [11 .. 19] [22 .. 29] .. [77 .. 79] 88 89 99 (when
    // numDigits = 2)
    List<String> nextIntSequence =
        digitsSequence.parallelStream()
            .flatMap(
                a ->
                    IntStream.rangeClosed(Character.getNumericValue(a.charAt(a.length() - 1)), 9)
                        .mapToObj(b -> a + b))
            .collect(ImmutableList.toImmutableList());

    long validIntsSummed =
        nextIntSequence.parallelStream()
            // reverse to put largest digits first (i.e. the maximum permutation value)
            // allows early exit when computing the digit factorial sum
            // as we know when the sum exceeds the maximum permutation of n
            .map(s -> sumOfDigitFactorialsThatMatchAPermutation(Strings.reverse(s)))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .mapToLong(Long::valueOf)
            .sum();
    return digitFactorials(numDigits + 1, sum + validIntsSummed, nextIntSequence);
  }

  private static Optional<String> sumOfDigitFactorialsThatMatchAPermutation(String n) {
    List<Integer> digits =
        n.chars().mapToObj(Character::getNumericValue).collect(ImmutableList.toImmutableList());
    long sum = 0L;
    long limit = Long.parseLong(n);
    for (int i : digits) {
      sum += LongMath.factorial(i);
      if (sum > limit) {
        // early exit
        return Optional.empty();
      }
    }
    // if it exists, find the permutation of 'n' which matches the digit factorial sum
    String sumAsString = String.valueOf(sum);
    return Strings.permutations(
            n) // TODO faster permutations implementation, in scala this runs in 2s!
        .stream()
        .filter(sumAsString::equals)
        .findFirst();
  }
}
