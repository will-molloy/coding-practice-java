package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-04-17.
 *
 * <p><a
 * href=https://leetcode.com/problems/find-lucky-integer-in-an-array>https://leetcode.com/problems/find-lucky-integer-in-an-array</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: Frequency table.
 */
class P1394FindLuckyIntegerInAnArray {

  public int findLucky(int[] arr) {
    // freq table
    int[] table = new int[500];
    for (int i : arr) {
      table[i - 1]++;
    }

    // find max lucky
    int max = -1;
    for (int i : arr) {
      if (table[i - 1] == i) {
        max = Math.max(max, i);
      }
    }
    return max;
  }
}
