package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P25ReverseNodesInKGroupTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P25ReverseNodesInKGroupTest {

  private final P25ReverseNodesInKGroup fun = new P25ReverseNodesInKGroup();

  @Test
  void exampleKOf2FitsTwice() {
    assertThat(fun.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 2))
        .isEqualTo(ListNode.of(2, 1, 4, 3, 5));
  }

  @Test
  void exampleKOf3LeftOutNodesRemainAsIs() {
    assertThat(fun.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 3))
        .isEqualTo(ListNode.of(3, 2, 1, 4, 5));
  }

  @Test
  void kOf5FitsOnce() {
    assertThat(fun.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 5))
        .isEqualTo(ListNode.of(5, 4, 3, 2, 1));
  }

  @Test
  void kOf1() {
    assertThat(fun.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 1))
        .isEqualTo(ListNode.of(1, 2, 3, 4, 5));
  }

  @Test
  void noNodes() {
    assertThat(fun.reverseKGroup(null, 2)).isEqualTo(null);
  }
}
