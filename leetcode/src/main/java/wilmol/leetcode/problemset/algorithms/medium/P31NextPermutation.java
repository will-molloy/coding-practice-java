package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2019-08-11.
 *
 * <p><a
 * href=https://leetcode.com/problems/next-permutation>https://leetcode.com/problems/next-permutation</a>
 *
 * <p>Runtime: O(n), with O(1) extra memory
 *
 * <p>TODO Key:
 *
 * @see P60PermutationSequence
 */
class P31NextPermutation {

  public void nextPermutation(int[] nums) {
    // Find increasing pair from the right: [a, b] (algorithm detail)
    // E.g.1 nums = [1, 2, 3]; a = 2, b = 3
    // E.g.2 nums = [1, 2, 3, 5, 4]; a = 3, b = 4
    // E.g.3 nums = [3, 2, 1]; no increasing pair
    // note: a/b variables here are indices rather than values

    // Get left of the pair (a)
    // i.e. first value smaller than its right value
    int a = nums.length - 1;
    while (a > 0 && nums[a - 1] >= nums[a]) {
      a -= 1;
    }
    a -= 1; // a = -1 if no nums in descending order (i.e. no increasing pair)

    // Get right of the pair (b)
    // i.e. first value (from the right) greater than a
    // so nums = [3, 5, 4]. a = 3; b = 4 (not 5!) - the pair aren't always adjacent
    int b = nums.length - 1;
    while (a >= 0 && b >= 0 && nums[b] <= nums[a]) {
      b -= 1;
    }

    // swap a with b and reverse elements after a (algorithm detail)
    // e.g.1 [1, 2, 3] -> [1, 3, 2] -> [1, 3, 2]
    // e.g.2 [1, 2, 3, 5, 4] -> [1, 2, 4, 5, 3] -> [1, 2, 4, 3, 5]
    if (a >= 0) {
      swap(nums, a, b);
    }
    reverse(nums, a + 1);
  }

  /** Swaps x[a] with x[b]. */
  private void swap(int[] x, int a, int b) {
    int temp = x[a];
    x[a] = x[b];
    x[b] = temp;
  }

  /** Reverses elements in x[] from fromIndex onwards. */
  private void reverse(int[] x, int fromIndex) {
    int i = x.length - 1;
    int j = fromIndex;
    while (i > j) {
      swap(x, i, j);
      i -= 1;
      j += 1;
    }
  }
}
