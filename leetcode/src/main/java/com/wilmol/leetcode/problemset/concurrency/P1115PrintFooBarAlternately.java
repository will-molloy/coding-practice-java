package com.wilmol.leetcode.problemset.concurrency;

/**
 * Created by Will on 2019-07-18 at 21:45.
 *
 * <p><a
 * href=https://leetcode.com/problems/print-foobar-alternately>https://leetcode.com/problems/print-foobar-alternately</a>
 *
 * <p>Runtime: O(n) TODO why does it need object wait/notify methods and synchronised? Get time
 * limit exceeded otherwise.
 */
class P1115PrintFooBarAlternately {

  private volatile boolean calledFoo;

  private final int n;

  P1115PrintFooBarAlternately(int n) {
    this.n = n;
  }

  synchronized void foo(Runnable printFoo) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      while (calledFoo) {
        wait();
      }
      printFoo.run();
      calledFoo = true;
      notifyAll();
    }
  }

  synchronized void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      while (!calledFoo) {
        wait();
      }
      printBar.run();
      calledFoo = false;
      notifyAll();
    }
  }
}
