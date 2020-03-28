package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-03-29. */
class P303RangeSumQueryImmutableTest {

  @Test
  void example() {
    P303RangeSumQueryImmutable.NumArray rangeSumQuery =
        new P303RangeSumQueryImmutable.NumArray(new int[] {-2, 0, 3, -5, 2, -1});
    assertAll(
        () -> assertThat(rangeSumQuery.sumRange(0, 2)).isEqualTo(1),
        () -> assertThat(rangeSumQuery.sumRange(2, 5)).isEqualTo(-1),
        () -> assertThat(rangeSumQuery.sumRange(0, 5)).isEqualTo(-3));
  }

  @Test
  void constructWithEmptyArray() {
    assertDoesNotThrow(() -> new P303RangeSumQueryImmutable.NumArray(new int[0]));
  }
}
