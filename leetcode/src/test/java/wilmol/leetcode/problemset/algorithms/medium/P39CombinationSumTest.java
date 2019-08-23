package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-08-21. */
class P39CombinationSumTest {

  private P39CombinationSum topDownRecursive = new P39CombinationSum();

  @Test
  void example1() {
    assertThat(topDownRecursive.combinationSum(new int[] {2, 3, 6, 7}, 7))
        .containsExactly(Collections.singletonList(7), Arrays.asList(2, 2, 3));
  }

  @Test
  void example2() {
    assertThat(topDownRecursive.combinationSum(new int[] {2, 3, 5}, 8))
        .containsExactly(Arrays.asList(2, 2, 2, 2), Arrays.asList(2, 3, 3), Arrays.asList(3, 5));
  }
}
