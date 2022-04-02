package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTreeTest {

  private final P1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree
      p1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree =
          new P1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree();

  @Test
  void example1() {
    BinaryTreeNode original = BinaryTreeNode.fromLevelOrder(7, 4, 3, null, null, 6, 19);
    BinaryTreeNode cloned = BinaryTreeNode.fromLevelOrder(7, 4, 3, null, null, 6, 19);
    BinaryTreeNode target = original.right;
    BinaryTreeNode expected = cloned.right;

    assertThat(
            p1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.getTargetCopy(
                original, cloned, target))
        .isSameInstanceAs(expected);
  }

  @Test
  void example2() {
    BinaryTreeNode original = new BinaryTreeNode(7);
    BinaryTreeNode cloned = new BinaryTreeNode(7);
    BinaryTreeNode target = original;
    BinaryTreeNode expected = cloned;

    assertThat(
            p1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.getTargetCopy(
                original, cloned, target))
        .isSameInstanceAs(expected);
  }

  @Test
  void example3() {
    BinaryTreeNode original =
        BinaryTreeNode.fromLevelOrder(
            8, null, 6, null, null, null, 5, null, null, null, null, null, null, null, 4);
    BinaryTreeNode cloned =
        BinaryTreeNode.fromLevelOrder(
            8, null, 6, null, null, null, 5, null, null, null, null, null, null, null, 4);
    BinaryTreeNode target = original.right.right.right;
    BinaryTreeNode expected = cloned.right.right.right;

    assertThat(
            p1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.getTargetCopy(
                original, cloned, target))
        .isSameInstanceAs(expected);
  }

  @Test
  void example4() {
    BinaryTreeNode original = BinaryTreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    BinaryTreeNode cloned = BinaryTreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    BinaryTreeNode target = original.left.right;
    BinaryTreeNode expected = cloned.left.right;

    assertThat(
            p1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.getTargetCopy(
                original, cloned, target))
        .isSameInstanceAs(expected);
  }

  @Test
  void example5() {
    BinaryTreeNode original = BinaryTreeNode.fromLevelOrder(1, 2, null, 3);
    BinaryTreeNode cloned = BinaryTreeNode.fromLevelOrder(1, 2, null, 3);
    BinaryTreeNode target = original.left;
    BinaryTreeNode expected = cloned.left;

    assertThat(
            p1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.getTargetCopy(
                original, cloned, target))
        .isSameInstanceAs(expected);
  }
}
