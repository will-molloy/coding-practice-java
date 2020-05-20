package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-05-20. */
class P230KthSmallestElementInABstTest {

  @Test
  void example1() {
    assertThat(
            new P230KthSmallestElementInABst()
                .kthSmallest(BinaryTreeNode.fromLevelOrder(3, 1, 4, null, 2), 1))
        .isEqualTo(1);
  }

  @Test
  void example2() {
    assertThat(
            new P230KthSmallestElementInABst()
                .kthSmallest(BinaryTreeNode.fromLevelOrder(5, 3, 6, 2, 4, null, null, 1), 3))
        .isEqualTo(3);
  }
}
