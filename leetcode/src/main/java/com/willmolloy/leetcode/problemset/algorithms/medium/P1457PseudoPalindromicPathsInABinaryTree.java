package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree>https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(h)
 *
 * <p>Key: Palindrome permutation if at most one odd frequency.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P409LongestPalindrome
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P1457PseudoPalindromicPathsInABinaryTree {

  int pseudoPalindromicPaths(TreeNode root);

  /** Solution which uses an array to track the path. */
  class Array implements P1457PseudoPalindromicPathsInABinaryTree {

    private int ans;

    public int pseudoPalindromicPaths(TreeNode root) {
      // gather all root to leaf paths, dfs

      // is palindrome if at most ONE odd count of some node
      // track path in fixed sized freq array

      ans = 0;
      dfs(root, new int[10]);
      return ans;
    }

    private void dfs(TreeNode node, int[] valFreqs) {
      if (node == null) {
        return;
      }
      // when branching, don't want siblings to share state as they aren't on the same path
      // so copy path state because int array is mutated in place
      valFreqs = valFreqs.clone();
      valFreqs[node.val]++;
      if (node.left == null && node.right == null) {
        // leaf
        if (atMostOneOdd(valFreqs)) {
          ans++;
        }
      } else {
        // non-leaf
        dfs(node.left, valFreqs);
        dfs(node.right, valFreqs);
      }
    }

    private boolean atMostOneOdd(int[] valFreqs) {
      boolean oneOdd = false;
      for (int valFreq : valFreqs) {
        if (valFreq % 2 != 0) {
          if (oneOdd) {
            return false;
          }
          oneOdd = true;
        }
      }
      return true;
    }
  }

  /** Solution which uses a bitmask to track the path. */
  class BitMask implements P1457PseudoPalindromicPathsInABinaryTree {

    private int ans;

    public int pseudoPalindromicPaths(TreeNode root) {
      ans = 0;
      dfs(root, 0);
      return ans;
    }

    private void dfs(TreeNode node, int bitmask) {
      if (node == null) {
        return;
      }
      bitmask ^= 1 << (node.val);
      if (node.left == null && node.right == null) {
        // leaf
        if ((bitmask & (bitmask - 1)) == 0) {
          ans++;
        }
      } else {
        // non-leaf
        dfs(node.left, bitmask);
        dfs(node.right, bitmask);
      }
    }
  }
}
