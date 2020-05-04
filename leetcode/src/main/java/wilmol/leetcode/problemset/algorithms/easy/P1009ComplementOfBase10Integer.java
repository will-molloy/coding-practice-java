package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-05-04.
 *
 * <p><a
 * href=https://leetcode.com/problems/complement-of-base-10-integer>https://leetcode.com/problems/complement-of-base-10-integer/</a>
 *
 * <p>Runtime: O(bitLength(num))
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Duplicate problem of {@link P476NumberComplement}
 *
 * @see P476NumberComplement
 */
class P1009ComplementOfBase10Integer {

  public int bitwiseComplement(int num) {
    if (num == 0) {
      return 1;
    }

    int res = 0;
    int exp = 0;
    while (num > 0) {
      int bit = num % 2;
      // flip
      bit = bit == 1 ? 0 : 1;

      res += bit << exp;

      num /= 2;
      exp++;
    }
    return res;
  }
}
