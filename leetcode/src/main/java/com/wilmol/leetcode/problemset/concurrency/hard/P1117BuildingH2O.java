package com.wilmol.leetcode.problemset.concurrency.hard;

/**
 * Created by Will on 2019-07-20 at 13:34.
 *
 * <p><a
 * href=https://leetcode.com/problems/building-h2o>https://leetcode.com/problems/building-h2o</a>
 *
 * <p>Runtime: O(n)
 */
class P1117BuildingH2O {

  private volatile int state;

  // do HHO -> HHO always to keep simpler ???
  synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    while (state == 2) {
      wait();
    }
    releaseHydrogen.run();
    next();
    notifyAll();
  }

  private synchronized void next() {
    state = (state + 1) % 3;
  }

  synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
    while (state != 2) {
      wait();
    }
    releaseOxygen.run();
    next();
    notifyAll();
  }
}
