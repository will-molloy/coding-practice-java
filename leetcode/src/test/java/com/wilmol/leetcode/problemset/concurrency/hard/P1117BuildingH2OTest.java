package com.wilmol.leetcode.problemset.concurrency.hard;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.UncheckedRunnable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/** Created by Will on 2019-07-20 at 16:43. */
@Timeout(value = 1)
class P1117BuildingH2OTest {

  private final P1117BuildingH2O object = new P1117BuildingH2O();

  private volatile String s;

  @BeforeEach
  void setUp() {
    s = "";
  }

  private Thread createHydrogen() {
    return new Thread(
        (UncheckedRunnable)
            () ->
                object.hydrogen(
                    () -> {
                      synchronized (this) {
                        s += "H";
                      }
                    }));
  }

  private Thread createOxygen() {
    return new Thread(
        (UncheckedRunnable)
            () ->
                object.oxygen(
                    () -> {
                      synchronized (this) {
                        s += "O";
                      }
                    }));
  }

  private static void runInOrder(Thread... threads) throws InterruptedException {
    for (Thread t : threads) {
      t.start();
    }
    for (Thread t : threads) {
      t.join();
    }
  }

  @Test
  void example1() throws InterruptedException {
    Thread h1 = createHydrogen();
    Thread h2 = createHydrogen();
    Thread o = createOxygen();
    runInOrder(h1, o, h2);
    assertThat(s).isAnyOf("HHO", "HOH", "OHH");
  }

  @Test
  void example2() throws InterruptedException {
    Thread h1 = createHydrogen();
    Thread h2 = createHydrogen();
    Thread h3 = createHydrogen();
    Thread h4 = createHydrogen();
    Thread o1 = createOxygen();
    Thread o2 = createOxygen();
    runInOrder(o1, o2, h1, h2, h3, h4);
    assertThat(s)
        .isAnyOf(
            "HHOHHO", "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH",
            "OHHOHH");
  }
}
