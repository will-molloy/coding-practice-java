package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P1290ConvertBinaryNumberInALinkedListToIntegerTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1290ConvertBinaryNumberInALinkedListToIntegerTest {

  private final P1290ConvertBinaryNumberInALinkedListToInteger fun =
      new P1290ConvertBinaryNumberInALinkedListToInteger();

  @Test
  void example1() {
    assertThat(fun.getDecimalValue(ListNode.of(1, 0, 1))).isEqualTo(5);
  }

  @Test
  void example2() {
    assertThat(fun.getDecimalValue(ListNode.of(0))).isEqualTo(0);
  }

  @Test
  void example3() {
    assertThat(fun.getDecimalValue(ListNode.of(1))).isEqualTo(1);
  }

  @Test
  void example4() {
    assertThat(fun.getDecimalValue(ListNode.of(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0)))
        .isEqualTo(18880);
  }

  @Test
  void example5() {
    assertThat(fun.getDecimalValue(ListNode.of(0, 0))).isEqualTo(0);
  }
}
