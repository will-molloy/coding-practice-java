package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2019-08-13.
 *
 * <p><a
 * href=https://leetcode.com/problems/find-minimum-in-rotated-sorted-array>https://leetcode.com/problems/find-minimum-in-rotated-sorted-array</a>
 *
 * <p>Runtime: O(log n)
 *
 * @see P33SearchInRotatedSortedArray
 */
class P153FindMinimumInRotatedSortedArray {

  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int mid = (left + right) >>> 1;

      if (nums[mid] > nums[right]) {
        // rotated case, smaller values are on the right
        left = mid + 1;
      } else {
        // normal case, smaller values are on the left
        right = mid;
      }
    }
    // left == right
    return nums[left];
  }
}
