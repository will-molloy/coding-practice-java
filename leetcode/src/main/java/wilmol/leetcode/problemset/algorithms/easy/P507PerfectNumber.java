package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-05-14.
 *
 * <p><a
 * href=https://leetcode.com/problems/perfect-number>https://leetcode.com/problems/perfect-number/</a>
 *
 * <p>Runtime: O(sqrt(n))
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Finding divisors; go up to sqrt cause divisors form pairs (since multiplication is a
 * binary operation), one on left side of sqrt, other on right side.
 */
class P507PerfectNumber {

  public boolean checkPerfectNumber(int num) {
    if (num <= 1) {
      return false;
    }

    int sum = 1;
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        sum += i;
        sum += num / i;
      }
      if (sum > num) {
        return false;
      }
    }
    return sum == num;
  }
}
