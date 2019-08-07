package wilmol.leetcode.problemset.concurrency.easy;

import java.util.concurrent.CountDownLatch;

/**
 * Created by will on 2019-07-17 at 8:57 PM.
 *
 * <p><a
 * href=https://leetcode.com/problems/print-in-order>https://leetcode.com/problems/print-in-order</a>
 *
 * <p>Runtime: O(1)
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
