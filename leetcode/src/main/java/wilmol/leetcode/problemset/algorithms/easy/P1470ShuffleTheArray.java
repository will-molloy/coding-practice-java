package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-06-08.
 *
 * <p><a
 * href=https://leetcode.com/problems/shuffle-the-array>https://leetcode.com/problems/shuffle-the-array/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Two pointers.
 */
class P1470ShuffleTheArray {

  public int[] shuffle(int[] nums, int n) {
    int xi = 0;
    int yi = n;
    int i = 0;
    int[] result = new int[n * 2];
    while (i < n * 2) {
      if (i % 2 == 0) {
        result[i++] = nums[xi++];
      } else {
        result[i++] = nums[yi++];
      }
    }
    return result;
  }
}
