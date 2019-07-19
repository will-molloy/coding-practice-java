package com.wilmol.leetcode.problemset.concurrency.medium;

import java.util.function.IntConsumer;

/**
 * Created by Will on 2019-07-19 at 20:58.
 *
 * <p><a
 * href=https://leetcode.com/problems/print-zero-even-odd>https://leetcode.com/problems/print-zero-even-odd</a>
 *
 * <p>Runtime: O(n)
 */
class P1116PrintZeroEvenOdd {

  private final int n;

  private volatile int state;

  P1116PrintZeroEvenOdd(int n) {
    this.n = n;
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  synchronized void zero(IntConsumer printNumber) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      while (state != 0 && state != 2) {
        wait();
      }
      printNumber.accept(0);
      next();
      notifyAll();
    }
  }

  private synchronized void next() {
    state = (state + 1) % 4;
  }

  synchronized void odd(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i += 2) {
      while (state != 1) {
        wait();
      }
      printNumber.accept(i);
      next();
      notifyAll();
    }
  }

  synchronized void even(IntConsumer printNumber) throws InterruptedException {
    for (int i = 2; i <= n; i += 2) {
      while (state != 3) {
        wait();
      }
      printNumber.accept(i);
      next();
      notifyAll();
    }
  }
}
