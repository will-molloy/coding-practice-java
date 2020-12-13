package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves>https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/</a>
 *
 * @see P865SmallestSubtreeWithAllTheDeepestNodes
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1123LowestCommonAncestorOfDeepestLeaves {

  private final P865SmallestSubtreeWithAllTheDeepestNodes delegate =
      new P865SmallestSubtreeWithAllTheDeepestNodes();

  public BinaryTreeNode lcaDeepestLeaves(BinaryTreeNode root) {
    return delegate.subtreeWithAllDeepest(root);
  }
}
