package wilmol.leetcode.problemset.concurrency.medium;

import java.util.concurrent.Semaphore;
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

  private final int n;

  // initially print a number
  private final Semaphore number = new Semaphore(1);
  private final Semaphore fizz = new Semaphore(0);
  private final Semaphore buzz = new Semaphore(0);
  private final Semaphore fizzBuzz = new Semaphore(0);

  public P1195FizzBuzzMultithreaded(int n) {
    this.n = n;
  }

  public void fizz(Runnable printFizz) throws InterruptedException {
    for (int i = 3; i <= n; i += 3) {
      fizz.acquire();
      printFizz.run();
      number.release();
      if (i % 15 == 0) {
        i += 3;
      }
    }
  }

  public void buzz(Runnable printBuzz) throws InterruptedException {
    for (int i = 5; i <= n; i += 5) {
      buzz.acquire();
      printBuzz.run();
      number.release();
      if (i % 15 == 0) {
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
