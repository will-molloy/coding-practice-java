package com.willmolloy.leetcode.problemset.algorithms.hard;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/binary-tree-maximum-path-sum>https://leetcode.com/problems/binary-tree-maximum-path-sum/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key idea: Global maximum.
 *
 * @see <a href=https://youtu.be/bm0q6huoriY>Errichto's video</a>
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P687LongestUnivaluePath
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P124BinaryTreeMaximumPathSum {

  public int maxPathSum(TreeNode root) {
    int[] ref = {Integer.MIN_VALUE};
    dfs(root, ref);
    return ref[0];
  }

  private int dfs(TreeNode root, int[] globalMax) {
    if (root == null) {
      return 0;
    }

    int leftSum = dfs(root.left, globalMax);
    int rightSum = dfs(root.right, globalMax);

    // when updating global max, consider this node as the root
    // i.e. am allowed to path up and down through left and right child
    // this way we consider each node as the maximum path sums root node
    // (the reason only one node can be considered the 'root' is because otherwise the path would be
    // between >2 nodes)
    globalMax[0] = Math.max(globalMax[0], root.val + leftSum + rightSum);

    // when returning from this function, return the maximum path strictly pathing down
    // this is because callers are acting as root nodes, so it is not able to path up and then down
    // through this node (as explained above)
    // floor to 0 so paths can be cut short if they would lower the sum
    return Math.max(0, root.val + Math.max(leftSum, rightSum));
  }
}
