package com.willmolloy.hackerrank.interviewpreparationkit.warmup.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup>https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup</a>
 *
 * <p>Return the total number of matching pairs of socks that John can sell.
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class SockMerchant {

  private SockMerchant() {}

  static int sockMerchant(int[] ar) {
    // ar represent the sock colours
    // count the colours
    Map<Integer, Integer> sockColourCounts = new HashMap<>();
    for (int i : ar) {
      sockColourCounts.merge(i, 1, Integer::sum);
    }
    // sum the number of pairs per colour
    return sockColourCounts.values().stream()
        .mapToInt(sockColourCount -> sockColourCount / 2)
        .sum();
  }
}
