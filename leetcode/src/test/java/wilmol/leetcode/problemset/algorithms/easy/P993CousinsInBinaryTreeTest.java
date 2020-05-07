package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-05-07. */
class P993CousinsInBinaryTreeTest {

  private final P993CousinsInBinaryTree p993 = new P993CousinsInBinaryTree();

  @Test
  void example1() {
    assertThat(p993.isCousins(BinaryTreeNode.fromLevelOrder(1, 2, 3, 4), 4, 3)).isFalse();
  }

  @Test
  void example2() {
    assertThat(p993.isCousins(BinaryTreeNode.fromLevelOrder(1, 2, 3, null, 4, null, 5), 5, 4))
        .isTrue();
  }

  @Test
  void example3() {
    assertThat(p993.isCousins(BinaryTreeNode.fromLevelOrder(1, 2, 3, null, 4), 2, 3)).isFalse();
  }
}
