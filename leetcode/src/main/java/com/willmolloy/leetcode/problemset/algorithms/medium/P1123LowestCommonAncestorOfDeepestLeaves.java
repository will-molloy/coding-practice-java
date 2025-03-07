package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves>https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/</a>
 *
 * @see P865SmallestSubtreeWithAllTheDeepestNodes
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1123LowestCommonAncestorOfDeepestLeaves {

  private final P865SmallestSubtreeWithAllTheDeepestNodes delegate =
      new P865SmallestSubtreeWithAllTheDeepestNodes();

  public TreeNode lcaDeepestLeaves(TreeNode root) {
    return delegate.subtreeWithAllDeepest(root);
  }
}
