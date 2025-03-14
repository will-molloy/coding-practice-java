package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/search-insert-position>https://leetcode.com/problems/search-insert-position/</a>
 *
 * <p>Runtime: O(log(n))
 *
 * <p>Extra space: O(1)
 *
 * <p>Key idea: Insert position is found at final left pointer of binary search.
 *
 * <p>This is because the search will eventually narrow in on a single element ({@code l == r == m})
 * and decide the target is not found. Then it will create a state where {@code l} is exactly 1
 * greater than {@code r}. {@code l} must be returned because it is the index of the first element
 * greater than {@code target}. I.e. if that element was smaller, {@code l} is incremented to the
 * next index, otherwise {@code l} is kept at the current index.
 *
 * @see java.util.Arrays#binarySearch
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P35SearchInsertPosition {

  public int searchInsert(int[] nums, int target) {
    int n = nums.length;

    int l = 0;
    int r = n - 1;
    while (l <= r) {
      int m = l + (r - l) / 2;
      if (nums[m] == target) {
        return m;
      } else if (nums[m] > target) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    assert l == r + 1;
    return l;
  }
}
