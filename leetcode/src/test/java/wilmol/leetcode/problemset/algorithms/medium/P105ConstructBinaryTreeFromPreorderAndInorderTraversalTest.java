package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-03-06. */
class P105ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

  private final P105ConstructBinaryTreeFromPreorderAndInorderTraversal fun =
      new P105ConstructBinaryTreeFromPreorderAndInorderTraversal();

  @Test
  void example() {
    assertThat(fun.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7}))
        .isEqualTo(BinaryTreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7));
  }
}
