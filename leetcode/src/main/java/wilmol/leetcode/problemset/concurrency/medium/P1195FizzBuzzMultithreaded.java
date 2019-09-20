package wilmol.leetcode.problemset.concurrency.medium;

import java.util.function.IntConsumer;

/**
 * Created by wilmol on 2019-09-20.
 *
 * <p><a
 * href=https://leetcode.com/problems/fizz-buzz-multithreaded>https://leetcode.com/problems/fizz-buzz-multithreaded</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Key: outer loop to ensure thread keeps running and the exit condition.
 */
class P1195FizzBuzzMultithreaded {

  // TODO how to use semaphore here? FizzBuzz would be acquired when both Fizz and Buzz are ???

  private final int n;

  private int state = 1;

  public P1195FizzBuzzMultithreaded(int n) {
    this.n = n;
  }

  // printFizz.run() outputs "fizz".
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

  // printBuzz.run() outputs "buzz".
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

  // printFizzBuzz.run() outputs "fizzbuzz".
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

  // printNumber.accept(x) outputs "x", where x is an integer.
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
