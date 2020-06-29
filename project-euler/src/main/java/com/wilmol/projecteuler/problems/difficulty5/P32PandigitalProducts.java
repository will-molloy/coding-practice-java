package com.wilmol.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import com.wilmol.projecteuler.common.Strings;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=32>https://projecteuler.net/problem=32</a>
 *
 * <p>Runtime: O(n! * n * n)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class P32PandigitalProducts {

  private P32PandigitalProducts() {}

  // just brute force... 9! is < 1_000_000
  static int pandigitalProductsSum(int bound) {
    Preconditions.checkArgument(
        bound >= 3, "Require at least 3 digits to create prefix, middle, and suffix substrings.");
    Preconditions.checkArgument(bound <= 9, "No more than 9 decimal digits exist.");

    // Use string for easy slicing, could use list<int> with 'glue' operator
    String digits =
        IntStream.rangeClosed(1, bound).mapToObj(Integer::toString).collect(Collectors.joining());

    return Strings.permutations(digits).stream()
        // produce set of valid products for each permutation of the digits
        .flatMap(digitsPermutation -> pandigitalProducts(digitsPermutation).stream())
        // only include a product once
        .distinct()
        .reduce(0, Integer::sum);
  }

  private static List<Integer> pandigitalProducts(String digits) {
    List<Integer> results = new ArrayList<>();

    // try each combination of multiplicand, multiplier, and product
    // for each: min size = 1, max size = digits.length - 2
    for (int i = 1; i <= digits.length() - 2; i++) {
      for (int j = 1; j < digits.length() - i; j++) {
        // multiplicand = prefix
        // multiplier = middle
        // product = suffix
        int multiplicand = Integer.parseInt(digits.substring(0, i));
        int multiplier = Integer.parseInt(digits.substring(i, j + i));
        int candidateProduct = Integer.parseInt(digits.substring(j + i));

        int actualProduct = multiplicand * multiplier;

        if (candidateProduct == actualProduct) {
          results.add(actualProduct);
        }
      }
    }
    return results;
  }
}
