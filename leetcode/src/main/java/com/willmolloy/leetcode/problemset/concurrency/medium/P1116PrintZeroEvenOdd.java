package com.willmolloy.leetcode.problemset.concurrency.medium;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * <a
 * href=https://leetcode.com/problems/print-zero-even-odd>https://leetcode.com/problems/print-zero-even-odd</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1116PrintZeroEvenOdd {

  // initially allow zero thread to run
  private final Semaphore zero = new Semaphore(1);
  private final Semaphore odd = new Semaphore(0);
  private final Semaphore even = new Semaphore(0);

  private final int n;

  P1116PrintZeroEvenOdd(int n) {
    this.n = n;
  }

  void zero(IntConsumer printNumber) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      zero.acquire();
      printNumber.accept(0);
      if (i % 2 == 0) {
        odd.release();
      } else {
        even.release();
      }
    }
  }

  void odd(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i += 2) {
      odd.acquire();
      printNumber.accept(i);
      zero.release();
    }
  }

  void even(IntConsumer printNumber) throws InterruptedException {
    for (int i = 2; i <= n; i += 2) {
      even.acquire();
      printNumber.accept(i);
      zero.release();
    }
  }
}
