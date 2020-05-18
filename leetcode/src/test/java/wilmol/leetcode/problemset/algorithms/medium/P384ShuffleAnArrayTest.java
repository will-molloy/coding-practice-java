package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-18. */
class P384ShuffleAnArrayTest {

  @Test
  void example() {
    P384ShuffleAnArray.Solution solution = new P384ShuffleAnArray.Solution(new int[] {1, 2, 3});
    assertThat(solution.shuffle())
        .asList()
        .isAnyOf(
            ImmutableList.of(1, 2, 3),
            ImmutableList.of(1, 3, 2),
            ImmutableList.of(2, 1, 3),
            ImmutableList.of(2, 3, 1),
            ImmutableList.of(3, 1, 2),
            ImmutableList.of(3, 2, 1));
    assertThat(solution.reset()).asList().containsExactly(1, 2, 3).inOrder();
    assertThat(solution.shuffle())
        .asList()
        .isAnyOf(
            ImmutableList.of(1, 2, 3),
            ImmutableList.of(1, 3, 2),
            ImmutableList.of(2, 1, 3),
            ImmutableList.of(2, 3, 1),
            ImmutableList.of(3, 1, 2),
            ImmutableList.of(3, 2, 1));
  }
}
