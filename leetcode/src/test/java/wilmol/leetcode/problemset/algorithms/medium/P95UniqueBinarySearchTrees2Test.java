package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-03-02. */
class P95UniqueBinarySearchTrees2Test {

  private final P95UniqueBinarySearchTrees2 fun = new P95UniqueBinarySearchTrees2();

  @Test
  void example() {
    assertThat(fun.generateTrees(3))
        .containsExactly(
            BinaryTreeNode.fromLevelOrder(1, null, 3, null, null, 2),
            BinaryTreeNode.fromLevelOrder(3, 2, null, 1),
            BinaryTreeNode.fromLevelOrder(3, 1, null, null, 2),
            BinaryTreeNode.fromLevelOrder(2, 1, 3),
            BinaryTreeNode.fromLevelOrder(1, null, 2, null, null, null, 3));
  }

  @Test
  void zero() {
    assertThat(fun.generateTrees(0)).isEmpty();
  }

  @Test
  void one() {
    assertThat(fun.generateTrees(1)).containsExactly(new BinaryTreeNode(1));
  }
}
