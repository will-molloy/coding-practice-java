package wilmol.leetcode.problemset.algorithms.hard;

/**
 * Created by Will on 2019-07-15 at 19:41.
 *
 * <p><a
 * href=https://leetcode.com/problems/regular-expression-matching>https://leetcode.com/problems/regular-expression-matching</a>
 *
 * <p>Runtime: TODO O()
 */
class P10RegularExpressionMatching {

  public boolean isMatch(String s, String p) {
    return s != null && p != null && s.matches(p);
  }
}
