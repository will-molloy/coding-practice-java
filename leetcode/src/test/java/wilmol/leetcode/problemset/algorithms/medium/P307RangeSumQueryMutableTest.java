package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.problemset.algorithms.medium.P307RangeSumQueryMutable.NumArray;

/** Created by wilmol on 2020-04-15. */
class P307RangeSumQueryMutableTest {

  @Test
  void example() {
    NumArray numArray = new NumArray(new int[] {1, 3, 5});
    assertThat(numArray.sumRange(0, 2)).isEqualTo(9);
    numArray.update(1, 2);
    assertThat(numArray.sumRange(0, 2)).isEqualTo(8);
  }

  @Test
  void leftQueryAndUpdate() {
    NumArray numArray = new NumArray(new int[] {0, 1, 2, 3, 4, 5});
    assertThat(numArray.sumRange(0, 0)).isEqualTo(0);
    numArray.update(0, 1);
    assertThat(numArray.sumRange(0, 0)).isEqualTo(1);
  }

  @Test
  void rightQueryAndUpdate() {
    NumArray numArray = new NumArray(new int[] {0, 1, 2, 3, 4, 5});
    assertThat(numArray.sumRange(5, 5)).isEqualTo(5);
    numArray.update(5, 6);
    assertThat(numArray.sumRange(5, 5)).isEqualTo(6);
  }

  @Test
  void overlappingQueryAndUpdate() {
    NumArray numArray = new NumArray(new int[] {0, 1, 2, 3, 4, 5});
    assertThat(numArray.sumRange(2, 3)).isEqualTo(5);
    numArray.update(2, 3);
    numArray.update(3, 4);
    assertThat(numArray.sumRange(2, 3)).isEqualTo(7);
  }

  @Test
  void emptyArray() {
    NumArray numArray = new NumArray(new int[0]);
    assertThat(numArray.sumRange(0, 0)).isEqualTo(0);
  }
}
