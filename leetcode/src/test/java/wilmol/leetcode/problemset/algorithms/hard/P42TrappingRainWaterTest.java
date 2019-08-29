package wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2019-08-29. */
class P42TrappingRainWaterTest {

  @ParameterizedTest
  @MethodSource("functions")
  void example(P42TrappingRainWater fun) {
    assertThat(fun.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})).isEqualTo(6);
  }

  @ParameterizedTest
  @MethodSource("functions")
  void noRainOnFirstLevel(P42TrappingRainWater fun) {
    assertThat(fun.trap(new int[] {4, 2, 3})).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("functions")
  void nonZeroStart(P42TrappingRainWater fun) {
    assertThat(fun.trap(new int[] {1, 2, 1, 0, 1, 2, 1})).isEqualTo(4);
  }

  @ParameterizedTest
  @MethodSource("functions")
  void leftSideOnly(P42TrappingRainWater fun) {
    assertThat(fun.trap(new int[] {5, 0, 5, 4})).isEqualTo(5);
  }

  @ParameterizedTest
  @MethodSource("functions")
  void rightSideOnly(P42TrappingRainWater fun) {
    assertThat(fun.trap(new int[] {4, 5, 0, 5})).isEqualTo(5);
  }

  @ParameterizedTest
  @MethodSource("functions")
  void leftSideLarger(P42TrappingRainWater fun) {
    assertThat(fun.trap(new int[] {2, 0, 1})).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("functions")
  void rightSideLarger(P42TrappingRainWater fun) {
    assertThat(fun.trap(new int[] {1, 0, 2})).isEqualTo(1);
  }

  static Stream<Arguments> functions() {
    return Stream.of(
        Arguments.of(new P42TrappingRainWater.MultiplePass()),
        Arguments.of(new P42TrappingRainWater.SinglePass()));
  }
}
