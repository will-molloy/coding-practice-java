package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-02-10. */
class P100SameTreeTest {

  private final P100SameTree func = new P100SameTree();

  @Test
  void example1() {
    BinaryTreeNode p = BinaryTreeNode.fromLevelOrder(1, 2, 3);
    BinaryTreeNode q = BinaryTreeNode.fromLevelOrder(1, 2, 3);

    assertThat(func.isSameTree(p, q)).isTrue();
  }

  @Test
  void example2() {
    BinaryTreeNode p = BinaryTreeNode.fromLevelOrder(1, 2);
    BinaryTreeNode q = BinaryTreeNode.fromLevelOrder(1, null, 2);

    assertThat(func.isSameTree(p, q)).isFalse();
  }

  @Test
  void example3() {
    BinaryTreeNode p = BinaryTreeNode.fromLevelOrder(1, 2, 1);
    BinaryTreeNode q = BinaryTreeNode.fromLevelOrder(1, 1, 2);

    assertThat(func.isSameTree(p, q)).isFalse();
  }
}