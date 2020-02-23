package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-02-23. */
class P120TriangleTest {

  private final P120Triangle fun = new P120Triangle();

  @Test
  void example() {
    assertThat(
            fun.minimumTotal(
                ImmutableList.of(
                    ImmutableList.of(2),
                    ImmutableList.of(3, 4),
                    ImmutableList.of(6, 5, 7),
                    ImmutableList.of(4, 1, 8, 3))))
        .isEqualTo(11);
  }

  @Test
  void singleRow() {
    assertThat(fun.minimumTotal(ImmutableList.of(ImmutableList.of(-10)))).isEqualTo(-10);
  }

  @Test
  void negativeCosts() {
    assertThat(
            fun.minimumTotal(
                ImmutableList.of(
                    ImmutableList.of(-1), ImmutableList.of(2, 3), ImmutableList.of(1, -1, -3))))
        .isEqualTo(-1);
  }
}
