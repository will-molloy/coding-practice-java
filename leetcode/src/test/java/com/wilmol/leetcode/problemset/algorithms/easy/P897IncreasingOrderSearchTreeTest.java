package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.Iterables;
import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * P897IncreasingOrderSearchTreeTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P897IncreasingOrderSearchTreeTest {

  @Test
  void example1() {
    BinaryTreeNode root =
        BinaryTreeNode.fromLevelOrder(
            5, 3, 6, 2, 4, null, 8, 1, null, null, null, null, null, 7, 9);

    BinaryTreeNode expectedRoot = new BinaryTreeNode(1);
    BinaryTreeNode expected = expectedRoot;
    for (int i : IntStream.rangeClosed(2, 9).toArray()) {
      expected.right = new BinaryTreeNode(i);
      expected = expected.right;
    }

    assertThat(new P897IncreasingOrderSearchTree().increasingBST(root)).isEqualTo(expectedRoot);
  }

  @Test
  void example2() {
    assertThat(
            new P897IncreasingOrderSearchTree()
                .increasingBST(BinaryTreeNode.fromLevelOrder(5, 1, 7)))
        .isEqualTo(BinaryTreeNode.fromLevelOrder(1, null, 5, null, null, null, 7));
  }
}
