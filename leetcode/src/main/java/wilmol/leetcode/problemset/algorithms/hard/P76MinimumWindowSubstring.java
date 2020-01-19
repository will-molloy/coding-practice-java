package wilmol.leetcode.problemset.algorithms.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wilmol on 2020-01-19.
 *
 * <p><a
 * href=https://leetcode.com/problems/minimum-window-substring>https://leetcode.com/problems/minimum-window-substring</a>
 *
 * <p>Runtime: O(t + s)
 *
 * <p>Space: O(t)
 *
 * <p>Key: Hash map to maintain count of characters. Two pointers to 'widen' and 'narrow' window.
 */
class P76MinimumWindowSubstring {

  public String minWindow(String s, String t) {

    // count of chars needed to cover 't'
    Map<Character, Integer> counts = new HashMap<>();
    char[] chars = t.toCharArray();
    for (char c : chars) {
      counts.put(c, counts.getOrDefault(c, 0) + 1);
    }

    int l = 0;
    int r = 0;
    int bestL = 0;
    int bestR = Integer.MAX_VALUE;

    while (r <= s.length() && l <= r) {

      // TODO isCovered can be more efficient
      //  e.g. keep track of count 'tCharsCovered' then check if 'tCharsCovered' == t.size()
      if (isCovered(counts)) {

        // update best
        if (r - l < bestR - bestL) {
          bestR = r;
          bestL = l;
        }

        // narrow, move l in
        char c = s.charAt(l);
        if (counts.containsKey(c)) {
          counts.put(c, counts.get(c) + 1);
        }
        l++;

      } else if (r < s.length()) {

        // widen, move r out
        char c = s.charAt(r);
        if (counts.containsKey(c)) {
          counts.put(c, counts.get(c) - 1);
        }
        r++;
      } else {
        // needed for final character where:
        // can't move r out because IOOB
        // and can't move l in because 't' not covered
        break;
      }
    }

    return bestR == Integer.MAX_VALUE ? "" : s.substring(bestL, bestR);
  }

  private boolean isCovered(Map<Character, Integer> counts) {
    return counts.values().stream().allMatch(i -> i <= 0);
  }
}
