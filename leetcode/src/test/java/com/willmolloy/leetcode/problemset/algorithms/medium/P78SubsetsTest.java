package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P78SubsetsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P78SubsetsTest {

  private final P78Subsets fun = new P78Subsets();

  @Test
  void emptySet() {
    assertThat(fun.subsets(new int[] {})).containsExactly(List.of());
  }

  @Test
  void nums1() {
    assertThat(fun.subsets(new int[] {1})).containsExactly(List.of(), List.of(1));
  }

  @Test
  void nums12() {
    assertThat(fun.subsets(new int[] {1, 2}))
        .containsExactly(List.of(), List.of(1), List.of(2), List.of(1, 2));
  }

  @Test
  void nums123() {
    assertThat(fun.subsets(new int[] {1, 2, 3}))
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
}
