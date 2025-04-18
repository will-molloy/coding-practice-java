package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTreeTest {

  private final P1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree
      p1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree =
          new P1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree();

  @Test
  void example1() {
    TreeNode original = TreeNode.fromLevelOrder(7, 4, 3, null, null, 6, 19);
    TreeNode cloned = TreeNode.fromLevelOrder(7, 4, 3, null, null, 6, 19);
    TreeNode target = original.right;
    TreeNode expected = cloned.right;

    assertThat(
            p1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.getTargetCopy(
                original, cloned, target))
        .isSameInstanceAs(expected);
  }

  @Test
  void example2() {
    TreeNode original = new TreeNode(7);
    TreeNode cloned = new TreeNode(7);
    TreeNode target = original;
    TreeNode expected = cloned;

    assertThat(
            p1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.getTargetCopy(
                original, cloned, target))
        .isSameInstanceAs(expected);
  }

  @Test
  void example3() {
    TreeNode original =
        TreeNode.fromLevelOrder(
            8, null, 6, null, null, null, 5, null, null, null, null, null, null, null, 4);
    TreeNode cloned =
        TreeNode.fromLevelOrder(
            8, null, 6, null, null, null, 5, null, null, null, null, null, null, null, 4);
    TreeNode target = original.right.right.right;
    TreeNode expected = cloned.right.right.right;

    assertThat(
            p1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.getTargetCopy(
                original, cloned, target))
        .isSameInstanceAs(expected);
  }

  @Test
  void example4() {
    TreeNode original = TreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    TreeNode cloned = TreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    TreeNode target = original.left.right;
    TreeNode expected = cloned.left.right;

    assertThat(
            p1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.getTargetCopy(
                original, cloned, target))
        .isSameInstanceAs(expected);
  }

  @Test
  void example5() {
    TreeNode original = TreeNode.fromLevelOrder(1, 2, null, 3);
    TreeNode cloned = TreeNode.fromLevelOrder(1, 2, null, 3);
    TreeNode target = original.left;
    TreeNode expected = cloned.left;

    assertThat(
            p1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.getTargetCopy(
                original, cloned, target))
        .isSameInstanceAs(expected);
  }
}
