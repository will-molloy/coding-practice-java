package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/ways-to-make-a-fair-array>https://leetcode.com/problems/ways-to-make-a-fair-array/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Array can be partitioned into those before and those after the chosen value. Those
 * before keep original index, those after are shifted back once (even become odd (and vice versa)).
 *
 * <p>Maintaining sums for before/after and updating with each num processed (in O(1)) allows for an
 * O(n) time.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1664WaysToMakeAFairArray {

  // example:

  // [2, 1, 6, 4] | []
  // be = 8, bo = 5, ae = 0, ao = 0

  // [2, 1, 6] | []
  // be = 8, bo = 1 (-4), ae = 0, ao = 0

  // [2, 1] | [4]
  // be = 2 (-6), bo = 1, ae = 4 (+4), ao = 0

  // [2] | [6, 4]
  // be = 2, bo = 0 (-1), ae = 4, ao = 6 (+6)

  public int waysToMakeFair(int[] nums) {
    int count = 0;

    int beforeEven = 0;
    int beforeOdd = 0;
    int afterEven = 0;
    int afterOdd = 0;

    // init
    for (int i = 0; i < nums.length; i++) {
      if (i % 2 == 0) {
        beforeEven += nums[i];
      } else {
        beforeOdd += nums[i];
      }
    }

    // test each num
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i % 2 == 0) {
        beforeEven -= nums[i];
        if (beforeEven + afterEven == beforeOdd + afterOdd) {
          count++;
        }
        afterOdd += nums[i];
      } else {
        beforeOdd -= nums[i];
        if (beforeEven + afterEven == beforeOdd + afterOdd) {
          count++;
        }
        afterEven += nums[i];
      }
    }
    return count;
  }
}
