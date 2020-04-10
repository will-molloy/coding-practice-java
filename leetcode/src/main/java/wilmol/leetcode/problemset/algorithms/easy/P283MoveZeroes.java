package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-04-10.
 *
 * <p><a
 * href=https://leetcode.com/problems/move-zeroes>https://leetcode.com/problems/move-zeroes</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: two pointer - one for count of zeroes, other for current array index
 */
class P283MoveZeroes {

  // TODO more optimal solution (fewer operations but still O(n)) exists where you swap elements

  public void moveZeroes(int[] nums) {
    // running count of zeroes
    int zeroes = 0;

    // shift back elements
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeroes += 1;
      } else {
        nums[i - zeroes] = nums[i];
      }
    }

    // fill in tail of zeroes
    for (int i = nums.length - zeroes; i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}
