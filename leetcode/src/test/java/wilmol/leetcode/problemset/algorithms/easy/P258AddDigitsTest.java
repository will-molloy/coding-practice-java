package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-12. */
class P258AddDigitsTest {

  private final P258AddDigits fun = new P258AddDigits();

  @Test
  void example() {
    assertThat(fun.addDigits(38)).isEqualTo(2);
  }

  @Test
  void edgeCase10() {
    assertThat(fun.addDigits(10)).isEqualTo(1);
  }

  @Test
  void edgeCase9() {
    assertThat(fun.addDigits(9)).isEqualTo(9);
  }
}
