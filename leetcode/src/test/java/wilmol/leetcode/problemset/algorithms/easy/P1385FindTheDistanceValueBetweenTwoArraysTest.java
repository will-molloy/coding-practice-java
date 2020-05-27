package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-05-27. */
class P1385FindTheDistanceValueBetweenTwoArraysTest {

  private final P1385FindTheDistanceValueBetweenTwoArrays p1385 =
      new P1385FindTheDistanceValueBetweenTwoArrays();

  @ParameterizedTest
  @MethodSource
  void examples(int[] arr1, int[] arr2, int d, int expected) {
    assertThat(p1385.findTheDistanceValue(arr1, arr2, d)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {4, 5, 8}, new int[] {10, 9, 1, 8}, 2, 2),
        Arguments.of(new int[] {1, 4, 2, 3}, new int[] {-4, -3, 6, 10, 20, 30}, 3, 2),
        Arguments.of(new int[] {2, 1, 100, 3}, new int[] {-5, -2, 10, -3, 7}, 6, 1));
  }
}
