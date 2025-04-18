package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P622DesignCircularQueueTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P622DesignCircularQueueTest {

  @Test
  void example() {
    P622DesignCircularQueue.MyCircularQueue myCircularQueue =
        new P622DesignCircularQueue.MyCircularQueue(3);

    assertThat(myCircularQueue.enQueue(1)).isTrue();
    assertThat(myCircularQueue.enQueue(2)).isTrue();
    assertThat(myCircularQueue.enQueue(3)).isTrue();
    assertThat(myCircularQueue.enQueue(4)).isFalse();
    assertThat(myCircularQueue.rear()).isEqualTo(3);
    assertThat(myCircularQueue.isFull()).isTrue();
    assertThat(myCircularQueue.deQueue()).isTrue();
    assertThat(myCircularQueue.enQueue(4)).isTrue();
    assertThat(myCircularQueue.rear()).isEqualTo(4);
  }
}
