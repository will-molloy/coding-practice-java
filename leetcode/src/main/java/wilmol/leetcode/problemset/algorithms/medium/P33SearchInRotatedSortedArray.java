package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2019-08-13.
 *
 * <p><a
 * href=https://leetcode.com/problems/search-in-rotated-sorted-array>https://leetcode.com/problems/search-in-rotated-sorted-array</a>
 *
 * <p>Runtime: O(log n)
 *
 * @see P153FindMinimumInRotatedSortedArray
 * @see P81SearchInRotatedSortedArray2
 */
class P33SearchInRotatedSortedArray {

  public int search(int[] nums, int target) {
    int rotation = getLeftRotation(nums);
    return rotatedSearch(nums, target, rotation);
  }

  private int getLeftRotation(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    // find index of smallest value (using binary search)
    // this is the number of places rotated (to the left) since un-rotated it would have index 0
    while (left < right) {
      int mid = (left + right) >>> 1;

      if (nums[mid] > nums[right]) {
        // rotated case, smaller values are on right side
        left = mid + 1;
      } else {
        // normal case, smaller values are on left side
        right = mid;
      }
    }
    // index of smallest value is in both left and right
    return left;
  }

  private int rotatedSearch(int[] nums, int target, int leftRotation) {
    int left = 0;
    int right = nums.length - 1;

    // usual binary search, accounting for rotation
    while (left <= right) {
      int mid = (left + right) >>> 1;
      int realMid = (mid + leftRotation) % nums.length;

      if (nums[realMid] > target) {
        // target is on left side
        right = mid - 1;
      } else if (nums[realMid] < target) {
        // target is on right side
        left = mid + 1;
      } else {
        // target found
        return realMid;
      }
    }
    return -1;
  }
}
