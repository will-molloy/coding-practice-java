package com.wilmol.leetcode.problems.linkedlist.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/** Created by Will on 2019-06-23 at 20:49. */
class P2AddTwoNumbersTest {

  @Test
  void sameLength() {
    assertThat(new P2AddTwoNumbers().addTwoNumbers(ListNode.of(2, 4, 3), ListNode.of(5, 6, 4)))
        .isEqualTo(ListNode.of(7, 0, 8));
  }

  @Test
  void differentLengthsCarryIncreasesLength() {
    assertThat(
            new P2AddTwoNumbers()
                .addTwoNumbers(
                    ListNode.of(
                        1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
                        9, 9),
                    ListNode.of(9)))
        .isEqualTo(
            ListNode.of(
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                1));
  }

  @Test
  void integerOverflow() {
    assertThat(
            new P2AddTwoNumbers()
                .addTwoNumbers(
                    ListNode.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                    ListNode.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)))
        .isEqualTo(ListNode.of(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2));
  }
}