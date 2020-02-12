package wilmol.leetcode.common;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-02-12. */
class BinaryTreeNodeTest {

  @Test
  void testToStringFullTree() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6, 7);
    assertThat(root.toString()).isEqualTo("[1, 2, 3, 4, 5, 6, 7]");
  }

  @Test
  void testToStringSparseTree() {
    BinaryTreeNode root =
        BinaryTreeNode.fromLevelOrder(
            1, 2, 3, 4, null, null, 5, null, null, null, null, null, null, 6, 7);
    assertThat(root.toString())
        .isEqualTo("[1, 2, 3, 4, null, null, 5, null, null, null, null, null, null, 6, 7]");
  }
}
