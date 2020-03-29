package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-03-29. */
class P152MaximumProductSubarrayTest {

  @ParameterizedTest
  @MethodSource("funs")
  void example1(P152MaximumProductSubarray fun) {
    assertThat(fun.maxProduct(new int[] {2, 3, -2, 4})).isEqualTo(6);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example2(P152MaximumProductSubarray fun) {
    assertThat(fun.maxProduct(new int[] {-2, 0, -1})).isEqualTo(0);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void extendedFromMin(P152MaximumProductSubarray fun) {
    assertThat(fun.maxProduct(new int[] {2, 3, -2, 4, -1})).isEqualTo(48);
  }

  static Stream<P152MaximumProductSubarray> funs() {
    return Stream.of(
        new P152MaximumProductSubarray.Quadratic(), new P152MaximumProductSubarray.Linear());
  }
}
