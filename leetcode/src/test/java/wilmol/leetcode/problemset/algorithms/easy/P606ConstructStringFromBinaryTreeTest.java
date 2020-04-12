package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-04-13. */
class P606ConstructStringFromBinaryTreeTest {

  private final P606ConstructStringFromBinaryTree fun = new P606ConstructStringFromBinaryTree();

  @Test
  void example1() {
    assertThat(fun.tree2str(BinaryTreeNode.fromLevelOrder(1, 2, 3, 4))).isEqualTo("1(2(4))(3)");
  }

  @Test
  void example2() {
    assertThat(fun.tree2str(BinaryTreeNode.fromLevelOrder(1, 2, 3, null, 4)))
        .isEqualTo("1(2()(4))(3)");
  }
}
