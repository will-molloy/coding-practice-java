package wilmol.leetcode.problemset.algorithms.hard;

/**
 * Created by wilmol on 2020-02-02.
 *
 * <p><a
 * href=https://leetcode.com/problems/largest-rectangle-in-histogram>https://leetcode.com/problems/largest-rectangle-in-histogram</a>
 *
 * @see P42TrappingRainWater
 */
interface P84LargestRectangleInHistogram {

  int largestRectangleArea(int[] heights);

  /**
   * Brute force solution, bottom 5% on Leetcode.
   *
   * <p>Runtime: O(n<sup>2</sup>)
   *
   * <p>Space: O(1)
   *
   * <p>Key: try every combination of left/right
   */
  class BruteForce implements P84LargestRectangleInHistogram {

    @Override
    public int largestRectangleArea(int[] heights) {
      int maxArea = 0;
      for (int left = 0; left < heights.length; left++) {
        int min = heights[left];
        for (int right = left; right < heights.length; right++) {
          min = Math.min(min, heights[right]);
          // right = index of rightmost bar considered
          // left = index of leftmost bar considered
          int area = min * (right - left + 1);
          maxArea = Math.max(maxArea, area);
        }
      }
      return maxArea;
    }
  }

  /**
   * Linear solution (but with O(n) memory use).
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(n)
   *
   * <p>Key: computing indices of minimum left/right heights ahead of time
   */
  class Linear implements P84LargestRectangleInHistogram {

    @Override
    public int largestRectangleArea(int[] heights) {
      if (heights == null || heights.length == 0) {
        return 0;
      }

      // index of first height from the left that is less than current
      int[] lessFromLeft = new int[heights.length];
      // index of first height from the right that is less than current
      int[] lessFromRight = new int[heights.length];

      // initialise lessFromLeft (in O(n), by building on previous initialisation)
      lessFromLeft[0] = -1; // nothing smaller (from the left)
      for (int i = 1; i < heights.length; i++) {
        int minI = i - 1;
        while (minI >= 0 && heights[minI] >= heights[i]) {
          minI = lessFromLeft[minI];
        }
        lessFromLeft[i] = minI;
      }

      // initialise lessFromRight (in O(n), by building on previous initialisation)
      lessFromRight[heights.length - 1] = heights.length; // nothing smaller (from the right)
      for (int i = heights.length - 2; i >= 0; i--) {
        int minI = i + 1;
        while (minI < heights.length && heights[minI] >= heights[i]) {
          minI = lessFromRight[minI];
        }
        lessFromRight[i] = minI;
      }

      // can now find the maximum area in O(n)
      // since the indices of the left/right 'minimums' have been precomputed
      int maxArea = 0;
      for (int i = 0; i < heights.length; i++) {
        // area will be the maximum area when 'heights[i]' is considered
        int right = lessFromRight[i];
        int left = lessFromLeft[i];
        // note:
        // - right is the first index right of the rightmost bar considered
        // - left is the first index left of the leftmost bar considered
        // (i.e. different to above solution)
        int area = heights[i] * (right - left - 1);
        maxArea = Math.max(maxArea, area);
      }
      return maxArea;
    }
  }
}
