package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.ListNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P234PalindromeLinkedListTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P234PalindromeLinkedListTest {

  private final P234PalindromeLinkedList p234PalindromeLinkedList = new P234PalindromeLinkedList();

  @ParameterizedTest
  @MethodSource
  void examples(ListNode head, boolean expected) {
    assertThat(p234PalindromeLinkedList.isPalindrome(head)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(ListNode.of(1, 2, 2, 1), true), Arguments.of(ListNode.of(1, 2), false));
  }
}
