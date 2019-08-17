package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2019-08-17.
 *
 * <p><a
 * href=https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array>https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array</a>
 *
 * <p>Runtime: O(log n) (O(n) worst case)
 */
class P34FindFirstAndLastPositionOfElementInSortedArray {

  public int[] searchRange(int[] nums, int target) {
    // normal binary search to find target
    // then scan left/right for first/last occurrence of target

    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) >>> 1;

      if (nums[mid] < target) {
        // target on right
        low = mid + 1;
      } else if (nums[mid] > target) {
        // target on left
        high = mid - 1;
      } else {
        // target found
        int first = mid;
        int last = mid;
        while (first >= 0 && nums[first] == target) {
          first -= 1;
        }
        while (last < nums.length && nums[last] == target) {
          last += 1;
        }
        return new int[] {first + 1, last - 1};
      }
    }
    // target not found
    return new int[] {-1, -1};
  }
}
