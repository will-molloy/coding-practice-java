package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-04-10.
 *
 * <p><a
 * href=https://leetcode.com/problems/backspace-string-compare>https://leetcode.com/problems/backspace-string-compare</a>
 *
 * <p>Runtime: O(s + t)
 *
 * <p>Space: O(1)
 *
 * <p>Key: once finished backspacing, need to check string again cause may have ended up on another
 * backspace character. Also must not backspace over backspace characters, rather increment the
 * count of them.
 */
class P844BackspaceStringCompare {

  public boolean backspaceCompare(String s, String t) {
    // compare in reverse so can skip 'backspaced' characters

    int sI = s.length() - 1;
    int tI = t.length() - 1;

    while (sI >= 0 || tI >= 0) {
      // backspace s
      sI = backSpace(s, sI);
      // backspace t
      tI = backSpace(t, tI);

      // check current (non backspaced) char is equal
      if (sI >= 0 && tI >= 0 && s.charAt(sI) != t.charAt(tI)) {
        return false;
      }
      // also check if one string was reduced to empty string and other wasn't
      if (sI >= 0 != tI >= 0) {
        return false;
      }

      sI -= 1;
      tI -= 1;
    }
    return true;
  }

  private int backSpace(String s, int i) {
    int skip = 0;
    while (i >= 0) {
      if (s.charAt(i) == '#') {
        // backspace character, increment counter
        skip += 1;
        i -= 1;
      } else if (skip > 0) {
        // not a backspace character, but we have accumulated backspace characters, skip over it
        // and decrement counter
        skip -= 1;
        i -= 1;
      } else {
        // no more backspace characters, stop skipping
        break;
      }
    }
    return i;
  }
}
