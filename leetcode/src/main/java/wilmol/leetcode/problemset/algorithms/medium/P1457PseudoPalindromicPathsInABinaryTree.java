package wilmol.leetcode.problemset.algorithms.medium;

import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-05-24.
 *
 * <p><a
 * href=https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree>https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(h)
 *
 * <p>Key: Palindrome permutation if at most one odd frequency.
 */
class P1457PseudoPalindromicPathsInABinaryTree {

  private int ans;

  public int pseudoPalindromicPaths(BinaryTreeNode root) {
    // gather all root to leaf paths, dfs

    // is palindrome if at most ONE odd count of some node
    // track path in fixed sized freq array

    ans = 0;

    dfs(root, new int[10]);

    return ans;
  }

  private void dfs(BinaryTreeNode node, int[] valFreqs) {
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
