package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k>https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: {@code a + b % k == 0} is same as {@code (a % k) + (b % k) == k}, therefore can compute
 * {@code b} from {@code a} and {@code k} (similar to {@linkplain
 * com.wilmol.leetcode.problemset.algorithms.easy.P1TwoSum two sum problem}), then just ensure equal
 * number of a's and b's.
 *
 * <p>E.g.
 *
 * <pre>{@code
 * arr    = [1,2,3,4,5,10,6,7,8,9], k = 5
 * arr%k  = [1,2,3,4,0, 0,1,2,3,4]
 * counts = [1=2, 2=2, 3=2, 4=2, 0=2]
 * }</pre>
 *
 * <p>So for {@code a = 1}, check equal number of {@code b = 5 - 1 = 4}. Etc.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P1TwoSum
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1497CheckIfArrayPairsAreDivisibleByK {

  public boolean canArrange(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    // idea: (a + b) % k == 0 is equivalent to (a % k) + (b % k) == k
    // so store (a % k), then can get (b % k) from (b % k) = k - (a % k)

    // count (a % k)
    for (int a : arr) {
      // in case a is negative, first add to k
      int x = ((k + (a % k))) % k;
      map.merge(x, 1, Integer::sum);
    }

    // check counts
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int a = entry.getKey();
      int aCount = entry.getValue();

      if (a == 0) {
        // in this case, a = 0
        // b = (k - a) % k = (k - 0) % k = 0
        // i.e. a = b = 0
        // check even number of 0s (so can form pairs)
        if (aCount % 2 != 0) {
          return false;
        }
      } else {
        // check equal number of as and bs (so can form pairs)
        int b = k - a;
        Integer bCount = map.get(b);
        if (bCount == null || bCount != aCount) {
          return false;
        }
      }
    }
    return true;
  }
}
