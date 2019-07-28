package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by Will on 2019-03-30 at 21:43. */
class P226InvertBinaryTreeTest {

  @Test
  void example() {
    BinaryTreeNode input = BinaryTreeNode.fromLevelOrder(4, 2, 7, 1, 3, 6, 9);
    BinaryTreeNode output = new P226InvertBinaryTree().invertTree(input);
    assertThat(output).isEqualTo(BinaryTreeNode.fromLevelOrder(4, 7, 2, 9, 6, 3, 1));
  }
}
