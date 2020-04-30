package wilmol.leetcode.problemset.algorithms.unknown;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-05-01. */
class CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTreeTest {

  private final CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree fun =
      new CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree();

  @Test
  void example1() {
    assertThat(
            fun.isValidSequence(
                BinaryTreeNode.fromLevelOrder(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0),
                new int[] {0, 1, 0, 1}))
        .isTrue();
  }

  @Test
  void example2() {
    // seq doesn't exist
    assertThat(
            fun.isValidSequence(
                BinaryTreeNode.fromLevelOrder(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0),
                new int[] {0, 0, 1}))
        .isFalse();
  }

  @Test
  void example3() {
    // seq doesn't end with leaf
    assertThat(
            fun.isValidSequence(
                BinaryTreeNode.fromLevelOrder(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0),
                new int[] {0, 1, 1}))
        .isFalse();
  }

  @Test
  void singleNodeValid() {
    assertThat(fun.isValidSequence(BinaryTreeNode.fromLevelOrder(1), new int[] {1})).isTrue();
  }

  @Test
  void singleNodeInvalid() {
    assertThat(fun.isValidSequence(BinaryTreeNode.fromLevelOrder(1, 2), new int[] {1})).isFalse();
  }

  @Test
  void requiredSeqLongerThanTreeDepth() {
    assertThat(fun.isValidSequence(BinaryTreeNode.fromLevelOrder(1, 2, 3), new int[] {1, 2, 3, 4}))
        .isFalse();
  }
}
