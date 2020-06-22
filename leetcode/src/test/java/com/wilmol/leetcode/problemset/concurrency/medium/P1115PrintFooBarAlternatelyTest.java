package com.wilmol.leetcode.problemset.concurrency.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.UncheckedRunnable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/** Created by Will on 2019-07-18 at 21:50. */
@Timeout(value = 10)
class P1115PrintFooBarAlternatelyTest {

  private P1115PrintFooBarAlternately object; // lock on object so tests can run in parallel

  private String s;

  private Runnable printFoo =
      () -> {
        synchronized (object) {
          s += "foo";
        }
      };

  private Runnable printBar =
      () -> {
        synchronized (object) {
          s += "bar";
        }
      };

  @BeforeEach
  void setUp() {
    s = "";
  }

  private void runThreadsAb() throws InterruptedException {
    Thread threadA = new Thread((UncheckedRunnable) () -> object.foo(printFoo));
    Thread threadB = new Thread((UncheckedRunnable) () -> object.bar(printBar));
    threadA.start();
    threadB.start();
    threadA.join();
    threadB.join();
  }

  private void runThreadsBa() throws InterruptedException {
    Thread threadA = new Thread((UncheckedRunnable) () -> object.foo(printFoo));
    Thread threadB = new Thread((UncheckedRunnable) () -> object.bar(printBar));
    threadB.start();
    threadA.start();
    threadA.join();
    threadB.join();
  }

  @Test
  void singleRunAFirst() throws InterruptedException {
    object = new P1115PrintFooBarAlternately(1);
    runThreadsAb();
    assertThat(s).isEqualTo("foobar");
  }

  @Test
  void twoRunsAFirst() throws InterruptedException {
    object = new P1115PrintFooBarAlternately(2);
    runThreadsAb();
    assertThat(s).isEqualTo("foobarfoobar");
  }

  @Test
  void singleRunBFirst() throws InterruptedException {
    object = new P1115PrintFooBarAlternately(1);
    runThreadsBa();
    assertThat(s).isEqualTo("foobar");
  }

  @Test
  void twoRunsBFirst() throws InterruptedException {
    object = new P1115PrintFooBarAlternately(2);
    runThreadsBa();
    assertThat(s).isEqualTo("foobarfoobar");
  }
}
