package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P445AddTwoNumbers2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P445AddTwoNumbers2Test {

  private final P445AddTwoNumbers2 p445 = new P445AddTwoNumbers2();

  @Test
  void example() {
    assertThat(p445.addTwoNumbers(ListNode.of(7, 2, 4, 3), ListNode.of(5, 6, 4)))
        .isEqualTo(ListNode.of(7, 8, 0, 7));
  }
}
