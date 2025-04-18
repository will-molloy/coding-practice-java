package com.willmolloy.leetcode.common;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link TreeNode}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class TreeNodeTest {

  @Test
  void testToStringFullTree() {
    TreeNode root = TreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6, 7);
    assertThat(root.toString()).isEqualTo("TreeNode[1, 2, 3, 4, 5, 6, 7]");
  }

  @Test
  void testToStringSparseTree() {
    TreeNode root =
        TreeNode.fromLevelOrder(1, 2, 3, 4, null, null, 5, null, 6, null, null, null, null, 7);
    assertThat(root.toString())
        .isEqualTo("TreeNode[1, 2, 3, 4, null, null, 5, null, 6, null, null, null, null, 7]");
  }

  @Test
  void testStaticFactoryThrowsIaeIfUnreachableNodes() {
    IllegalArgumentException thrown =
        assertThrows(
            // 4 has no parent
            IllegalArgumentException.class, () -> TreeNode.fromLevelOrder(1, null, 3, 4));
    assertThat(thrown).hasMessageThat().isEqualTo("Expected all nodes to be reachable");
  }

  @Test
  void testEqualsAndStaticFactory() {
    TreeNode fullTree = new TreeNode(1);
    fullTree.left = new TreeNode(2);
    fullTree.right = new TreeNode(3);
    fullTree.left.left = new TreeNode(4);
    fullTree.left.right = new TreeNode(5);
    fullTree.right.left = new TreeNode(6);
    fullTree.right.right = new TreeNode(7);

    TreeNode sparseTree = new TreeNode(1);
    sparseTree.left = new TreeNode(2);
    sparseTree.right = new TreeNode(3);
    sparseTree.left.left = new TreeNode(4);
    sparseTree.right.right = new TreeNode(5);
    sparseTree.left.left.right = new TreeNode(6);
    sparseTree.right.right.left = new TreeNode(7);

    new EqualsTester()
        .addEqualityGroup(new TreeNode(1), new TreeNode(1))
        .addEqualityGroup(fullTree, TreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6, 7))
        .addEqualityGroup(
            sparseTree,
            TreeNode.fromLevelOrder(1, 2, 3, 4, null, null, 5, null, 6, null, null, null, null, 7))
        .testEquals();
  }
}
