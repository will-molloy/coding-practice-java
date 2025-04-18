package com.willmolloy.leetcode.problemset.concurrency.medium;

import java.util.concurrent.Semaphore;

/**
 * <a
 * href=https://leetcode.com/problems/print-foobar-alternately>https://leetcode.com/problems/print-foobar-alternately</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1115PrintFooBarAlternately {

  // initially allow foo thread to run
  private final Semaphore foo = new Semaphore(1);
  private final Semaphore bar = new Semaphore(0);

  private final int n;

  P1115PrintFooBarAlternately(int n) {
    this.n = n;
  }

  void foo(Runnable printFoo) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      foo.acquire();
      printFoo.run();
      bar.release();
    }
  }

  void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      bar.acquire();
      printBar.run();
      foo.release();
    }
  }
}
