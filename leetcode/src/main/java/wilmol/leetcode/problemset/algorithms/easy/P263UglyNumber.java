package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-04-09.
 *
 * <p><a
 * href=https://leetcode.com/problems/ugly-number>https://leetcode.com/problems/ugly-number</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: prime factorisation: while divisible by factor {@code i}, repeatedly divide by it before
 * moving onto next ({@code i = [2..n]})
 *
 * @see wilmol.leetcode.problemset.algorithms.medium.P264UglyNumber2
 */
class P263UglyNumber {

  public boolean isUgly(int num) {
    if (num == 0) {
      return false;
    }
    int[] factors = {2, 3, 5};
    for (int factor : factors) {
      while (num % factor == 0) {
        num /= factor;
      }
    }
    // if num was not reduced to 1 by the prime factors [2, 3, 5] then it has other prime factors
    return num == 1;
  }
}
