package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/unique-binary-search-trees>https://leetcode.com/problems/unique-binary-search-trees</a>
 *
 * <p>Key: dynamic programming; coming up with math formula before writing code
 *
 * @see P95UniqueBinarySearchTrees2
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P96UniqueBinarySearchTrees {

  int numTrees(int n);

  /**
   * Generates num unique BST recursively. Barely passes leetcode time limit.
   *
   * <p>Runtime: O(n<sup>log n</sup>) (recurrence: T(n) = SUMi(0 to n-1)T(i)+T(n-i-1))
   *
   * <p>Space: O(n) (recursion depth)
   */
  class TopDownRecursive implements P96UniqueBinarySearchTrees {

    @Override
    public int numTrees(int n) {
      return numTrees(1, n);
    }

    // T(n) = n T(n/2) + O(1)
    // O(n^(lg n))
    private int numTrees(int start, int end) {
      if (end <= start) {
        // base case
        // 1 way to construct empty/singleton tree
        return 1;
      }
      int numTrees = 0;
      // try each i : [start, end] as the root
      for (int i = start; i <= end; i++) {
        int numLeftSubtrees = numTrees(start, i - 1);
        int numRightSubtrees = numTrees(i + 1, end);
        // num unique trees is the cartesian product of left subtrees and right subtrees
        numTrees += numLeftSubtrees * numRightSubtrees;
      }
      return numTrees;
    }
  }

  /**
   * Generates num unique BST bottom up.
   *
   * <p>Runtime: O(n<sup>2</sup>)
   *
   * <p>Space: O(n)
   */
  class BottomUpIterative implements P96UniqueBinarySearchTrees {

    // let g(n) = number of unique BST for a sequence of length n (NOTE not necessarily 1..n)
    // let f(i, n) = number of unique BST, where i is the root, and sequence range is [1, n]
    // hence g(n) = f(1, n) + f(2, n) + f(3, n) + ... + f(n, n)

    // key point here is that g(n) is for any sequence of size n
    // i.e. sequence [1,2,3] and sequence [2,3,4] are both g(3)
    // same as above: num unique trees is cartesian product of left subtrees and right subtrees
    // therefore: g(n) = g(0) * g(n-1) + g(1) * g(n-2) + ... + g(n-1) + g(0)

    @Override
    public int numTrees(int n) {
      int[] g = new int[n + 1];
      // base cases
      // 1 way to construct empty tree
      g[0] = 1;
      // 1 way to construct singleton tree
      g[1] = 1;

      // recursive case
      // must start with smaller values since g(i) depends on [g(0), g(i-1)]
      for (int i = 2; i <= n; i++) {
        // g(i) = g(0) * g(i-1) + g(1) * g(i-2) + ... + g(i-1) + g(0)
        // TODO can cut this loop in half considering above formula reflects on i/2
        for (int j = 1; j <= i; j++) {
          g[i] += g[j - 1] * g[i - j];
        }
      }
      return g[n];
    }
  }
}
