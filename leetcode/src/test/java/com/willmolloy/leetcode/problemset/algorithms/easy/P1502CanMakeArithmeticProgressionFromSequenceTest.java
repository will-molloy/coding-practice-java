package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.willmolloy.testlib.CartesianProduct.cartesianProduct;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1502CanMakeArithmeticProgressionFromSequenceTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1502CanMakeArithmeticProgressionFromSequenceTest {

  @ParameterizedTest
  @MethodSource
  void examples(P1502CanMakeArithmeticProgressionFromSequence p1502, int[] a, boolean expected) {
    assertThat(p1502.canMakeArithmeticProgression(a)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    Stream<Arguments> args =
        Stream.of(
            Arguments.of(new int[] {3, 5, 1}, true), Arguments.of(new int[] {1, 2, 4}, false));
    return cartesianProduct(p1502(), args);
  }

  @ParameterizedTest
  @MethodSource("p1502")
  void nonIntegerStep(P1502CanMakeArithmeticProgressionFromSequence p1502) {
    assertThat(p1502.canMakeArithmeticProgression(new int[] {0, 1, 3, 4, 6})).isFalse();
  }

  @ParameterizedTest
  @MethodSource("p1502")
  void singleUniqueValue(P1502CanMakeArithmeticProgressionFromSequence p1502) {
    assertThat(p1502.canMakeArithmeticProgression(new int[] {0, 0, 0, 0})).isTrue();
  }

  @ParameterizedTest
  @MethodSource("p1502")
  void invalidIntegerSizedStep(P1502CanMakeArithmeticProgressionFromSequence p1502) {
    assertThat(p1502.canMakeArithmeticProgression(new int[] {2, 10, 7, 8, 3})).isFalse();
  }

  @ParameterizedTest
  @MethodSource("p1502")
  void invalidDuplicate(P1502CanMakeArithmeticProgressionFromSequence p1502) {
    assertThat(p1502.canMakeArithmeticProgression(new int[] {0, 0, 0, 3})).isFalse();
  }

  static Stream<P1502CanMakeArithmeticProgressionFromSequence> p1502() {
    return Stream.of(
        new P1502CanMakeArithmeticProgressionFromSequence.Sort(),
        new P1502CanMakeArithmeticProgressionFromSequence.DivisibleByStep());
  }
}
