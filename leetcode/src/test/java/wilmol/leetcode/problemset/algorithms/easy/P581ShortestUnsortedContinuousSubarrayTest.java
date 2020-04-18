package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-18. */
class P581ShortestUnsortedContinuousSubarrayTest {

  private final P581ShortestUnsortedContinuousSubarray p581 =
      new P581ShortestUnsortedContinuousSubarray();

  @Test
  void example() {
    assertThat(p581.findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15})).isEqualTo(5);
  }

  @Test
  void ascendingOrder() {
    assertThat(p581.findUnsortedSubarray(new int[] {1, 2, 3, 4})).isEqualTo(0);
  }

  @Test
  void descendingOrder() {
    assertThat(p581.findUnsortedSubarray(new int[] {4, 3, 2, 1})).isEqualTo(4);
  }

  @Test
  void sameElement() {
    assertThat(p581.findUnsortedSubarray(new int[] {2, 2, 2, 2})).isEqualTo(0);
  }

  @Test
  void unsortedSameElements() {
    assertThat(p581.findUnsortedSubarray(new int[] {1, 1, 3, 3, 2, 2, 2, 2})).isEqualTo(6);
  }
}
