package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-02-07. */
class P90Subsets2Test {

  private final P90Subsets2 func = new P90Subsets2();

  @Test
  void emptySet() {
    assertThat(func.subsetsWithDup(new int[0])).containsExactly(ImmutableList.of());
  }

  @Test
  void setWithoutDupes() {
    // technically other answers are valid (subsets with different order) but didn't bother
    assertThat(func.subsetsWithDup(new int[] {1, 2, 3}))
        .containsExactly(
            ImmutableList.of(),
            ImmutableList.of(1),
            ImmutableList.of(2),
            ImmutableList.of(3),
            ImmutableList.of(1, 2),
            ImmutableList.of(1, 3),
            ImmutableList.of(2, 3),
            ImmutableList.of(1, 2, 3));
  }

  @Test
  void setWithDupes() {
    // technically other answers are valid (subsets with different order) but didn't bother
    assertThat(func.subsetsWithDup(new int[] {1, 2, 2}))
        .containsExactly(
            ImmutableList.of(),
            ImmutableList.of(1),
            ImmutableList.of(2),
            ImmutableList.of(1, 2),
            ImmutableList.of(2, 2),
            ImmutableList.of(1, 2, 2));
  }

  @Test
  void setWithDupesUnsorted() {
    // technically other answers are valid (subsets with different order) but didn't bother
    assertThat(func.subsetsWithDup(new int[] {4, 1, 4, 4}))
        .containsExactly(
            ImmutableList.of(),
            ImmutableList.of(1),
            ImmutableList.of(4),
            ImmutableList.of(1, 4),
            ImmutableList.of(4, 4),
            ImmutableList.of(1, 4, 4),
            ImmutableList.of(4, 4, 4),
            ImmutableList.of(1, 4, 4, 4));
  }

  @Test
  void setWithoutDupesUnsorted() {
    // technically other answers are valid (subsets with different order) but didn't bother
    assertThat(func.subsetsWithDup(new int[] {4, 2, 7}))
        .containsExactly(
            ImmutableList.of(),
            ImmutableList.of(2),
            ImmutableList.of(4),
            ImmutableList.of(7),
            ImmutableList.of(2, 4),
            ImmutableList.of(2, 7),
            ImmutableList.of(4, 7),
            ImmutableList.of(2, 4, 7));
  }
}
