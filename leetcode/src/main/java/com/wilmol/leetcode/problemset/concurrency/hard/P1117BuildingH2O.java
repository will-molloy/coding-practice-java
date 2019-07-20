package com.wilmol.leetcode.problemset.concurrency.hard;

import java.util.concurrent.Semaphore;

/**
 * Created by Will on 2019-07-20 at 13:34.
 *
 * <p><a
 * href=https://leetcode.com/problems/building-h2o>https://leetcode.com/problems/building-h2o</a>
 *
 * <p>Runtime: O(n)
 */
class P1117BuildingH2O {

  // initially allow two hydrogen and zero oxygen threads to run
  private final Semaphore hydrogen = new Semaphore(2);

  private final Semaphore oxygen = new Semaphore(0);

  void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    hydrogen.acquire();
    releaseHydrogen.run();
    if (hydrogen.availablePermits() == 0) {
      // have two hydrogens, need an oxygen
      oxygen.release();
    }
  }

  void oxygen(Runnable releaseOxygen) throws InterruptedException {
    oxygen.acquire();
    releaseOxygen.run();
    // have an oxygen, need two hyrogens
    hydrogen.release(2);
  }
}
