package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-03-06. */
class P106ConstructBinaryTreeFromInorderAndPostorderTraversalTest {

  private final P106ConstructBinaryTreeFromInorderAndPostorderTraversal fun =
      new P106ConstructBinaryTreeFromInorderAndPostorderTraversal();

  @Test
  void example() {
    assertThat(fun.buildTree(new int[] {9, 3, 15, 20, 7}, new int[] {9, 15, 7, 20, 3}))
        .isEqualTo(BinaryTreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7));
  }
}
