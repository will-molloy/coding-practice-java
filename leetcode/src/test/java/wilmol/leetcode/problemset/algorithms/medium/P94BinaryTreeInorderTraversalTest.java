package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-02-09. */
class P94BinaryTreeInorderTraversalTest {

  private final P94BinaryTreeInorderTraversal func = new P94BinaryTreeInorderTraversal();

  @Test
  void example() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(1, null, 2, null, null, 3);
    assertThat(func.inorderTraversal(root)).containsExactly(1, 3, 2).inOrder();
  }

  @Test
  void threeLevels() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6, 7);
    assertThat(func.inorderTraversal(root)).containsExactly(4, 2, 5, 1, 6, 3, 7).inOrder();
  }
}
