package com.willmolloy.leetcode.problemset.concurrency.easy;

import java.util.concurrent.CountDownLatch;

/**
 * <a
 * href=https://leetcode.com/problems/print-in-order>https://leetcode.com/problems/print-in-order</a>
 *
 * <p>Runtime: O(1)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1114PrintInOrder {

  private final CountDownLatch first = new CountDownLatch(1);
  private final CountDownLatch second = new CountDownLatch(1);

  void first(Runnable printFirst) {
    printFirst.run();
    first.countDown();
  }

  void second(Runnable printSecond) throws InterruptedException {
    first.await();
    printSecond.run();
    second.countDown();
  }

  void third(Runnable printThird) throws InterruptedException {
    second.await();
    printThird.run();
  }
}
