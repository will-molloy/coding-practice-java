package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2019-12-15.
 *
 * <p><a
 * href=https://leetcode.com/problems/fibonacci-number>https://leetcode.com/problems/fibonacci-number</a>
 *
 * <p>Runtime: O(n) TODO can be O(1) with mathematical formula, see leetcode solution page
 *
 * <p>Space: O(1)
 *
 * <p>Key: dynamic programming
 *
 * @see wilmol.dsa.dp.Fibonacci
 * @see P1137NthTribonacciNumber
 */
class P509FibonacciNumber {

  public int fib(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    // for base case n = 1
    int fnMinus1 = 0;
    int fn = 1;
    for (int i = 2; i <= n; i++) {
      int temp = fn;
      fn = fn + fnMinus1;
      fnMinus1 = temp;
    }
    return fn;
  }
}
