package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-02-02.
 *
 * <p><a
 * href=https://leetcode.com/problems/search-in-rotated-sorted-array-ii>https://leetcode.com/problems/search-in-rotated-sorted-array-ii</a>
 *
 * <p>Runtime: O(lg n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: either left or right side must be sorted ..?
 *
 * @see P33SearchInRotatedSortedArray
 */
class P81SearchInRotatedSortedArray2 {

  // NOTE that the 'getLeftRotation` method in P33 doesn't work here (now that there are dupes!)

  public boolean search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = (left + right) >>> 1;

      if (nums[mid] == target) {
        // target found
        return true;
      }

      if (nums[left] < nums[mid]) {
        // left side is sorted
        if (nums[left] <= target && target < nums[mid]) {
          // target on left side
          right = mid - 1;
        } else {
          // target on right side
          left = mid + 1;
        }
      } else if (nums[left] > nums[mid]) {
        // right side is sorted
        if (nums[mid] < target && target <= nums[right]) {
          // target on right side
          left = mid + 1;
        } else {
          // target on left side
          right = mid - 1;
        }
      } else {
        // nums[left] = nums[mid], just move pointer to skip over dupe
        left++;
      }
    }
    return false;
  }
}
