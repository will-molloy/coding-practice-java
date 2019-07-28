package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by Will on 2019-07-27 at 20:51.
 *
 * <p><a
 * href=https://leetcode.com/problems/remove-duplicates-from-sorted-array>https://leetcode.com/problems/remove-duplicates-from-sorted-array</a>
 *
 * <p>Runtime: O(n), O(1) extra memory
 *
 * @see wilmol.leetcode.problemset.algorithms.medium.P80RemoveDuplicateFromSortedArray2
 */
class P26RemoveDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }

    int length = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[length - 1]) {
        nums[length] = nums[i];
        length += 1;
      }
    }
    return length;
  }
}
