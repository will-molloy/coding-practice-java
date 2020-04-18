package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-18. */
class P134GasStationTest {

  private final P134GasStation p134 = new P134GasStation();

  @Test
  void example() {
    assertThat(p134.canCompleteCircuit(new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 1, 2}))
        .isEqualTo(3);
  }
}
