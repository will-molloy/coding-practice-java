package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-04-15. */
class P673NumberOfLongestIncreasingSubsequenceTest {

  @ParameterizedTest
  @MethodSource("funs")
  void example1(P673NumberOfLongestIncreasingSubsequence fun) {
    assertThat(fun.findNumberOfLis(new int[] {1, 3, 5, 4, 7})).isEqualTo(2);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example2(P673NumberOfLongestIncreasingSubsequence fun) {
    assertThat(fun.findNumberOfLis(new int[] {2, 2, 2, 2, 2})).isEqualTo(5);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void checksLength(P673NumberOfLongestIncreasingSubsequence fun) {
    assertThat(fun.findNumberOfLis(new int[] {2, 1})).isEqualTo(2);
  }

  static Stream<P673NumberOfLongestIncreasingSubsequence> funs() {
    return Stream.of(
        new P673NumberOfLongestIncreasingSubsequence.Dp(),
        new P673NumberOfLongestIncreasingSubsequence.SegmentTree());
  }
}
