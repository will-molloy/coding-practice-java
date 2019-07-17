package com.wilmol.leetcode.problemset.concurrency;

import static org.mockito.Mockito.inOrder;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/** Created by will on 2019-07-17 at 9:04 PM. */
class P1114PrintInOrderTest {

  private final Logger log = Logger.getLogger(P1114PrintInOrder.class.getName());

  private P1114PrintInOrder object;

  @Mock private Runnable runFirst;

  @Mock private Runnable runSecond;

  @Mock private Runnable runThird;

  private Thread threadA;

  private Thread threadB;

  private Thread threadC;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    object = new P1114PrintInOrder();
    threadA =
        new Thread(
            () -> {
              try {
                object.first(runFirst);
              } catch (InterruptedException e) {
                log.log(Level.SEVERE, "error", e);
              }
            });
    threadB =
        new Thread(
            () -> {
              try {
                object.second(runSecond);
              } catch (InterruptedException e) {
                log.log(Level.SEVERE, "error", e);
              }
            });
    threadC =
        new Thread(
            () -> {
              try {
                object.third(runThird);
              } catch (InterruptedException e) {
                log.log(Level.SEVERE, "error", e);
              }
            });
  }

  @AfterEach
  void verifyCorrectOrder() throws InterruptedException {
    threadA.join();
    threadB.join();
    threadC.join();
    InOrder inOrder = inOrder(runFirst, runSecond, runThird);
    inOrder.verify(runFirst).run();
    inOrder.verify(runSecond).run();
    inOrder.verify(runThird).run();
  }

  @Test
  void abc() {
    threadA.start();
    threadB.start();
    threadC.start();
  }

  @Test
  void acb() {
    threadA.start();
    threadC.start();
    threadB.start();
  }

  @Test
  void bac() {
    threadB.start();
    threadA.start();
    threadC.start();
  }

  @Test
  void bca() {
    threadB.start();
    threadC.start();
    threadA.start();
  }

  @Test
  void cab() {
    threadC.start();
    threadA.start();
    threadB.start();
  }

  @Test
  void cba() {
    threadC.start();
    threadB.start();
    threadA.start();
  }
}
