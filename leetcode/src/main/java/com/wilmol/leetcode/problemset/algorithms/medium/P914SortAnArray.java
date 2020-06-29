package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/sort-an-array>https://leetcode.com/problems/sort-an-array</a>
 *
 * <p>Runtime: O(n<sup>2</sup>) (worst case quick sort - array is already sorted)
 *
 * <p>Space: O(1)
 *
 * <p>Key: using indices in a consistent manner - e.g. always inclusive/exclusive
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P914SortAnArray {

  // TODO implement other sorting algorithms? Merge sort, heap sort etc.

  public int[] sortArray(int[] nums) {
    quickSort(nums, 0, nums.length);
    return nums;
  }

  // sorts nums in range: [l, r)
  private void quickSort(int[] nums, int l, int r) {
    if (r - l <= 1) {
      // base case: 0 or 1 element is already sorted
      return;
    }

    // divide: partition into halves using a pivot
    int pivotIndex = partition(nums, l, r);

    // conquer: sort halves either side of pivot
    quickSort(nums, l, pivotIndex); // sort range [l, p)
    quickSort(nums, pivotIndex + 1, r); // sort range (p, r)
  }

  private int partition(int[] nums, int l, int r) {
    // taking last element as pivot
    int pivot = nums[r - 1];

    int frontIndex = l;
    for (int i = l; i < r; i++) {
      if (nums[i] < pivot) {
        // put smaller elements at front
        swap(nums, i, frontIndex);
        frontIndex++;
      }
    }

    // put pivot at correct location
    swap(nums, frontIndex, r - 1);

    // return pivot location
    return frontIndex;
  }

  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
