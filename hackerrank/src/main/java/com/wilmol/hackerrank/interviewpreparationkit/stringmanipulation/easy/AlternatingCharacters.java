package com.wilmol.hackerrank.interviewpreparationkit.stringmanipulation.easy;

import com.google.common.base.Strings;

/**
 * Created by Will on 30/03/2019.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings>https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings</a>
 *
 * <p>Return number of deletions such that the string has no matching adjacent characters.
 *
 * <p>Runtime: O(n)
 */
final class AlternatingCharacters {

  private AlternatingCharacters() {}

  static int alternatingCharacters(String s) {
    if (Strings.isNullOrEmpty(s)) {
      return 0;
    }
    int count = 0;
    char current = s.charAt(0);
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == current) {
        count += 1;
      }
      current = s.charAt(i);
    }
    return count;
  }
}
