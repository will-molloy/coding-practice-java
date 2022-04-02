package com.willmolloy.hackerrank.interviewpreparationkit.sorting.hard;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/ctci-merge-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting>https://www.hackerrank.com/challenges/ctci-merge-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting</a>
 *
 * <p>Runtime: O(n log n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MergeSortCountingInversions {

  private MergeSortCountingInversions() {}

  // use static 'global' variable per invocation such that a standard mergesort can be used with few
  // modifications (avoid passing additional args etc..)
  // threadlocal such that tests can run in parallel
  private static final ThreadLocal<Long> COUNT = new ThreadLocal<>();

  static long countInversions(int[] arr) {
    COUNT.set(0L);
    mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    return COUNT.get();
  }

  private static void mergeSort(int[] arr, int[] copy, int start, int end) {
    if (start >= end) {
      return;
    }
    // divide (until singular elements)
    int mid = (start + end) / 2;
    mergeSort(arr, copy, start, mid);
    mergeSort(arr, copy, mid + 1, end);
    // conquer (from singular elements to complete array)
    merge(arr, copy, start, mid, end);
  }

  private static void merge(int[] arr, int[] copy, int start, int mid, int end) {
    for (int i = start; i <= end; i++) {
      copy[i] = arr[i];
    }
    int i = start;
    int left = start;
    int right = mid + 1;

    // merge left and right halves (pick smaller element at each iteration)
    // safe to assume these halves are sorted; initially they are singular elements
    while (left <= mid && right <= end) {
      if (copy[left] <= copy[right]) {
        // smaller element in left side
        arr[i] = copy[left];
        i += 1;
        left += 1;
      } else {
        // smaller element in right side
        // count of inversions is number of elements the element moves over (i.e. from right to
        // left)
        COUNT.set(COUNT.get() + mid + 1 - left);
        arr[i] = copy[right];
        i += 1;
        right += 1;
      }
    }
    // may have exhausted one half before the other
    while (left <= mid) {
      // remaining elements in left half
      arr[i] = copy[left];
      i += 1;
      left += 1;
    }
    while (right <= end) {
      // remaining elements in right half (TODO remove? passes without this ???)
      arr[i] = copy[right];
      i += 1;
      right += 1;
    }
  }
}
