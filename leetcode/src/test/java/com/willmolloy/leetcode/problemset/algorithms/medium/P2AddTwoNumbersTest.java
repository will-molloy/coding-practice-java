package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P2AddTwoNumbersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P2AddTwoNumbersTest {

  private final P2AddTwoNumbers function = new P2AddTwoNumbers();

  @Test
  void sameLength() {
    assertThat(function.addTwoNumbers(ListNode.of(2, 4, 3), ListNode.of(5, 6, 4)))
        .isEqualTo(ListNode.of(7, 0, 8));
  }

  @Test
  void differentLengthsCarryIncreasesLength() {
    assertThat(
            function.addTwoNumbers(
                ListNode.of(
                    1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
                    9),
                ListNode.of(9)))
        .isEqualTo(
            ListNode.of(
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                1));
  }

  @Test
  void integerOverflow() {
    assertThat(
            function.addTwoNumbers(
                ListNode.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                ListNode.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)))
        .isEqualTo(ListNode.of(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2));
  }
}
