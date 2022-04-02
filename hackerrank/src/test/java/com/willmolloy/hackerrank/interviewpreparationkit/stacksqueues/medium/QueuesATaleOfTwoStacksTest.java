package com.willmolloy.hackerrank.interviewpreparationkit.stacksqueues.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.hackerrank.interviewpreparationkit.stacksqueues.medium.QueuesATaleOfTwoStacks.MyQueue;
import org.junit.jupiter.api.Test;

/**
 * QueuesATaleOfTwoStacksTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class QueuesATaleOfTwoStacksTest {

  // TODO more than 1 test

  @Test
  void sample1() {
    MyQueue<Integer> queue = new MyQueue<>();
    queue.enqueue(35);
    queue.enqueue(15);
    assertThat(queue.peek()).isEqualTo(35);
    assertThat(queue.dequeue()).isEqualTo(35);
    assertThat(queue.peek()).isEqualTo(15);
    assertThat(queue.dequeue()).isEqualTo(15);
  }
}
