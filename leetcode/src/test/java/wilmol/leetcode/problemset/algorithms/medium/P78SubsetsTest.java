package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-01-21. */
class P78SubsetsTest {

  private final P78Subsets fun = new P78Subsets();

  @Test
  void emptySet() {
    assertThat(fun.subsets(new int[] {})).containsExactly(ImmutableList.of());
  }

  @Test
  void nums1() {
    assertThat(fun.subsets(new int[] {1})).containsExactly(ImmutableList.of(), ImmutableList.of(1));
  }

  @Test
  void nums12() {
    assertThat(fun.subsets(new int[] {1, 2}))
        .containsExactly(
            ImmutableList.of(), ImmutableList.of(1), ImmutableList.of(2), ImmutableList.of(1, 2));
  }

  @Test
  void nums123() {
    assertThat(fun.subsets(new int[] {1, 2, 3}))
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
}
