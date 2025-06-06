package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/container-with-most-water>https://leetcode.com/problems/container-with-most-water</a>
 *
 * <p>Runtime: O(n) single pass on each element (two pointers), O(1) memory too
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P11ContainerWithMostWater {

  public int maxArea(int[] height) {
    int maxArea = 0;
    int l = 0;
    int r = height.length - 1;

    while (l < r) {
      int y;
      int x = r - l;
      // always move in the minimum of the two heights (greedy)
      // have to use the minimum height as per the problem definition (must form a rectangle)
      if (height[l] < height[r]) {
        y = height[l];
        l += 1;
      } else {
        y = height[r];
        r -= 1;
      }
      maxArea = Math.max(x * y, maxArea);
    }
    return maxArea;
  }
}
