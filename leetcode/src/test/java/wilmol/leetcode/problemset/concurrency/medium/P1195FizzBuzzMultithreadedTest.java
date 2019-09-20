package wilmol.leetcode.problemset.concurrency.medium;

import static com.google.common.truth.Truth.assertThat;
import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import wilmol.leetcode.common.UncheckedRunnable;

/** Created by wilmol on 2019-09-20. */
@Timeout(value = 10)
class P1195FizzBuzzMultithreadedTest {

  private P1195FizzBuzzMultithreaded object; // lock on object so tests can run in parallel

  private List<String> output;

  private Thread fizzThread() {
    return new Thread(
        (UncheckedRunnable)
            () ->
                requireNonNull(object)
                    .fizz(
                        () -> {
                          synchronized (object) {
                            output.add("fizz");
                            System.out.println("fizz");
                          }
                        }),
        "fizz");
  }

  private Thread buzzThread() {
    return new Thread(
        (UncheckedRunnable)
            () ->
                requireNonNull(object)
                    .buzz(
                        () -> {
                          synchronized (object) {
                            output.add("buzz");
                            System.out.println("buzz");
                          }
                        }),
        "buzz");
  }

  private Thread fizzBuzzThread() {
    return new Thread(
        (UncheckedRunnable)
            () ->
                requireNonNull(object)
                    .fizzbuzz(
                        () -> {
                          synchronized (object) {
                            output.add("fizzbuzz");
                            System.out.println("fizzbuzz");
                          }
                        }),
        "fizzbuzz");
  }

  private Thread numberThread() {
    return new Thread(
        (UncheckedRunnable)
            () ->
                requireNonNull(object)
                    .number(
                        (x) -> {
                          synchronized (object) {
                            output.add(String.valueOf(x));
                            System.out.println(x);
                          }
                        }),
        "number");
  }

  private static void run(Thread... threads) throws InterruptedException {
    for (Thread t : threads) {
      t.start();
    }
    for (Thread t : threads) {
      t.join();
    }
  }

  @BeforeEach
  void setUp() {
    output = new ArrayList<>();
  }

  @Test
  void endOnFizz() throws InterruptedException {
    object = new P1195FizzBuzzMultithreaded(3);
    run(fizzThread(), buzzThread(), fizzBuzzThread(), numberThread());
    assertThat(output).containsExactly("1", "2", "fizz").inOrder();
  }

  @Test
  void endOnBuzz() throws InterruptedException {
    object = new P1195FizzBuzzMultithreaded(5);
    run(fizzThread(), buzzThread(), fizzBuzzThread(), numberThread());
    assertThat(output).containsExactly("1", "2", "fizz", "4", "buzz").inOrder();
  }

  @Test
  void endOnNumberStart() throws InterruptedException {
    object = new P1195FizzBuzzMultithreaded(7);
    run(fizzThread(), buzzThread(), fizzBuzzThread(), numberThread());
    assertThat(output).containsExactly("1", "2", "fizz", "4", "buzz", "fizz", "7").inOrder();
  }

  @Test
  void endOnNumberEnd() throws InterruptedException {
    object = new P1195FizzBuzzMultithreaded(8);
    run(fizzThread(), buzzThread(), fizzBuzzThread(), numberThread());
    assertThat(output).containsExactly("1", "2", "fizz", "4", "buzz", "fizz", "7", "8").inOrder();
  }

  @Test
  void endOnFizzBuzz() throws InterruptedException {
    object = new P1195FizzBuzzMultithreaded(15);
    run(fizzThread(), buzzThread(), fizzBuzzThread(), numberThread());
    assertThat(output)
        .containsExactly(
            "1",
            "2",
            "fizz",
            "4",
            "buzz",
            "fizz",
            "7",
            "8",
            "fizz",
            "buzz",
            "11",
            "fizz",
            "13",
            "14",
            "fizzbuzz")
        .inOrder();
  }
}
