package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/can-place-flowers>https://leetcode.com/problems/can-place-flowers/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Greedy. Choice each iteration is to place flowers or not. You should always place flowers
 * if you can because not planting only frees up the next iteration and compared to planting in the
 * next iteration, planting now blocks less of the array.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P605CanPlaceFlowers {

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int len = flowerbed.length;

    for (int i = 0; i < len; i++) {
      if (flowerbed[i] == 1) {
        continue;
      }
      boolean leftEmpty = i == 0 || flowerbed[i - 1] == 0;
      boolean rightEmpty = i == len - 1 || flowerbed[i + 1] == 0;
      if (leftEmpty && rightEmpty) {
        // greedy, always plant if possible
        flowerbed[i] = 1;
        n--;
      }
    }
    return n <= 0;
  }
}
