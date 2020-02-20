package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-02-20. */
class P119PascalTriangle2Test {

  private final P119PascalTriangle2 fun = new P119PascalTriangle2();

  @Test
  void example() {
    assertThat(fun.getRow(3)).containsExactly(1, 3, 3, 1).inOrder();
  }

  @Test
  void row0() {
    assertThat(fun.getRow(0)).containsExactly(1);
  }

  @Test
  void row1() {
    assertThat(fun.getRow(1)).containsExactly(1, 1).inOrder();
  }

  @Test
  void row4() {
    assertThat(fun.getRow(4)).containsExactly(1, 4, 6, 4, 1).inOrder();
  }
}
