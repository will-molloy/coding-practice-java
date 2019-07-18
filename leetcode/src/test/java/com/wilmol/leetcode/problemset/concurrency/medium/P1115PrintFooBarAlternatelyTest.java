package com.wilmol.leetcode.problemset.concurrency.medium;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;

/** Created by Will on 2019-07-18 at 21:50. */
class P1115PrintFooBarAlternatelyTest {

  private P1115PrintFooBarAlternately object;

  @Mock private Runnable printFoo;

  @Mock private Runnable printBar;

  @FunctionalInterface
  private interface UncheckedRunnable extends Runnable {
    @Override
    default void run() {
      try {
        uncheckedRun();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    void uncheckedRun() throws Exception;
  }

  @BeforeEach
  void setUp() {
    initMocks(this);
  }

  @Test
  void singleRunAFirst() throws InterruptedException {
    object = new P1115PrintFooBarAlternately(1);

    Thread threadA = new Thread((UncheckedRunnable) () -> object.foo(printFoo));
    Thread threadB = new Thread((UncheckedRunnable) () -> object.bar(printBar));
    threadA.start();
    threadB.start();
    threadA.join();
    threadB.join();

    InOrder inOrder = inOrder(printFoo, printBar);
    inOrder.verify(printFoo).run();
    inOrder.verify(printBar).run();
    inOrder.verifyNoMoreInteractions();
    verifyNoMoreInteractions(printFoo, printBar);
  }

  @Test
  void twoRunsAFirst() throws InterruptedException {
    object = new P1115PrintFooBarAlternately(2);

    Thread threadA = new Thread((UncheckedRunnable) () -> object.foo(printFoo));
    Thread threadB = new Thread((UncheckedRunnable) () -> object.bar(printBar));
    threadA.start();
    threadB.start();
    threadA.join();
    threadB.join();

    InOrder inOrder = inOrder(printFoo, printBar);
    inOrder.verify(printFoo).run();
    inOrder.verify(printBar).run();
    inOrder.verify(printFoo).run();
    inOrder.verify(printBar).run();
    inOrder.verifyNoMoreInteractions();
    verifyNoMoreInteractions(printFoo, printBar);
  }

  @Test
  void singleRunBFirst() throws InterruptedException {
    object = new P1115PrintFooBarAlternately(1);

    Thread threadA = new Thread((UncheckedRunnable) () -> object.foo(printFoo));
    Thread threadB = new Thread((UncheckedRunnable) () -> object.bar(printBar));
    threadB.start();
    threadA.start();
    threadA.join();
    threadB.join();

    InOrder inOrder = inOrder(printFoo, printBar);
    inOrder.verify(printFoo).run();
    inOrder.verify(printBar).run();
    inOrder.verifyNoMoreInteractions();
    verifyNoMoreInteractions(printFoo, printBar);
  }

  @Test
  void twoRunsBFirst() throws InterruptedException {
    object = new P1115PrintFooBarAlternately(2);

    Thread threadA = new Thread((UncheckedRunnable) () -> object.foo(printFoo));
    Thread threadB = new Thread((UncheckedRunnable) () -> object.bar(printBar));
    threadB.start();
    threadA.start();
    threadA.join();
    threadB.join();

    InOrder inOrder = inOrder(printFoo, printBar);
    inOrder.verify(printFoo).run();
    inOrder.verify(printBar).run();
    inOrder.verify(printFoo).run();
    inOrder.verify(printBar).run();
    inOrder.verifyNoMoreInteractions();
    verifyNoMoreInteractions(printFoo, printBar);
  }
}
