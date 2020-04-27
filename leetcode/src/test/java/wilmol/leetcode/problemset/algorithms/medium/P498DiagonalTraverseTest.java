package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-27. */
class P498DiagonalTraverseTest {

  private final P498DiagonalTraverse p498 = new P498DiagonalTraverse();

  @Test
  void example() {
    assertThat(
            p498.findDiagonalOrder(
                new int[][] {
                  {1, 2, 3},
                  {4, 5, 6},
                  {7, 8, 9},
                }))
        .asList()
        .containsExactly(1, 2, 4, 7, 5, 3, 6, 8, 9)
        .inOrder();
  }
}
