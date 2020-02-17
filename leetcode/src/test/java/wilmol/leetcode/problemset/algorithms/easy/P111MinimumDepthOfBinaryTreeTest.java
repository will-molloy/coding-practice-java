package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-02-17. */
class P111MinimumDepthOfBinaryTreeTest {

  private final P111MinimumDepthOfBinaryTree fun = new P111MinimumDepthOfBinaryTree();

  @Test
  void example() {
    assertThat(fun.minDepth(BinaryTreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7)))
        .isEqualTo(2);
  }

  @Test
  void emptyTree() {
    assertThat(fun.minDepth(null)).isEqualTo(0);
  }

  @Test
  void singleNode() {
    assertThat(fun.minDepth(BinaryTreeNode.fromLevelOrder(1))).isEqualTo(1);
  }

  @Test
  void twoNodes() {
    assertThat(fun.minDepth(BinaryTreeNode.fromLevelOrder(1, 2))).isEqualTo(2);
  }
}
