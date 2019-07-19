package com.wilmol.leetcode.problemset.concurrency.medium;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.MockitoAnnotations.initMocks;

import com.wilmol.leetcode.common.UncheckedRunnable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.InOrder;
import org.mockito.Mock;

/** Created by Will on 2019-07-18 at 21:50. */
@Timeout(value = 1)
class P1115PrintFooBarAlternatelyTest {

  private P1115PrintFooBarAlternately object;

  @Mock private Runnable printFoo;

  @Mock private Runnable printBar;

  @BeforeEach
  void setUp() {
    initMocks(this);
  }

  @AfterEach
  void tearDown() {
    verifyNoMoreInteractions(printFoo, printBar);
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

    InOrder inOrder = inOrder(printFoo, printBar);
    inOrder.verify(printFoo).run();
    inOrder.verify(printBar).run();
  }

  @Test
  void twoRunsAFirst() throws InterruptedException {
    object = new P1115PrintFooBarAlternately(2);
    runThreadsAb();

    InOrder inOrder = inOrder(printFoo, printBar);
    inOrder.verify(printFoo).run();
    inOrder.verify(printBar).run();
    inOrder.verify(printFoo).run();
    inOrder.verify(printBar).run();
  }

  @Test
  void singleRunBFirst() throws InterruptedException {
    object = new P1115PrintFooBarAlternately(1);
    runThreadsBa();

    InOrder inOrder = inOrder(printFoo, printBar);
    inOrder.verify(printFoo).run();
    inOrder.verify(printBar).run();
  }

  @Test
  void twoRunsBFirst() throws InterruptedException {
    object = new P1115PrintFooBarAlternately(2);
    runThreadsBa();

    InOrder inOrder = inOrder(printFoo, printBar);
    inOrder.verify(printFoo).run();
    inOrder.verify(printBar).run();
    inOrder.verify(printFoo).run();
    inOrder.verify(printBar).run();
  }
}
