package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-03-13. */
class P198HouseRobberTest {

  @ParameterizedTest
  @MethodSource("funs")
  void example1(P198HouseRobber fun) {
    assertThat(fun.rob(new int[] {1, 2, 3, 1})).isEqualTo(4);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example2(P198HouseRobber fun) {
    assertThat(fun.rob(new int[] {2, 7, 9, 3, 1})).isEqualTo(12);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void empty(P198HouseRobber fun) {
    assertThat(fun.rob(new int[0])).isEqualTo(0);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void oneElement(P198HouseRobber fun) {
    assertThat(fun.rob(new int[] {1})).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void twoElements(P198HouseRobber fun) {
    assertThat(fun.rob(new int[] {1, 2})).isEqualTo(2);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void threeElements(P198HouseRobber fun) {
    assertThat(fun.rob(new int[] {1, 2, 3})).isEqualTo(4);
  }

  static Stream<P198HouseRobber> funs() {
    return Stream.of(
        new P198HouseRobber.TopDown(),
        new P198HouseRobber.BottomUp(),
        new P198HouseRobber.BottomUpConstantSpace());
  }
}
