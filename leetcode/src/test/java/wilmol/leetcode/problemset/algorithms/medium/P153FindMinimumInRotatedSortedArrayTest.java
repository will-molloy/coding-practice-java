package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-08-13. */
class P153FindMinimumInRotatedSortedArrayTest {

  private final P153FindMinimumInRotatedSortedArray fun = new P153FindMinimumInRotatedSortedArray();

  @Test
  void example1() {
    assertThat(fun.findMin(new int[] {3, 4, 5, 1, 2})).isEqualTo(1);
  }

  @Test
  void example2() {
    assertThat(fun.findMin(new int[] {4, 5, 6, 7, 0, 1, 2})).isEqualTo(0);
  }

  @Test
  void notRotated() {
    assertThat(fun.findMin(new int[] {1, 2, 3, 4, 5})).isEqualTo(1);
  }
}
