package wilmol.leetcode.problemset.algorithms.easy;

import java.util.Arrays;

/**
 * Created by wilmol on 2019-08-18.
 *
 * <p><a
 * href=https://leetcode.com/problems/search-insert-position>https://leetcode.com/problems/search-insert-position</a>
 *
 * <p>Runtime: O(log n) (given its under easy, maybe can just solve in O(n)...)
 */
class P35SearchInsertPosition {

  public int searchInsert(int[] nums, int target) {
    // normal binary search
    // but check target would fit between mid and next/prev element i.e.
    // mid < target && mid + 1 > target -> return mid + 1 (insert after smaller element)
    // mid > target && mid - 1 < target -> return mid (insert at larger element)

    // check less than min or greater than max
    if (target <= nums[0]) {
      return 0;
    }
    if (target > nums[nums.length - 1]) {
      return nums.length;
    }

    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) >>> 1;

      if (nums[mid] < target) {
        // check target would fit here
        if (mid < nums.length - 1 && nums[mid + 1] > target) {
          return mid + 1;
        }
        // target on right
        low = mid + 1;

      } else if (nums[mid] > target) {
        // check target would fit here
        if (mid > 0 && nums[mid - 1] < target) {
          return mid;
        }
        // target on left
        high = mid - 1;

      } else {
        // target found
        return mid;
      }
    }
    // should never reach here
    throw new IllegalStateException(
        String.format(
            "Failed to find insert position. nums=%s, target=%d", Arrays.toString(nums), target));
  }
}
