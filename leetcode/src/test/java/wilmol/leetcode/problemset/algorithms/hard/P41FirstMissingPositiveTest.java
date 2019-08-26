package wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-08-25. */
class P41FirstMissingPositiveTest {

  private final P41FirstMissingPositive fun = new P41FirstMissingPositive();

  @Test
  void example1() {
    assertThat(fun.firstMissingPositive(new int[] {1, 2, 0})).isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(fun.firstMissingPositive(new int[] {3, 4, -1, 1})).isEqualTo(2);
  }

  @Test
  void example3() {
    assertThat(fun.firstMissingPositive(new int[] {7, 8, 9, 11, 12})).isEqualTo(1);
  }

  @Test
  void smallerValuesAtStart() {
    assertThat(fun.firstMissingPositive(new int[] {3, 2, 1})).isEqualTo(4);
  }

  @Test
  void negativeValues() {
    assertThat(fun.firstMissingPositive(new int[] {-1, -2, -3})).isEqualTo(1);
  }

  @Test
  void noneMissingInOrder() {
    assertThat(fun.firstMissingPositive(new int[] {1, 2, 3, 4})).isEqualTo(5);
  }

  @Test
  void naiveSwapPutsElementsOutOfOrder() {
    assertThat(fun.firstMissingPositive(new int[] {-1, 4, 2, 1, 9, 10})).isEqualTo(3);
  }

  @Test
  void onlyOnes() {
    assertThat(fun.firstMissingPositive(new int[] {1, 1})).isEqualTo(2);
  }
}
