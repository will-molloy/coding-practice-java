package wilmol.leetcode.problemset.algorithms.unknown;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.problemset.algorithms.unknown.LeftmostColumnWithAtLeastAOne.BinaryMatrixImpl;

/** Created by wilmol on 2020-04-22. */
class LeftmostColumnWithAtLeastAOneTest {

  private final LeftmostColumnWithAtLeastAOne fun = new LeftmostColumnWithAtLeastAOne();

  @Test
  void example1() {
    BinaryMatrixImpl matrix = new BinaryMatrixImpl(new int[][] {{0, 0}, {1, 1}});
    assertThat(fun.leftMostColumnWithOne(matrix)).isEqualTo(0);
  }

  @Test
  void example2() {
    BinaryMatrixImpl matrix = new BinaryMatrixImpl(new int[][] {{0, 0}, {0, 1}});
    assertThat(fun.leftMostColumnWithOne(matrix)).isEqualTo(1);
  }

  @Test
  void example3() {
    BinaryMatrixImpl matrix = new BinaryMatrixImpl(new int[][] {{0, 0}, {0, 0}});
    assertThat(fun.leftMostColumnWithOne(matrix)).isEqualTo(-1);
  }

  @Test
  void example4() {
    BinaryMatrixImpl matrix =
        new BinaryMatrixImpl(new int[][] {{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}});
    assertThat(fun.leftMostColumnWithOne(matrix)).isEqualTo(1);
  }
}
