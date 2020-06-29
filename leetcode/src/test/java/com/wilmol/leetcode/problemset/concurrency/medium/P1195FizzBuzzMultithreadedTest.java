package com.wilmol.leetcode.problemset.concurrency.medium;

import static com.google.common.truth.Truth.assertThat;
import static java.util.Objects.requireNonNull;

import com.wilmol.leetcode.common.UncheckedRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1195FizzBuzzMultithreadedTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
@Timeout(value = 10)
class P1195FizzBuzzMultithreadedTest {

  private List<String> output;

  private Thread fizzThread(P1195FizzBuzzMultithreaded object) {
    return new Thread(
        (UncheckedRunnable)
            () ->
                requireNonNull(object)
                    .fizz(
                        () -> {
                          synchronized (object) {
                            output.add("fizz");
                          }
                        }),
        "fizz");
  }

  private Thread buzzThread(P1195FizzBuzzMultithreaded object) {
    return new Thread(
        (UncheckedRunnable)
            () ->
                requireNonNull(object)
                    .buzz(
                        () -> {
                          synchronized (object) {
                            output.add("buzz");
                          }
                        }),
        "buzz");
  }

  private Thread fizzBuzzThread(P1195FizzBuzzMultithreaded object) {
    return new Thread(
        (UncheckedRunnable)
            () ->
                requireNonNull(object)
                    .fizzbuzz(
                        () -> {
                          synchronized (object) {
                            output.add("fizzbuzz");
                          }
                        }),
        "fizzbuzz");
  }

  private Thread numberThread(P1195FizzBuzzMultithreaded object) {
    return new Thread(
        (UncheckedRunnable)
            () ->
                requireNonNull(object)
                    .number(
                        (x) -> {
                          synchronized (object) {
                            output.add(String.valueOf(x));
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

  @ParameterizedTest
  @MethodSource("objectSource")
  void endOnFizz(IntFunction<P1195FizzBuzzMultithreaded> objectF) throws InterruptedException {
    P1195FizzBuzzMultithreaded object = objectF.apply(3);
    run(fizzThread(object), buzzThread(object), fizzBuzzThread(object), numberThread(object));
    assertThat(output).containsExactly("1", "2", "fizz").inOrder();
  }

  @ParameterizedTest
  @MethodSource("objectSource")
  void endOnBuzz(IntFunction<P1195FizzBuzzMultithreaded> objectF) throws InterruptedException {
    P1195FizzBuzzMultithreaded object = objectF.apply(5);
    run(fizzThread(object), buzzThread(object), fizzBuzzThread(object), numberThread(object));
    assertThat(output).containsExactly("1", "2", "fizz", "4", "buzz").inOrder();
  }

  @ParameterizedTest
  @MethodSource("objectSource")
  void endOnNumberStart(IntFunction<P1195FizzBuzzMultithreaded> objectF)
      throws InterruptedException {
    P1195FizzBuzzMultithreaded object = objectF.apply(7);
    run(fizzThread(object), buzzThread(object), fizzBuzzThread(object), numberThread(object));
    assertThat(output).containsExactly("1", "2", "fizz", "4", "buzz", "fizz", "7").inOrder();
  }

  @ParameterizedTest
  @MethodSource("objectSource")
  void endOnNumberEnd(IntFunction<P1195FizzBuzzMultithreaded> objectF) throws InterruptedException {
    P1195FizzBuzzMultithreaded object = objectF.apply(8);
    run(fizzThread(object), buzzThread(object), fizzBuzzThread(object), numberThread(object));
    assertThat(output).containsExactly("1", "2", "fizz", "4", "buzz", "fizz", "7", "8").inOrder();
  }

  @ParameterizedTest
  @MethodSource("objectSource")
  void endOnFizzBuzz(IntFunction<P1195FizzBuzzMultithreaded> objectF) throws InterruptedException {
    P1195FizzBuzzMultithreaded object = objectF.apply(15);
    run(fizzThread(object), buzzThread(object), fizzBuzzThread(object), numberThread(object));
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

  static Stream<Arguments> objectSource() {
    return Stream.of(
        Arguments.of(
            (IntFunction<P1195FizzBuzzMultithreaded>)
                P1195FizzBuzzMultithreaded.WaitNotifySolution::new),
        Arguments.of(
            (IntFunction<P1195FizzBuzzMultithreaded>)
                P1195FizzBuzzMultithreaded.ReentrantLockSolution::new),
        Arguments.of(
            (IntFunction<P1195FizzBuzzMultithreaded>)
                P1195FizzBuzzMultithreaded.SemaphoreSolution::new));
  }
}
