package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/hamming-distance>https://leetcode.com/problems/hamming-distance/</a>
 *
 * <p>Runtime: O(1)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Convert to fixed length binary then count differing bits. Xor sum simplifies the
 * differing bits part.
 *
 * @see P190ReverseBits
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P461HammingDistance {

  public static final int MAX_BIT_LEN = 31;

  public int hammingDistance(int x, int y) {
    List<Integer> x2 = toReverseBinary(x);
    List<Integer> y2 = toReverseBinary(y);
    return IntStream.range(0, MAX_BIT_LEN).map(i -> x2.get(i) ^ y2.get(i)).sum();
  }

  private List<Integer> toReverseBinary(int i) {
    List<Integer> list = new ArrayList<>();
    while (i > 0) {
      list.add(i % 2);
      i /= 2;
    }
    while (list.size() < MAX_BIT_LEN) {
      list.add(0);
    }
    return list;
  }
}
