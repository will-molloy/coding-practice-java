package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-05-08. */
class P965UnivaluedBinaryTreeTest {

  private final P965UnivaluedBinaryTree p965 = new P965UnivaluedBinaryTree();

  @Test
  void example1() {
    assertThat(p965.isUnivalTree(BinaryTreeNode.fromLevelOrder(1, 1, 1, 1, 1, null, 1))).isTrue();
  }

  @Test
  void example2() {
    assertThat(p965.isUnivalTree(BinaryTreeNode.fromLevelOrder(2, 2, 2, 5, 2))).isFalse();
  }
}
