package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-24. */
class P867TransposeMatrixTest {

  private final P867TransposeMatrix p867 = new P867TransposeMatrix();

  @Test
  void example1() {
    assertThat(
            p867.transpose(
                new int[][] {
                  {1, 2, 3},
                  {4, 5, 6},
                  {7, 8, 9},
                }))
        .isEqualTo(
            new int[][] {
              {1, 4, 7},
              {2, 5, 8},
              {3, 6, 9},
            });
  }

  @Test
  void example2() {
    assertThat(
            p867.transpose(
                new int[][] {
                  {1, 2, 3},
                  {4, 5, 6},
                }))
        .isEqualTo(
            new int[][] {
              {1, 4},
              {2, 5},
              {3, 6},
            });
  }

  @Test
  void emptyArray() {
    assertThat(p867.transpose(new int[0][0])).isEmpty();
  }
}
