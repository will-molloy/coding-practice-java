package wilmol.leetcode.problemset.algorithms.hard;

import java.util.Arrays;

/**
 * Created by wilmol on 2019-08-29.
 *
 * <p><a
 * href=https://leetcode.com/problems/trapping-rain-water>https://leetcode.com/problems/trapping-rain-water</a>
 */
interface P42TrappingRainWater {

  int trap(int[] heights);

  /**
   * Multiple pass solution, trap rain by checking each level.
   *
   * <p>Barely passes TLE on leetcode (bottom 5%).
   *
   * <p>Runtime: O(n * max(heights)), O(1) extra memory
   */
  class MultiplePass implements P42TrappingRainWater {

    public int trap(int[] heights) {
      int maxHeight = max(heights);
      int amount = 0;

      for (int height = 1; height <= maxHeight; height++) {
        int barLoc = -1;
        for (int i = 0; i < heights.length; i++) {
          if (heights[i] >= height) {
            if (barLoc == -1) {
              barLoc = i;
            } else {
              int leftBar = heights[barLoc];
              int rightBar = heights[i];
              int smallerBar = Math.min(leftBar, rightBar);
              // offset bar by one since rain gets trapped between bars
              while (++barLoc < i) {
                // fill each 'hole' up to the height of the smaller bar
                amount += smallerBar - heights[barLoc];
                heights[barLoc] = smallerBar;
              }
            }
          }
        }
      }
      return amount;
    }

    private static int max(int[] ints) {
      return Arrays.stream(ints).reduce(Math::max).orElse(0);
    }
  }

  /**
   * Single pass solution. Uses two pointers moving inwards from either side.
   *
   * <p>Runtime: O(n), O(1) extra memory
   */
  class SinglePass implements P42TrappingRainWater {

    public int trap(int[] heights) {
      int amount = 0;
      int left = 0;
      int right = heights.length - 1;

      // find first left and right bar to hold water
      while (left < right && heights[left] <= heights[left + 1]) {
        left++;
      }
      while (left < right && heights[right] <= heights[right - 1]) {
        right--;
      }

      while (left < right) {
        int leftBarHeight = heights[left];
        int rightBarHeight = heights[right];

        // fill to the smaller bar
        if (leftBarHeight <= rightBarHeight) {
          // fill with rain until a bar larger than left bar
          while (left < right && leftBarHeight >= heights[++left]) {
            amount += leftBarHeight - heights[left];
          }
        } else {
          // fill with rain until a bar larger than right bar
          while (left < right && rightBarHeight >= heights[--right]) {
            amount += rightBarHeight - heights[right];
          }
        }
      }
      return amount;
    }
  }
}
