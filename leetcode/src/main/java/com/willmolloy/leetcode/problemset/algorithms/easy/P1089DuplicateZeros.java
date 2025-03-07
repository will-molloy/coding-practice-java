package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/duplicate-zeros>https://leetcode.com/problems/duplicate-zeros/</a>
 *
 * <p>Key idea: First count how many shifts need to be performed and then shift (two passes).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P1089DuplicateZeros {

  void duplicateZeros(int[] arr);

  /**
   * Solution which copies the remaining elements at every zero.
   *
   * <p>Runtime: O(n<sup>2</sup>)
   *
   * <p>Extra space: O(1)
   */
  class Quadratic implements P1089DuplicateZeros {

    @Override
    public void duplicateZeros(int[] arr) {
      int n = arr.length;

      for (int i = 0; i < n; i++) {
        if (arr[i] == 0) {
          for (int j = n - 1; j >= i + 1; j--) {
            arr[j] = arr[j - 1];
          }
          i++;
        }
      }
    }
  }

  /**
   * Solution which first counts how many places will be shifted before performing another pass to
   * do the shift/copy.
   *
   * <p>Runtime: O(n)
   *
   * <p>Extra space: O(1)
   */
  class Linear implements P1089DuplicateZeros {

    @Override
    public void duplicateZeros(int[] arr) {
      int n = arr.length;

      // count number of zeros (which will be duplicated)
      int zeroCount = 0;
      for (int i = 0; i < n - zeroCount; i++) {
        if (arr[i] == 0) {
          if (i == n - 1 - zeroCount) {
            // edge case: zero can't be duplicated but it will be shifted (into the last position)
            arr[n - 1] = 0;
            n--;
            break;
          }
          zeroCount++;
        }
      }

      // copy from back of array
      for (int i = n - 1 - zeroCount; i >= 0 && zeroCount > 0; i--) {
        if (arr[i] == 0) {
          arr[i + zeroCount] = 0;
          arr[i + zeroCount - 1] = 0;
          // decrease count because prior elements will not be shifted by this now processed zero
          zeroCount--;
        } else {
          arr[i + zeroCount] = arr[i];
        }
      }
    }
  }
}
