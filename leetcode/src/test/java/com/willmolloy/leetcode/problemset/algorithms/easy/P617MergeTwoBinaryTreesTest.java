package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.problemset.algorithms.easy.P617MergeTwoBinaryTrees.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P617MergeTwoBinaryTreesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P617MergeTwoBinaryTreesTest {

  private final P617MergeTwoBinaryTrees p617 = new P617MergeTwoBinaryTrees();

  @Test
  void example1() {
    TreeNode tree1 = new TreeNode(1);
    tree1.left = new TreeNode(3);
    tree1.right = new TreeNode(2);
    tree1.left.left = new TreeNode(5);

    TreeNode tree2 = new TreeNode(2);
    tree2.left = new TreeNode(1);
    tree2.right = new TreeNode(3);
    tree2.left.right = new TreeNode(4);
    tree2.right.right = new TreeNode(7);

    TreeNode mergedTree = new TreeNode(3);
    mergedTree.left = new TreeNode(4);
    mergedTree.left.left = new TreeNode(5);
    mergedTree.left.right = new TreeNode(4);
    mergedTree.right = new TreeNode(5);
    mergedTree.right.right = new TreeNode(7);

    assertThat(p617.mergeTrees(tree1, tree2)).isEqualTo(mergedTree);
  }
}
