package wilmol.leetcode.problemset.concurrency.hard;

import static com.google.common.truth.Truth.assertThat;
import static java.util.Objects.requireNonNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import wilmol.leetcode.common.UncheckedRunnable;

/** Created by Will on 2019-07-20 at 16:43. */
@Timeout(value = 10)
class P1117BuildingH2OTest {

  private P1117BuildingH2O object; // lock on Object so tests can run in parallel

  private volatile String s;

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
                        }));
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
