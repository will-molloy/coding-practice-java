package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P687LongestUnivaluePathTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P687LongestUnivaluePathTest {

  private final P687LongestUnivaluePath p687 = new P687LongestUnivaluePath();

  @Test
  void example1() {
    assertThat(p687.longestUnivaluePath(BinaryTreeNode.fromLevelOrder(5, 4, 5, 1, 1, null, 5)))
        .isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(p687.longestUnivaluePath(BinaryTreeNode.fromLevelOrder(1, 4, 5, 4, 4, null, 5)))
        .isEqualTo(2);
  }

  @Test
  void noPaths() {
    assertThat(p687.longestUnivaluePath(BinaryTreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6, 7)))
        .isEqualTo(0);
  }

  @Test
  void pathLeft() {
    assertThat(p687.longestUnivaluePath(BinaryTreeNode.fromLevelOrder(1, 1, 3, 4, 5, 6, 7)))
        .isEqualTo(1);
  }

  @Test
  void pathRight() {
    assertThat(p687.longestUnivaluePath(BinaryTreeNode.fromLevelOrder(1, 2, 1, 4, 5, 6, 7)))
        .isEqualTo(1);
  }

  @Test
  void pathLeftAndRight() {
    assertThat(p687.longestUnivaluePath(BinaryTreeNode.fromLevelOrder(1, 1, 1, 4, 5, 6, 7)))
        .isEqualTo(2);
  }

  @Test
  void pathCanOnlyGoUpAndDownThroughOneNode() {
    assertThat(p687.longestUnivaluePath(BinaryTreeNode.fromLevelOrder(1, 1, 1, 1, 1, 1, 1)))
        .isEqualTo(4);
  }
}
