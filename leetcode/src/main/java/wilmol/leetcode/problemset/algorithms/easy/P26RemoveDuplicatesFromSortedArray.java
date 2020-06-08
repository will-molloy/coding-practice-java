package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by Will on 2019-07-27 at 20:51.
 *
 * <p><a
 * href=https://leetcode.com/problems/remove-duplicates-from-sorted-array>https://leetcode.com/problems/remove-duplicates-from-sorted-array</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Track length of 'new' array (but write in-place); only write new numbers.
 *
 * @see P27RemoveElement
 * @see wilmol.leetcode.problemset.algorithms.medium.P80RemoveDuplicateFromSortedArray2
 */
class P26RemoveDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {
    int n = nums.length;

    // initially keep the first element
    int length = 1;
    for (int i = 1; i < n; i++) {
      if (nums[i] > nums[i - 1]) {
        // only write new numbers (i.e. those at the start of duplicate runs)
        nums[length++] = nums[i];
      }
    }
    return length;
  }
}
