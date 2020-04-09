package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-09. */
class P264UglyNumber2Test {

  private final P264UglyNumber2 fun = new P264UglyNumber2();

  @Test
  void example1() {
    assertThat(fun.nthUglyNumber(10)).isEqualTo(12);
  }
}
