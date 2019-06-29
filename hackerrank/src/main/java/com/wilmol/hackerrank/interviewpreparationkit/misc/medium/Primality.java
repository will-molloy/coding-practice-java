package com.wilmol.hackerrank.interviewpreparationkit.misc.medium;

import java.util.stream.IntStream;

/**
 * Created by Will on 2019-03-30 at 16:18
 *
 * <p>https://www.hackerrank.com/interview/interview-preparation-kit/miscellaneous/challenges
 *
 * <p>Runtime: O(sqrt(n))
 */
class Primality {

  static boolean primality(int n) {
    return n > 1
        && (n == 2 || IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(k -> n % k == 0));
  }
}
