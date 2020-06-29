package com.wilmol.projecteuler.problems.difficulty5;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import java.math.BigInteger;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import org.apache.commons.lang3.tuple.Pair;

/**
 * <a href=https://projecteuler.net/problem=33>https://projecteuler.net/problem=33</a>
 *
 * <p>Runtime: doesn't scale, no input
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class P33DigitCancellingFractions {

  private P33DigitCancellingFractions() {}

  static int solve() {
    // generate the fractions (two digits in numerator and denominator and < 1 in value)
    Supplier<IntStream> nonTrivialRange =
        () ->
            IntStream.rangeClosed(10, 99)
                // filter cases where both digits are the same (cancelling a digit would result in
                // 'nothing')
                .filter(n -> n % 11 != 0)
                // filter trivial cases (divisible by 10)
                .filter(n -> n % 10 != 0);

    // using Pair<Numerator, Denominator> to represent fractions
    List<Pair<Integer, Integer>> fractions =
        nonTrivialRange
            .get()
            .boxed()
            .flatMap(
                numerator ->
                    nonTrivialRange
                        .get()
                        // ensure < 1
                        .filter(denominator -> numerator < denominator)
                        .mapToObj(denominator -> Pair.of(numerator, denominator)))
            .collect(ImmutableList.toImmutableList());

    // find the 4 digit cancelling fractions
    List<Pair<Integer, Integer>> digitCancellingFractions =
        fractions.stream()
            .filter(P33DigitCancellingFractions::isDigitCancelling)
            .collect(ImmutableList.toImmutableList());
    assert digitCancellingFractions.size() == 4;

    // find denominator of the reduced product
    return denominatorOfReducedFractionProduct(digitCancellingFractions);
  }

  private static boolean isDigitCancelling(Pair<Integer, Integer> fraction) {
    double actualFractionValue = (double) fraction.getLeft() / fraction.getRight();
    String numerator = fraction.getLeft().toString();
    String denominator = fraction.getRight().toString();

    return IntStream.rangeClosed(1, 9)
        .mapToObj(Integer::toString)
        // only loop digits which both strings contain
        .filter(digit -> numerator.contains(digit) && denominator.contains(digit))
        // test if any digit cancellation also results in the same fraction value
        .anyMatch(
            digit -> {
              String numeratorWithoutDigit = numerator.replaceAll(digit, "");
              String denominatorWithoutDigit = denominator.replaceAll(digit, "");
              double candidateFractionValue =
                  Double.parseDouble(numeratorWithoutDigit)
                      / Integer.parseInt(denominatorWithoutDigit);
              return Range.closed(actualFractionValue - 0.0000001d, actualFractionValue + 0.0000001)
                  .contains(candidateFractionValue);
            });
  }

  private static int denominatorOfReducedFractionProduct(List<Pair<Integer, Integer>> fractions) {
    // product
    Pair<Integer, Integer> product =
        fractions.stream()
            .reduce(
                Pair.of(1, 1),
                (a, b) -> Pair.of(a.getLeft() * b.getLeft(), a.getRight() * b.getRight()));

    // reduce denominator by dividing by gcd
    int numerator = product.getLeft();
    int denominator = product.getRight();
    int gcd = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denominator)).intValue();
    assert denominator % gcd == 0;

    return denominator / gcd;
  }
}
