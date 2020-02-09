package wilmol.leetcode.problemset.concurrency.medium;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * Created by wilmol on 2019-09-20.
 *
 * <p><a
 * href=https://leetcode.com/problems/fizz-buzz-multithreaded>https://leetcode.com/problems/fizz-buzz-multithreaded</a>
 *
 * <p>Runtime: O(n) (all solutions)
 */
interface P1195FizzBuzzMultithreaded {

  void fizz(Runnable printFizz) throws InterruptedException;

  void buzz(Runnable printBuzz) throws InterruptedException;

  void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException;

  void number(IntConsumer printNumber) throws InterruptedException;

  /**
   * wait/notify/synchronised (primitive) solution.
   *
   * <p>Key: outer loop to ensure thread keeps running and the exit condition.
   */
  class WaitNotifySolution implements P1195FizzBuzzMultithreaded {

    private final int n;

    private int state = 1;

    WaitNotifySolution(int n) {
      this.n = n;
    }

    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
      while (state <= n) {
        if (!(state % 3 == 0 && state % 5 != 0)) {
          wait();
          continue; // force while loop condition to be rechecked
        }
        printFizz.run();
        state++;
        notifyAll();
      }
    }

    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
      while (state <= n) {
        if (!(state % 3 != 0 && state % 5 == 0)) {
          wait();
          continue; // force while loop condition to be rechecked
        }
        printBuzz.run();
        state++;
        notifyAll();
      }
    }

    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
      while (state <= n) {
        if (!(state % 3 == 0 && state % 5 == 0)) {
          wait();
          continue; // force while loop condition to be rechecked
        }
        printFizzBuzz.run();
        state++;
        notifyAll();
      }
    }

    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
      while (state <= n) {
        if (!(state % 3 != 0 && state % 5 != 0)) {
          wait();
          continue; // force while loop condition to be rechecked
        }
        printNumber.accept(state);
        state++;
        notifyAll();
      }
    }
  }

  /**
   * {@link ReentrantLock} solution. Very similar to {@link WaitNotifySolution} but more elegant as
   * the synchronisation is hidden and idea of 'wait' flipped.
   *
   * <p><a
   * href=https://leetcode.com/problems/fizz-buzz-multithreaded/discuss/386267/Java-ReentrantLock>https://leetcode.com/problems/fizz-buzz-multithreaded/discuss/386267/Java-ReentrantLock</a>
   *
   * <p>Not the best solution (although elegant). Since it is random which thread obtains the lock,
   * the conditions may fail several times before the correct thread gains the lock. I.e. there is
   * not much control in this solution, the {@link SemaphoreSolution} has such control.
   *
   * <p>Key: obtain the lock before checking the condition.
   */
  class ReentrantLockSolution implements P1195FizzBuzzMultithreaded {

    private final int n;

    private final ReentrantLock lock = new ReentrantLock();

    private int state = 1;

    ReentrantLockSolution(int n) {
      this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
      while (state <= n) {
        // the correct idiom for using a JSR-166 lock is within try-finally
        lock.lock();
        try {
          if (state <= n && state % 3 == 0 && state % 5 != 0) {
            printFizz.run();
            state++;
          }
        } finally {
          lock.unlock();
        }
      }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
      while (state <= n) {
        lock.lock();
        try {
          if (state <= n && state % 3 != 0 && state % 5 == 0) {
            printBuzz.run();
            state++;
          }
        } finally {
          lock.unlock();
        }
      }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
      while (state <= n) {
        lock.lock();
        try {
          if (state <= n && state % 3 == 0 && state % 5 == 0) {
            printFizzBuzz.run();
            state++;
          }
        } finally {
          lock.unlock();
        }
      }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
      while (state <= n) {
        lock.lock();
        try {
          if (state <= n && state % 3 != 0 && state % 5 != 0) {
            printNumber.accept(state);
            state++;
          }
        } finally {
          lock.unlock();
        }
      }
    }
  }

  /**
   * {@link Semaphore} solution.
   *
   * <p><a
   * href=https://leetcode.com/problems/fizz-buzz-multithreaded/discuss/386878/Java-Semaphore>https://leetcode.com/problems/fizz-buzz-multithreaded/discuss/386878/Java-Semaphore</a>
   *
   * <p>Probably the best solution for performance since each thread 'has its own' semaphore (i.e.
   * each method/thread here only needs to acquire one semaphore and that semaphore is only acquired
   * by that one method/thread), so it can be controlled that the correct thread gains control
   * without the need for rechecking conditions.
   *
   * <p>Key: check for overlapping case (fizzbuzz) ahead of time. Also conditional logic controlled
   * by one semaphore (number) (and always release to that one).
   */
  class SemaphoreSolution implements P1195FizzBuzzMultithreaded {

    private final int n;

    // initially print a number
    private final Semaphore number = new Semaphore(1);
    private final Semaphore fizz = new Semaphore(0);
    private final Semaphore buzz = new Semaphore(0);
    private final Semaphore fizzBuzz = new Semaphore(0);

    SemaphoreSolution(int n) {
      this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
      for (int i = 3; i <= n; i += 3) {
        fizz.acquire();
        printFizz.run();
        number.release();
        // if next is fizzbuzz, increment again now
        if ((i + 3) % 15 == 0) {
          i += 3;
        }
      }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
      for (int i = 5; i <= n; i += 5) {
        buzz.acquire();
        printBuzz.run();
        number.release();
        // if next is fizzbuzz, increment again now
        if ((i + 5) % 15 == 0) {
          i += 5;
        }
      }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
      for (int i = 15; i <= n; i += 15) {
        fizzBuzz.acquire();
        printFizzBuzz.run();
        number.release();
      }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
      for (int i = 1; i <= n; i++) {
        number.acquire();
        if (i % 15 == 0) {
          fizzBuzz.release();
        } else if (i % 3 == 0) {
          fizz.release();
        } else if (i % 5 == 0) {
          buzz.release();
        } else {
          printNumber.accept(i);
          number.release();
        }
      }
    }
  }
}
