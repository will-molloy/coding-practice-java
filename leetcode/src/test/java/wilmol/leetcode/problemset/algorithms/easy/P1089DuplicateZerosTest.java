package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-06-08. */
class P1089DuplicateZerosTest {

  @ParameterizedTest
  @MethodSource("solutions")
  void example1(P1089DuplicateZeros p1089) {
    int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
    p1089.duplicateZeros(arr);
    assertThat(arr).asList().containsExactly(1, 0, 0, 2, 3, 0, 0, 4).inOrder();
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void example2(P1089DuplicateZeros p1089) {
    int[] arr = {1, 2, 3};
    p1089.duplicateZeros(arr);
    assertThat(arr).asList().containsExactly(1, 2, 3).inOrder();
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void wrongAnswer1(P1089DuplicateZeros p1089) {
    int[] arr = {8, 4, 5, 0, 0, 0, 0, 7};
    p1089.duplicateZeros(arr);
    assertThat(arr).asList().containsExactly(8, 4, 5, 0, 0, 0, 0, 0).inOrder();
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void wrongAnswer2(P1089DuplicateZeros p1089) {
    int[] arr = {
      9, 9, 9, 4, 8, 0, 0, 3, 7, 2, 0, 0, 0, 0, 9, 1, 0, 0, 1, 1, 0, 5, 6, 3, 1, 6, 0, 0, 2, 3, 4,
      7, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 7, 3, 3, 0, 5, 7, 0, 8, 1, 9, 6, 3, 0, 8, 8, 8,
      8, 0, 0, 5, 0, 0, 0, 3, 7, 7, 7, 7, 5, 1, 0, 0, 8, 0, 0
    };
    p1089.duplicateZeros(arr);
    assertThat(arr)
        .asList()
        .containsExactly(
            9, 9, 9, 4, 8, 0, 0, 0, 0, 3, 7, 2, 0, 0, 0, 0, 0, 0, 0, 0, 9, 1, 0, 0, 0, 0, 1, 1, 0,
            0, 5, 6, 3, 1, 6, 0, 0, 0, 0, 2, 3, 4, 7, 0, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0,
            0, 0, 7, 3, 3, 0, 0, 5, 7, 0, 0, 8, 1, 9, 6, 3, 0, 0, 8, 8, 8, 8, 0)
        .inOrder();
  }

  static Stream<P1089DuplicateZeros> solutions() {
    return Stream.of(new P1089DuplicateZeros.Quadratic(), new P1089DuplicateZeros.Linear());
  }
}
