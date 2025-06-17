package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P1609EvenOddTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1609EvenOddTreeTest {

  private final P1609EvenOddTree p1609 = new P1609EvenOddTree();

  @Test
  void example1() {
    assertThat(
            p1609.isEvenOddTree(
                TreeNode.fromLevelOrder(1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2)))
        .isTrue();
  }

  @Test
  void example2() {
    assertThat(p1609.isEvenOddTree(TreeNode.fromLevelOrder(5, 4, 2, 3, 3, 7))).isFalse();
  }

  @Test
  void example3() {
    assertThat(p1609.isEvenOddTree(TreeNode.fromLevelOrder(5, 9, 1, 3, 5, 7))).isFalse();
  }

  @Test
  void example4() {
    assertThat(p1609.isEvenOddTree(TreeNode.fromLevelOrder(1))).isTrue();
  }

  @Test
  void example5() {
    assertThat(
            p1609.isEvenOddTree(
                TreeNode.fromLevelOrder(11, 8, 6, 1, 3, 9, 11, 30, 20, 18, 16, 12, 10, 4, 2, 17)))
        .isTrue();
  }
}
