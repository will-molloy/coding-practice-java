package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-04-08. */
class P222CountCompleteTreeNodesTest {

  private final P222CountCompleteTreeNodes fun = new P222CountCompleteTreeNodes();

  @Test
  void notFullTree() {
    assertThat(fun.countNodes(BinaryTreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6))).isEqualTo(6);
  }

  @Test
  void fullTree() {
    assertThat(fun.countNodes(BinaryTreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6, 7))).isEqualTo(7);
  }

  @Test
  void oneNode() {
    assertThat(fun.countNodes(BinaryTreeNode.fromLevelOrder(1))).isEqualTo(1);
  }

  @Test
  void noNodes() {
    assertThat(fun.countNodes(null)).isEqualTo(0);
  }
}
