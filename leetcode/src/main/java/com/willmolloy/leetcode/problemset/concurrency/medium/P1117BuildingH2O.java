package com.willmolloy.leetcode.problemset.concurrency.medium;

import java.util.concurrent.Semaphore;

/**
 * <a href=https://leetcode.com/problems/building-h2o>https://leetcode.com/problems/building-h2o</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Print in consistent manner to simplify the requirements.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1117BuildingH2O {

  // print [HHO -> HHO] etc. to keep it simple, although not a requirement

  // initially allow two hydrogen and zero oxygen threads to run
  private final Semaphore hydrogen = new Semaphore(2);
  private final Semaphore oxygen = new Semaphore(0);

  void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    hydrogen.acquire();
    releaseHydrogen.run();
    oxygen.release();
  }

  void oxygen(Runnable releaseOxygen) throws InterruptedException {
    oxygen.acquire(2);
    releaseOxygen.run();
    hydrogen.release(2);
  }
}
