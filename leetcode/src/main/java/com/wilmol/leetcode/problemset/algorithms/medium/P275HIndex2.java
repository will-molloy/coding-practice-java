package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-06-19.
 *
 * <p><a href=https://leetcode.com/problems/h-index-ii>https://leetcode.com/problems/h-index-ii/</a>
 *
 * <p>Runtime: O(log(n))
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Can use binary search since input is sorted.
 *
 * @see P274HIndex
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P35SearchInsertPosition
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P1044LongestDuplicateSubstring
 */
class P275HIndex2 {

  // explained more in P274HIndex

  public int hIndex(int[] citations) {
    int n = citations.length;

    int l = 0;
    int r = n - 1;
    int max = 0;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      // [mid, n)
      int h = n - mid;
      if (citations[mid] >= h) {
        // condition passes, search left for better (i.e. larger) result
        max = h;
        r = mid - 1;
      } else {
        // condition fails, search right where it can pass
        l = mid + 1;
      }
    }
    // max = n - l because [0, l) are <= max and [l, n) are >= max
    // i.e. l is the insert position of the largest possible h (max)
    assert max == n - l;
    return max;
  }
}
