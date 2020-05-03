package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-05-03. */
class P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitTest {

  @ParameterizedTest
  @MethodSource("p1438")
  void example1(P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit p1438) {
    assertThat(p1438.longestSubarray(new int[] {8, 2, 4, 7}, 4)).isEqualTo(2);
  }

  @ParameterizedTest
  @MethodSource("p1438")
  void example2(P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit p1438) {
    assertThat(p1438.longestSubarray(new int[] {10, 1, 2, 4, 7, 2}, 5)).isEqualTo(4);
  }

  @ParameterizedTest
  @MethodSource("p1438")
  void example3(P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit p1438) {
    assertThat(p1438.longestSubarray(new int[] {4, 2, 2, 2, 4, 4, 2, 2}, 0)).isEqualTo(3);
  }

  static Stream<P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit> p1438() {
    return Stream.of(
        new P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit
            .TimeLimitExceeded(),
        new P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit.Accepted());
  }
}
