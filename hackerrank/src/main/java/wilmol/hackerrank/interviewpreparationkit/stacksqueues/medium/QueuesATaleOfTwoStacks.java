package wilmol.hackerrank.interviewpreparationkit.stacksqueues.medium;

import java.util.ArrayDeque;

/**
 * Created by wilmol on 2019-09-09.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues>https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues</a>
 */
final class QueuesATaleOfTwoStacks {

  private QueuesATaleOfTwoStacks() {}

  // Queue = FIFO, Stack = LIFO
  static class MyQueue<E> {
    // stack1, will hold incoming elements
    private final ArrayDeque<E> stack1 = new ArrayDeque<>();
    // stack2, will hold outgoing elements (i.e. in reversed order)
    private final ArrayDeque<E> stack2 = new ArrayDeque<>();

    public void enqueue(E e) {
      stack1.push(e);
    }

    public E dequeue() {
      rebalance();
      return stack2.pop();
    }

    private void rebalance() {
      // push all stack1 elements into stack2, reversing the element order
      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }
    }

    public E peek() {
      rebalance();
      return stack2.peek();
    }
  }
}
