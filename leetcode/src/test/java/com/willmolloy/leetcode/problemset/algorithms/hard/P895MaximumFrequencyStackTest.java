package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P895MaximumFrequencyStackTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P895MaximumFrequencyStackTest {

  @Test
  void example() {
    P895MaximumFrequencyStack.FreqStack freqStack = new P895MaximumFrequencyStack.FreqStack();

    freqStack.push(5);
    freqStack.push(7);
    freqStack.push(5);
    freqStack.push(7);
    freqStack.push(4);
    freqStack.push(5);

    assertThat(freqStack.pop()).isEqualTo(5);
    assertThat(freqStack.pop()).isEqualTo(7);
    assertThat(freqStack.pop()).isEqualTo(5);
    assertThat(freqStack.pop()).isEqualTo(4);
    assertThat(freqStack.pop()).isEqualTo(7);
    assertThat(freqStack.pop()).isEqualTo(5);
  }
}
