package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-04-17.
 *
 * <p><a
 * href=https://leetcode.com/problems/lemonade-change>https://leetcode.com/problems/lemonade-change</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: Prefer to use $10 and $5 (as change for $20) so have enough $5 for customers with $10.
 */
class P860LemonadeChange {

  public boolean lemonadeChange(int[] bills) {
    int fives = 0;
    int tens = 0;
    for (int bill : bills) {
      // just handle each case...
      if (bill == 5) {
        fives++;
      } else if (bill == 10) {
        if (fives == 0) {
          return false;
        }
        fives--;
        tens++;
      } else { // bill == 20
        // prefer use $10 + $5 = $15, so save $5 for case where bill is $10
        // ($10 aren't used anywhere else)
        if (fives >= 1 && tens >= 1) {
          fives--;
          tens--;
        } else if (fives >= 3) {
          fives -= 3;
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
