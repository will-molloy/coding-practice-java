package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * P897IncreasingOrderSearchTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P897IncreasingOrderSearchTreeTest {

  @Test
  void example1() {
    TreeNode root =
        TreeNode.fromLevelOrder(5, 3, 6, 2, 4, null, 8, 1, null, null, null, null, null, 7, 9);

    TreeNode expectedRoot = new TreeNode(1);
    TreeNode expected = expectedRoot;
    for (int i : IntStream.rangeClosed(2, 9).toArray()) {
      expected.right = new TreeNode(i);
      expected = expected.right;
    }

    assertThat(new P897IncreasingOrderSearchTree().increasingBST(root)).isEqualTo(expectedRoot);
  }

  @Test
  void example2() {
    assertThat(new P897IncreasingOrderSearchTree().increasingBST(TreeNode.fromLevelOrder(5, 1, 7)))
        .isEqualTo(TreeNode.fromLevelOrder(1, null, 5, null, null, null, 7));
  }
}
