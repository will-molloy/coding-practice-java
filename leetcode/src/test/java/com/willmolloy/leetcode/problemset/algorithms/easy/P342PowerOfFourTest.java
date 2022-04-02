package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P342PowerOfFourTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P342PowerOfFourTest {

  private final P342PowerOfFour p342 = new P342PowerOfFour();

  @ParameterizedTest
  @MethodSource
  void powersOf4(int num) {
    assertThat(p342.isPowerOfFour(num)).isTrue();
  }

  static Stream<Integer> powersOf4() {
    return Stream.of(1, 16, 64, 256, 1024);
  }

  @ParameterizedTest
  @MethodSource
  void notPowersOf4(int num) {
    assertThat(p342.isPowerOfFour(num)).isFalse();
  }

  static Stream<Integer> notPowersOf4() {
    return Stream.of(0, 5, 7, 8, 20, 24, 32);
  }
}
