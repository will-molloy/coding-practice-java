package com.wilmol.hackerrank.interviewpreparationkit.warmup.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Will on 24/03/2019
 *
 * <p>Return the total number of matching pairs of socks that John can sell.
 *
 * <p>Runtime: O(n)
 */
class SockMerchant {

  static int sockMerchant(int[] ar) {
    // ar represent the sock colours
    // count the colours
    Map<Integer, Integer> sockColourCounts = new HashMap<>();
    for (int i : ar) {
      sockColourCounts.put(i, sockColourCounts.getOrDefault(i, 0) + 1);
    }
    // sum the number of pairs per colour
    return sockColourCounts.values().stream()
        .mapToInt(sockColourCount -> sockColourCount / 2)
        .sum();
  }
}
