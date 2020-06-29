package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P19RemoveNthNodeFromEndOfListTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P19RemoveNthNodeFromEndOfListTest {

  private P19RemoveNthNodeFromEndOfList function = new P19RemoveNthNodeFromEndOfList();

  @Test
  void example() {
    assertThat(function.removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 2))
        .isEqualTo(ListNode.of(1, 2, 3, 5));
  }

  @Test
  void singleNode() {
    assertThat(function.removeNthFromEnd(ListNode.of(1), 1)).isNull();
  }

  @Test
  void removeHead() {
    assertThat(function.removeNthFromEnd(ListNode.of(1, 2, 3, 4), 4))
        .isEqualTo(ListNode.of(2, 3, 4));
  }

  @Test
  void removeLast() {
    assertThat(function.removeNthFromEnd(ListNode.of(1, 2, 3, 4), 1))
        .isEqualTo(ListNode.of(1, 2, 3));
  }
}
