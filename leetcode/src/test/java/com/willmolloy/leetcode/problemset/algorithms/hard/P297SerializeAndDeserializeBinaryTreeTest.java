package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P297SerializeAndDeserializeBinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P297SerializeAndDeserializeBinaryTreeTest {

  private final P297SerializeAndDeserializeBinaryTree p297 =
      new P297SerializeAndDeserializeBinaryTree();

  @Test
  void example() {
    TreeNode asTree = TreeNode.fromLevelOrder(1, 2, 3, null, null, 4, 5);
    String asString = "1(2)(3(4)(5))";
    assertThat(p297.serialize(asTree)).isEqualTo("1(2)(3(4)(5))");
    assertThat(p297.deserialize(asString)).isEqualTo(asTree);
  }
}
