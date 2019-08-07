package wilmol.leetcode.problemset.concurrency.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import wilmol.leetcode.common.UncheckedRunnable;

/** Created by will on 2019-07-17 at 9:04 PM. */
@Timeout(value = 10)
class P1114PrintInOrderTest {

  private P1114PrintInOrder object; // lock on Object so tests can run in parallel

  private volatile String s;

  private Thread threadA;

  private Thread threadB;

  private Thread threadC;

  @BeforeEach
  void setUp() {
    object = new P1114PrintInOrder();
    s = "";
    threadA =
        new Thread(
            (UncheckedRunnable)
                () ->
                    object.first(
                        () -> {
                          synchronized (object) {
                            s += "first";
                          }
                        }));
    threadB =
        new Thread(
            (UncheckedRunnable)
                () ->
                    object.second(
                        () -> {
                          synchronized (object) {
                            s += "second";
                          }
                        }));
    threadC =
        new Thread(
            (UncheckedRunnable)
                () ->
                    object.third(
                        () -> {
                          synchronized (object) {
                            s += "third";
                          }
                        }));
  }

  @AfterEach
  void verifyCorrectOrder() throws InterruptedException {
    threadA.join();
    threadB.join();
    threadC.join();
    assertThat(s).isEqualTo("firstsecondthird");
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
