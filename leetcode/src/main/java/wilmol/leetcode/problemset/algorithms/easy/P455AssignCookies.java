package wilmol.leetcode.problemset.algorithms.easy;

import java.util.Arrays;

/**
 * Created by wilmol on 2020-05-04.
 *
 * <p><a
 * href=https://leetcode.com/problems/assign-cookies>https://leetcode.com/problems/assign-cookies/</a>
 *
 * <p>Runtime: O(n log(n))
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Sort the inputs so greedy approach can be used.
 */
class P455AssignCookies {

  public int findContentChildren(int[] kids, int[] cookies) {
    Arrays.sort(kids);
    Arrays.sort(cookies);

    // greedy algorithm
    // kids and cookies are sorted by greedy factor and size respectively
    // so can choose first cookie that satisfies next kid because all previous cookies wouldn't
    // satisfy future kids anyway
    int count = 0;
    int k = 0;
    int c = 0;
    while (c < cookies.length && k < kids.length) {
      if (cookies[c] >= kids[k]) {
        count++;
        // kid satisfied
        k++;
      }
      // search for cookie that satisfies next kid
      c++;
    }
    return count;
  }
}
