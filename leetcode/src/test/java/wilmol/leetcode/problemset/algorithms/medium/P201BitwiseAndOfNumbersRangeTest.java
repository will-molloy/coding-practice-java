package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-23. */
class P201BitwiseAndOfNumbersRangeTest {

  private final P201BitwiseAndOfNumbersRange p201 = new P201BitwiseAndOfNumbersRange();

  @Test
  void example1() {
    assertThat(p201.rangeBitwiseAnd(5, 7)).isEqualTo(4);
  }

  @Test
  void example2() {
    assertThat(p201.rangeBitwiseAnd(0, 1)).isEqualTo(0);
  }

  @Test
  void maxRange() {
    assertThat(p201.rangeBitwiseAnd(0, Integer.MAX_VALUE)).isEqualTo(0);
  }
}
