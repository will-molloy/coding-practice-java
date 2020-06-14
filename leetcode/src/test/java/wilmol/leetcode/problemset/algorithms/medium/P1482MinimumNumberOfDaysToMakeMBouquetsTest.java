package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-06-14. */
class P1482MinimumNumberOfDaysToMakeMBouquetsTest {

  private final P1482MinimumNumberOfDaysToMakeMBouquets p1482 =
      new P1482MinimumNumberOfDaysToMakeMBouquets();

  @ParameterizedTest
  @MethodSource
  void examples(int[] bloomDay, int m, int k, int expected) {
    assertThat(p1482.minDays(bloomDay, m, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 10, 3, 10, 2}, 3, 1, 3),
        Arguments.of(new int[] {1, 10, 3, 10, 2}, 3, 2, -1),
        Arguments.of(new int[] {7, 7, 7, 7, 12, 7, 7}, 2, 3, 12),
        Arguments.of(new int[] {1000000000, 1000000000}, 1, 1, 1000000000),
        Arguments.of(new int[] {1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2, 9));
  }
}
