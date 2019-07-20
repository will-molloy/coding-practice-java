package com.wilmol.leetcode.problemset.concurrency.hard;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.UncheckedRunnable;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/** Created by Will on 2019-07-20 at 16:43. */
@Timeout(value = 1)
class P1117BuildingH2OTest {

  private final P1117BuildingH2O object = new P1117BuildingH2O();

  private String s;

  @BeforeEach
  void setUp() {
    s = "";
  }

  private Thread createHydrogen() {
    return new Thread((UncheckedRunnable) () -> object.hydrogen(() -> s += "H"));
  }

  private Thread createOxygen() {
    return new Thread((UncheckedRunnable) () -> object.oxygen(() -> s += "O"));
  }

  private static void awaitTerminated(Thread... threads) throws InterruptedException {
    for (Thread thread : threads) {
      thread.join();
    }
  }

  private static void startInOrder(Thread... threads) {
    Arrays.stream(threads).forEach(Thread::start);
  }

  @Test
  void example1() throws InterruptedException {
    Thread h1 = createHydrogen();
    Thread h2 = createHydrogen();
    Thread o = createOxygen();
    startInOrder(h1, o, h2);
    awaitTerminated(h1, h2, o);
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
    startInOrder(o1, o2, h1, h2, h3, h4);
    awaitTerminated(h1, h2, h3, h4, o1, o2);
    assertThat(s)
        .isAnyOf(
            "HHOHHO", "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH",
            "OHHOHH");
  }
}
