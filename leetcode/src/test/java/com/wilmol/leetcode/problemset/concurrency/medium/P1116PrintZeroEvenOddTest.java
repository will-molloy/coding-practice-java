package com.wilmol.leetcode.problemset.concurrency.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.UncheckedRunnable;
import java.util.function.IntConsumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/** Created by Will on 2019-07-19 at 21:15. */
@Timeout(value = 1)
class P1116PrintZeroEvenOddTest {

  private P1116PrintZeroEvenOdd object = new P1116PrintZeroEvenOdd(-1);

  private volatile String s;

  private final IntConsumer append =
      x -> {
        synchronized (this) {
          s += x;
        }
      };

  @BeforeEach
  void setUp() {
    s = "";
  }

  private void runThreadsAbc() throws InterruptedException {
    Thread threadA = new Thread((UncheckedRunnable) () -> object.zero(append));
    Thread threadB = new Thread((UncheckedRunnable) () -> object.odd(append));
    Thread threadC = new Thread((UncheckedRunnable) () -> object.even(append));
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
