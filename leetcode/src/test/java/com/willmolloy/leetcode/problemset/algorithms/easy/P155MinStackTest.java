package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P155MinStackTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P155MinStackTest {

  @Test
  void example() {
    P155MinStack minStack = new P155MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    assertThat(minStack.getMin()).isEqualTo(-3);
    minStack.pop();
    assertThat(minStack.top()).isEqualTo(0);
    assertThat(minStack.getMin()).isEqualTo(-2);
  }

  @Test
  void minimumIsDuplicated() {
    P155MinStack minStack = new P155MinStack();
    minStack.push(1);
    minStack.push(2);
    minStack.push(1);
    assertThat(minStack.getMin()).isEqualTo(1);
    minStack.pop();
    assertThat(minStack.getMin()).isEqualTo(1);
  }
}
