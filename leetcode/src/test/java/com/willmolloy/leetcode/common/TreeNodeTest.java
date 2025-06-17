package com.willmolloy.leetcode.common;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.common.testing.EqualsTester;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit tests for {@link TreeNode}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class TreeNodeTest {

  @ParameterizedTest
  @MethodSource
  void testToString(TreeNode root, String expected) {
    assertThat(root.toString()).isEqualTo(expected);
  }

  static Stream<Arguments> testToString() {
    return Stream.of(
        Arguments.of(singleNode(), "TreeNode[1]"),
        Arguments.of(fullTree(), "TreeNode[1, 2, 3, 4, 5, 6, 7]"),
        Arguments.of(sparseTree(), "TreeNode[1, 2, 3, 4, null, null, 5, null, 6, 7]"),
        Arguments.of(singleNodeFactory(), "TreeNode[1]"),
        Arguments.of(fullTreeFactory(), "TreeNode[1, 2, 3, 4, 5, 6, 7]"),
        Arguments.of(sparseTreeFactory(), "TreeNode[1, 2, 3, 4, null, null, 5, null, 6, 7]"));
  }

  @Test
  void testEqualsAndStaticFactory() {
    new EqualsTester()
        .addEqualityGroup(singleNode(), singleNodeFactory())
        .addEqualityGroup(fullTree(), fullTreeFactory())
        .addEqualityGroup(sparseTree(), sparseTreeFactory())
        .testEquals();
  }

  @Test
  void testStaticFactoryThrowsIaeIfUnreachableNodes() {
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class, () -> TreeNode.fromLevelOrder2(1, null, null, 2));
    assertThat(thrown).hasMessageThat().isEqualTo("Expected all nodes to be reachable.");
  }

  private static TreeNode singleNode() {
    return new TreeNode(1);
  }

  private static TreeNode singleNodeFactory() {
    return TreeNode.fromLevelOrder2(1);
  }

  private static TreeNode fullTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    return root;
  }

  private static TreeNode fullTreeFactory() {
    return TreeNode.fromLevelOrder2(1, 2, 3, 4, 5, 6, 7);
  }

  private static TreeNode sparseTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    root.left.left.right = new TreeNode(6);
    root.right.right.left = new TreeNode(7);
    return root;
  }

  private static TreeNode sparseTreeFactory() {
    return TreeNode.fromLevelOrder2(1, 2, 3, 4, null, null, 5, null, 6, 7);
  }
}
