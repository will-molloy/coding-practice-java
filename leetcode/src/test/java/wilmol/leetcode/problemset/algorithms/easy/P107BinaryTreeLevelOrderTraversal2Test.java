package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-02-12. */
class P107BinaryTreeLevelOrderTraversal2Test {

  private final P107BinaryTreeLevelOrderTraversal2 fun = new P107BinaryTreeLevelOrderTraversal2();

  @Test
  void example() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7);
    assertThat(fun.levelOrderBottom(root))
        .containsExactly(ImmutableList.of(15, 7), ImmutableList.of(9, 20), ImmutableList.of(3))
        .inOrder();
  }
}
