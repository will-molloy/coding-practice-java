package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-24. */
class P231PowerOfTwoTest {
  private final P231PowerOfTwo p231 = new P231PowerOfTwo();

  @Test
  void example1() {
    assertThat(p231.isPowerOfTwo(1)).isTrue();
  }

  @Test
  void example2() {
    assertThat(p231.isPowerOfTwo(16)).isTrue();
  }

  @Test
  void example3() {
    assertThat(p231.isPowerOfTwo(218)).isFalse();
  }

  @Test
  void n0() {
    assertThat(p231.isPowerOfTwo(0)).isFalse();
  }

  @Test
  void nNegative() {
    assertThat(p231.isPowerOfTwo(-1)).isFalse();
  }
}
