package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P61RotateListTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P61RotateListTest {

  private final P61RotateList fun = new P61RotateList();

  @Test
  void example() {
    ListNode input = ListNode.of(1, 2, 3, 4, 5);
    ListNode expectedOutput = ListNode.of(4, 5, 1, 2, 3);
    assertThat(fun.rotateRight(input, 2)).isEqualTo(expectedOutput);
  }

  @Test
  void empty() {
    assertThat(fun.rotateRight(null, 500)).isNull();
  }

  @Test
  void kGreaterThanN() {
    ListNode input = ListNode.of(0, 1, 2);
    ListNode expectedOutput = ListNode.of(2, 0, 1);
    assertThat(fun.rotateRight(input, 4)).isEqualTo(expectedOutput);
  }

  @Test
  void kEqualN() {
    ListNode input = ListNode.of(0, 1, 2);
    ListNode expectedOutput = ListNode.of(0, 1, 2);
    assertThat(fun.rotateRight(input, 3)).isEqualTo(expectedOutput);
  }
}
