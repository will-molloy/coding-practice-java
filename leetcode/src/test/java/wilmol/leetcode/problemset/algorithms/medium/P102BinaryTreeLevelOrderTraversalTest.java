package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-02-11. */
class P102BinaryTreeLevelOrderTraversalTest {

  private final P102BinaryTreeLevelOrderTraversal fun = new P102BinaryTreeLevelOrderTraversal();

  @Test
  void example() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7);
    assertThat(fun.levelOrder(root))
        .containsExactly(ImmutableList.of(3), ImmutableList.of(9, 20), ImmutableList.of(15, 7))
        .inOrder();
  }
}
