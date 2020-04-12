package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-04-12.
 *
 * <p><a href=https://leetcode.com/problems/add-digits>https://leetcode.com/problems/add-digits</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: converting number into its digits (use {@link Character#digit(char, int)})
 */
class P258AddDigits {
  // TODO followup asks for O(1) runtime - probably some math trick

  public int addDigits(int num) {
    int sum = num;
    while (num > 9) {
      sum = 0;
      for (char c : String.valueOf(num).toCharArray()) {
        sum += Character.digit(c, 10);
      }
      num = sum;
    }
    return sum;
  }
}
