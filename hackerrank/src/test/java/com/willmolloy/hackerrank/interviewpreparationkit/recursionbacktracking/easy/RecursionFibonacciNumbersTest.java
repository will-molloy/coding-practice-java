package com.willmolloy.hackerrank.interviewpreparationkit.recursionbacktracking.easy;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * RecursionFibonacciNumbersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class RecursionFibonacciNumbersTest {

  @Test()
  void negativeInput() {
    assertThrows(IllegalArgumentException.class, () -> RecursionFibonacciNumbers.fibonacci(-1));
  }

  @Test
  void testCase0() {
    assertThat(RecursionFibonacciNumbers.fibonacci(25)).isEqualTo(75_025);
  }

  @Test
  void testCase1() {
    assertThat(RecursionFibonacciNumbers.fibonacci(30)).isEqualTo(832_040);
  }

  @Test
  void testCase2() {
    assertThat(RecursionFibonacciNumbers.fibonacci(5)).isEqualTo(5);
  }

  @Test
  void testCase3() {
    assertThat(RecursionFibonacciNumbers.fibonacci(27)).isEqualTo(196_418);
  }

  @Test
  void testCase4() {
    assertThat(RecursionFibonacciNumbers.fibonacci(12)).isEqualTo(144);
  }
}
