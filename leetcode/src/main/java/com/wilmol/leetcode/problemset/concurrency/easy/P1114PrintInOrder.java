package com.wilmol.leetcode.problemset.concurrency.easy;

/**
 * Created by will on 2019-07-17 at 8:57 PM.
 *
 * <p><a
 * href=https://leetcode.com/problems/print-in-order>https://leetcode.com/problems/print-in-order</a>
 *
 * <p>Runtime: O(1)
 */
class P1114PrintInOrder {

  private volatile int ran;

  void first(Runnable printFirst) {
    printFirst.run();
    ran = 1;
  }

  void second(Runnable printSecond) {
    while (ran < 1) {}
    printSecond.run();
    ran = 2;
  }

  void third(Runnable printThird) {
    while (ran < 2) {}
    printThird.run();
  }
}
