package com.wilmol.leetcode.problemset.concurrency.medium;

import static com.google.common.truth.Truth.assertThat;
import static java.util.Objects.requireNonNull;

import com.wilmol.leetcode.common.UncheckedRunnable;
import java.util.function.IntConsumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/** Created by Will on 2019-07-19 at 21:15. */
@Timeout(value = 10)
class P1116PrintZeroEvenOddTest {

  private P1116PrintZeroEvenOdd object; // lock on Object so tests can run in parallel

  private volatile String s;

  private final IntConsumer append =
      x -> {
        synchronized (object) {
          s += x;
        }
      };

  @BeforeEach
  void setUp() {
    s = "";
  }

  private void runThreadsAbc() throws InterruptedException {
    Thread threadA = new Thread((UncheckedRunnable) () -> requireNonNull(object).zero(append));
    Thread threadB = new Thread((UncheckedRunnable) () -> requireNonNull(object).odd(append));
    Thread threadC = new Thread((UncheckedRunnable) () -> requireNonNull(object).even(append));
    threadA.start();
    threadB.start();
    threadC.start();
    threadA.join();
    threadB.join();
    threadC.join();
  }

  @Test
  void example1() throws InterruptedException {
    object = new P1116PrintZeroEvenOdd(2);
    runThreadsAbc();
    assertThat(s).isEqualTo("0102");
  }

  @Test
  void example2() throws InterruptedException {
    object = new P1116PrintZeroEvenOdd(5);
    runThreadsAbc();
    assertThat(s).isEqualTo("0102030405");
  }
}
