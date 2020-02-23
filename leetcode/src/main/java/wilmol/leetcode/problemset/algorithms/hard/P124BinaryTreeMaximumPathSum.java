package wilmol.leetcode.problemset.algorithms.hard;

import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-02-23.
 *
 * <p><a
 * href=https://leetcode.com/problems/binary-tree-maximum-path-sum>https://leetcode.com/problems/binary-tree-maximum-path-sum</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key: can only have one place where the path 'branches' (branch meaning go through left and
 * right child of some node)
 */
class P124BinaryTreeMaximumPathSum {

  public int maxPathSum(BinaryTreeNode root) {
    IntRef ref = new IntRef(Integer.MIN_VALUE);
    maxPathSum(root, ref);
    return ref.value;
  }

  private int maxPathSum(BinaryTreeNode node, IntRef overallMax) {
    // base case
    if (node == null) {
      return 0;
    }

    // recursively get/update max for left/right subtree
    int leftPath = Math.max(0, maxPathSum(node.left, overallMax));
    int rightPath = Math.max(0, maxPathSum(node.right, overallMax));

    // best path which doesn't consider this node as the root
    // i.e. not allowed to path through both left and right child
    int maxPathNotRoot = Math.max(leftPath, rightPath) + node.val;

    // best path which considers this node as the root
    // i.e. am allowed to path through both left and right child
    int maxPathAsRoot = Math.max(maxPathNotRoot, node.val + leftPath + rightPath);

    // update overall max; this way consider each node as a root node
    overallMax.value = Math.max(overallMax.value, maxPathAsRoot);

    // each call to this method considers 'node' as a root
    // therefore can't return 'maxPathAsRoot', because then callers consider this 'node' and their
    // 'node' as roots, and am only allowed one root
    return maxPathNotRoot;
  }

  private static final class IntRef {
    private int value;

    private IntRef(int value) {
      this.value = value;
    }
  }
}
