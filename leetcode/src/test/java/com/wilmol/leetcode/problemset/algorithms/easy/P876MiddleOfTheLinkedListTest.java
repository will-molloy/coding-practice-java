package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P876MiddleOfTheLinkedListTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P876MiddleOfTheLinkedListTest {

  private final P876MiddleOfTheLinkedList fun = new P876MiddleOfTheLinkedList();

  @Test
  void oddSize() {
    assertThat(fun.middleNode(ListNode.of(1, 2, 3, 4, 5))).isEqualTo(ListNode.of(3, 4, 5));
  }

  @Test
  void evenSize() {
    assertThat(fun.middleNode(ListNode.of(1, 2, 3, 4, 5, 6))).isEqualTo(ListNode.of(4, 5, 6));
  }

  @Test
  void empty() {
    assertThat(fun.middleNode(null)).isNull();
  }
}
