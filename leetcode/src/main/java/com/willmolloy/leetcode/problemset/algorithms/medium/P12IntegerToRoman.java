package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/integer-to-roman>https://leetcode.com/problems/integer-to-roman</a>
 *
 * <p>Runtime: O(n) ? maxLessThan is repeated proportionate to n also, but SYMBOLS is constant size
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P12IntegerToRoman {

  private static final Map<Integer, String> SYMBOLS;

  static {
    Map<Integer, String> m = new HashMap<>();
    m.put(1, "I");
    m.put(5, "V");
    m.put(10, "X");
    m.put(50, "L");
    m.put(100, "C");
    m.put(500, "D");
    m.put(1000, "M");
    // composites
    m.put(4, "IV");
    m.put(9, "IX");
    m.put(40, "XL");
    m.put(90, "XC");
    m.put(400, "CD");
    m.put(900, "CM");
    SYMBOLS = Collections.unmodifiableMap(m);
  }

  public String intToRoman(int num) {
    if (num <= 0) {
      throw new IllegalArgumentException("Negative input");
    }
    // Always take the maximum possible value from the set of symbols
    // (i.e. max <= what is left of num)
    // guaranteed to never be less than zero since it can just take 1
    IntUnaryOperator maxLessThan =
        i ->
            SYMBOLS.keySet().stream()
                .filter(j -> j <= i)
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
    List<Integer> differences = new ArrayList<>();
    while (num != 0) {
      // TODO can do all in a single loop? i.e. put below for loop here, and even the string
      // building
      // but same time complexity...
      differences.add(num);
      num -= maxLessThan.applyAsInt(num);
    }

    // Left with: (num, firstDifference, secondDifference) etc.
    // Obtain int values by subtracting next value (last value subtracts zero (i.e. leave as is))
    // E.g. 58 = (58, 8, 3, 2, 1) -> (50, 5, 1, 1, 1)
    for (int i = 0; i < differences.size() - 1; i++) {
      differences.set(i, differences.get(i) - differences.get(i + 1));
    }
    // Can now map to roman numerals
    // E.g. 58 = (50, 5, 1, 1, 1) -> LVIII
    return differences.stream().map(SYMBOLS::get).collect(Collectors.joining());
  }
}
