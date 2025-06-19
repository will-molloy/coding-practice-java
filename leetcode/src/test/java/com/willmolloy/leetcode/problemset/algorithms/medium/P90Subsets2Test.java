package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P90Subsets2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P90Subsets2Test {

  private final P90Subsets2 func = new P90Subsets2();

  @Test
  void emptySet() {
    assertThat(func.subsetsWithDup(new int[0])).containsExactly(List.of());
  }

  @Test
  void setWithoutDupes() {
    // technically other answers are valid (subsets with different order) but didn't bother
    assertThat(func.subsetsWithDup(new int[] {1, 2, 3}))
        .containsExactly(
            List.of(),
            List.of(1),
            List.of(2),
            List.of(3),
            List.of(1, 2),
            List.of(1, 3),
            List.of(2, 3),
            List.of(1, 2, 3));
  }

  @Test
  void setWithDupes() {
    // technically other answers are valid (subsets with different order) but didn't bother
    assertThat(func.subsetsWithDup(new int[] {1, 2, 2}))
        .containsExactly(
            List.of(), List.of(1), List.of(2), List.of(1, 2), List.of(2, 2), List.of(1, 2, 2));
  }

  @Test
  void setWithDupesUnsorted() {
    // technically other answers are valid (subsets with different order) but didn't bother
    assertThat(func.subsetsWithDup(new int[] {4, 1, 4, 4}))
        .containsExactly(
            List.of(),
            List.of(1),
            List.of(4),
            List.of(1, 4),
            List.of(4, 4),
            List.of(1, 4, 4),
            List.of(4, 4, 4),
            List.of(1, 4, 4, 4));
  }

  @Test
  void setWithoutDupesUnsorted() {
    // technically other answers are valid (subsets with different order) but didn't bother
    assertThat(func.subsetsWithDup(new int[] {4, 2, 7}))
        .containsExactly(
            List.of(),
            List.of(2),
            List.of(4),
            List.of(7),
            List.of(2, 4),
            List.of(2, 7),
            List.of(4, 7),
            List.of(2, 4, 7));
  }
}
