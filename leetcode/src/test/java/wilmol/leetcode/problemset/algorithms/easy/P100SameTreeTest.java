package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-02-10. */
class P100SameTreeTest {

  private final P100SameTree func = new P100SameTree();

  @Test
  void example1() {
    BinaryTreeNode p = new BinaryTreeNode(1);
    p.left = new BinaryTreeNode(2);
    p.right = new BinaryTreeNode(3);
    BinaryTreeNode q = new BinaryTreeNode(1);
    q.left = new BinaryTreeNode(2);
    q.right = new BinaryTreeNode(3);

    assertThat(func.isSameTree(p, q)).isTrue();
  }

  @Test
  void example2() {
    BinaryTreeNode p = new BinaryTreeNode(1);
    p.left = new BinaryTreeNode(2);
    BinaryTreeNode q = new BinaryTreeNode(1);
    q.right = new BinaryTreeNode(2);

    assertThat(func.isSameTree(p, q)).isFalse();
  }

  @Test
  void example3() {
    BinaryTreeNode p = new BinaryTreeNode(1);
    p.left = new BinaryTreeNode(2);
    p.right = new BinaryTreeNode(1);
    BinaryTreeNode q = new BinaryTreeNode(1);
    q.left = new BinaryTreeNode(1);
    q.right = new BinaryTreeNode(2);

    assertThat(func.isSameTree(p, q)).isFalse();
  }
}
