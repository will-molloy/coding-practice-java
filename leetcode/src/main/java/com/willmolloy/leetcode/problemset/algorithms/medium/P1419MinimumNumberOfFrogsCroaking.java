package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-number-of-frogs-croaking>https://leetcode.com/problems/minimum-number-of-frogs-croaking/</a>
 *
 * <p><a
 * href=https://leetcode.com/contest/weekly-contest-185/problems/minimum-number-of-frogs-croaking>https://leetcode.com/contest/weekly-contest-185/problems/minimum-number-of-frogs-croaking/</a>
 *
 * <p>Difficulty: Medium (5)
 *
 * <p>Time: 0:44:15 (0:16:40 excluding first two problems) (+0:10:00 for 2x wrong answer)
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: State machine.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1419MinimumNumberOfFrogsCroaking {

  public int minNumberOfFrogs(String croakOfFrogs) {
    // maintain count of active croaks
    int cs = 0;
    int rs = 0;
    int os = 0;
    int as = 0;
    int max = -1;

    for (char c : croakOfFrogs.toCharArray()) {
      if (c == 'c') {
        cs += 1;
        // min number of frogs is max number of croaks active at one time
        max = Math.max(max, cs);
      } else if (c == 'r') {
        if (cs == 0) {
          return -1;
        }
        rs += 1;
      } else if (c == 'o') {
        if (cs == 0 || rs == 0) {
          return -1;
        }
        os += 1;
      } else if (c == 'a') {
        if (cs == 0 || rs == 0 || os == 0) {
          return -1;
        }
        as += 1;
      } else if (c == 'k') {
        if (cs == 0 || rs == 0 || os == 0 || as == 0) {
          return -1;
        }
        cs--;
        rs--;
        os--;
        as--;
      }
    }

    return cs == 0 && rs == 0 && os == 0 && as == 0 ? max : -1;
  }
}
