package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/merge-sorted-array>https://leetcode.com/problems/merge-sorted-array</a>
 *
 * <p>Runtime: O(m + n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: merging in reverse order to make use of 'empty array space' and achieve O(1) memory use
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P88MergeSortedArray {

  public void merge(int[] nums1, int m, int[] nums2, int n) {

    // index over nums1 (starting at last element)
    int i1 = m - 1;
    // index over nums2 (starting at last element)
    int i2 = n - 1;
    // index over merged nums1 and nums2 (starting at last element)
    int i = m + n - 1;

    // merge from back, i.e. choose largest element at each step
    while (i1 >= 0 && i2 >= 0) {
      if (nums1[i1] >= nums2[i2]) {
        nums1[i--] = nums1[i1--];
      } else {
        nums1[i--] = nums2[i2--];
      }
    }
    // only need to merge remaining nums2, remaining nums1 would already be in the list
    while (i2 >= 0) {
      nums1[i--] = nums2[i2--];
    }
  }
}
