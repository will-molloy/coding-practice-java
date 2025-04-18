package com.willmolloy.leetcode.problemset.concurrency.medium;

import static com.google.common.truth.Truth.assertThat;
import static java.util.Objects.requireNonNull;

import com.willmolloy.leetcode.common.UncheckedRunnable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * P1117BuildingH2OTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@Timeout(value = 10)
final class P1117BuildingH2OTest {

  private P1117BuildingH2O object; // lock on object so tests can run in parallel

  private String s;

  @BeforeEach
  void setUp() {
    object = new P1117BuildingH2O();
    s = "";
  }

  private Thread createHydrogen() {
    return new Thread(
        (UncheckedRunnable)
            () ->
                requireNonNull(object)
                    .hydrogen(
                        () -> {
                          synchronized (object) {
                            s += "H";
                          }
                        }),
        "hydrogen");
  }

  private Thread createOxygen() {
    return new Thread(
        (UncheckedRunnable)
            () ->
                requireNonNull(object)
                    .oxygen(
                        () -> {
                          synchronized (object) {
                            s += "O";
                          }
                        }),
        "oxygen");
  }

  private static void run(Thread... threads) throws InterruptedException {
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
    run(h1, o, h2);
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
    run(o1, o2, h1, h2, h3, h4);
    assertThat(s)
        .isAnyOf(
            "HHOHHO", "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH",
            "OHHOHH");
  }
}
