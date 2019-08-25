package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-08-25. */
class P40CombinationSum2Test {

  private final P40CombinationSum2 fun = new P40CombinationSum2();

  @Test
  void example1() {
    assertThat(fun.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8))
        .containsExactly(
            Arrays.asList(1, 7),
            Arrays.asList(1, 2, 5),
            Arrays.asList(2, 6),
            Arrays.asList(1, 1, 6));
  }

  @Test
  void example2() {
    assertThat(fun.combinationSum2(new int[] {2, 5, 2, 1, 2}, 5))
        .containsExactly(Arrays.asList(1, 2, 2), Collections.singletonList(5));
  }
}
