package com.wilmol.leetcode.problemset.algorithms.hard;

/**
 * <a
 * href=https://leetcode.com/problems/median-of-two-sorted-arrays>https://leetcode.com/problems/median-of-two-sorted-arrays</a>
 *
 * <p>Runtime: O(n + m) - single pass on each array
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P4MedianOfTwoSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // this solution is very similar to merge sort (the merge part...)
    // however, terrible space use atm.
    // Can just keep pointer to middle two elements. Also stop at (n + m) / 2. i.e. can discard the
    // front elements!
    // Merge the sorted lists until size ((n + m) / 2) + 1
    // e.g. 1 above [1, 2] -> Even -> Take last -> (2)
    // e.g. 2 above: [1, 2, 3] -> Odd -> Take last and last-1 (2,3)

    int[] merged = new int[nums1.length + nums2.length];
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        merged[k++] = nums1[i++];
      } else {
        merged[k++] = nums2[j++];
      }
    }
    while (i < nums1.length) {
      merged[k++] = nums1[i++];
    }
    while (j < nums2.length) {
      merged[k++] = nums2[j++];
    }
    return median(merged);
  }

  private double median(int[] array) {
    int middle = array.length / 2;
    if (array.length % 2 == 0) {
      // size -> 2 -> [ 0 1 ]
      // size -> 4 -> [ 0 1 2 3 ]
      return (double) (array[middle] + array[middle - 1]) / 2;
    } else {
      // size = 3 -> [0 1 2]
      return (double) array[middle];
    }
  }
}
