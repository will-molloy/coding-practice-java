package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-07-21 at 15:13. */
class P16ThreeSumClosestTest {

  private final P16ThreeSumClosest function = new P16ThreeSumClosest();

  @Test
  void example() {
    assertThat(function.threeSumClosest(new int[] {-1, 2, 1, -4}, 1)).isEqualTo(2);
  }

  @Test
  void canSumToTarget() {
    assertThat(function.threeSumClosest(new int[] {-1, 2, 1, -4}, 2)).isEqualTo(2);
  }

  @Test
  void equalElements() {
    assertThat(function.threeSumClosest(new int[] {0, 0, 0, 0, 0}, 20)).isEqualTo(0);
  }
}
