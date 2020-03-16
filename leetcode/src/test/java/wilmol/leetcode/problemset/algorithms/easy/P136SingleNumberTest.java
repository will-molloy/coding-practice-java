package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-03-16. */
class P136SingleNumberTest {

  private final P136SingleNumber fun = new P136SingleNumber();

  @Test
  void example1() {
    assertThat(fun.singleNumber(new int[] {2, 2, 1})).isEqualTo(1);
  }

  @Test
  void example2() {
    assertThat(fun.singleNumber(new int[] {4, 1, 2, 1, 2})).isEqualTo(4);
  }
}
