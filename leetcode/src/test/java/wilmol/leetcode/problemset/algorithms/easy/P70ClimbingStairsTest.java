package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2019-12-15. */
class P70ClimbingStairsTest {

  @ParameterizedTest
  @MethodSource("funs")
  void n0(P70ClimbingStairs fun) {
    assertThat(fun.climbStairs(0)).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void n1(P70ClimbingStairs fun) {
    assertThat(fun.climbStairs(1)).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void n2(P70ClimbingStairs fun) {
    assertThat(fun.climbStairs(2)).isEqualTo(2);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void n3(P70ClimbingStairs fun) {
    assertThat(fun.climbStairs(3)).isEqualTo(3);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void n10(P70ClimbingStairs fun) {
    assertThat(fun.climbStairs(10)).isEqualTo(89);
  }

  static Stream<Arguments> funs() {
    return Stream.of(
        Arguments.of(new P70ClimbingStairs.RecursiveTopDown()),
        Arguments.of(new P70ClimbingStairs.IterativeBottomUp()),
        Arguments.of(new P70ClimbingStairs.IterativeBottomUpConstantSpace()));
  }
}
