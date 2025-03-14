package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href=https://leetcode.com/problems/gray-code>https://leetcode.com/problems/gray-code</a>
 *
 * <p>Runtime: O(2<sup>n</sup>)
 *
 * <p>Space: O(2<sup>n</sup>)
 *
 * <p>Key idea: recursive construction
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P89GrayCode {

  public List<Integer> grayCode(int n) {
    if (n == 0) {
      return Collections.singletonList(0);
    }
    List<String> asBinary = construct(n, 1, Arrays.asList("0", "1"));
    return asBinary.stream().map(i -> Integer.parseInt(i, 2)).collect(Collectors.toList());
  }

  // https://en.wikipedia.org/wiki/Gray_code#Constructing_an_n-bit_Gray_code
  private List<String> construct(int targetN, int currentN, List<String> oldEntries) {
    if (targetN == currentN) {
      return oldEntries;
    }

    // reflect old entries
    List<String> newEntries = new ArrayList<>(oldEntries);
    Collections.reverse(newEntries);

    // prefix old entries with '0'
    oldEntries = oldEntries.stream().map(b -> "0" + b).collect(Collectors.toList());

    // prefix new entries with '1'
    newEntries = newEntries.stream().map(b -> "1" + b).collect(Collectors.toList());

    // concatenate lists
    oldEntries.addAll(newEntries);

    return construct(targetN, currentN + 1, oldEntries);
  }
}
