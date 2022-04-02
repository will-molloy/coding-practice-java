package com.willmolloy.hackerrank.interviewpreparationkit.sorting.easy;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting>https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting</a>
 *
 * <p>Count the swaps in bubble sort.
 *
 * <p>Runtime: O(n ^ 2)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class BubbleSortCountSwaps {

  private BubbleSortCountSwaps() {}

  static int countSwaps(int[] a) {
    int count = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if (a[j] < a[i]) {
          int temp = a[j];
          a[j] = a[i];
          a[i] = temp;
          count += 1;
        }
      }
    }
    return count;
  }
}
