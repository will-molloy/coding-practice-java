package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-06-14. */
class P1480RunningSumOf1dArrayTest {

  private final P1480RunningSumOf1dArray p1480 = new P1480RunningSumOf1dArray();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, List<Integer> expected) {
    assertThat(p1480.runningSum(nums)).asList().containsExactlyElementsIn(expected).inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 4}, ImmutableList.of(1, 3, 6, 10)),
        Arguments.of(new int[] {1, 1, 1, 1, 1}, ImmutableList.of(1, 2, 3, 4, 5)),
        Arguments.of(new int[] {3, 1, 2, 10, 1}, ImmutableList.of(3, 4, 6, 16, 17)));
  }
}
