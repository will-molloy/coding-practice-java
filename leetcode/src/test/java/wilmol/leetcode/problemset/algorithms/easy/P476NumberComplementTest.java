package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-04. */
class P476NumberComplementTest {

  private final P476NumberComplement p476 = new P476NumberComplement();

  @Test
  void example1() {
    assertThat(p476.findComplement(5)).isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(p476.findComplement(1)).isEqualTo(0);
  }

  @Test
  void n7() {
    assertThat(p476.findComplement(7)).isEqualTo(0);
  }

  @Test
  void n40() {
    assertThat(p476.findComplement(40)).isEqualTo(23);
  }

  @Test
  void n123() {
    assertThat(p476.findComplement(123)).isEqualTo(4);
  }
}
