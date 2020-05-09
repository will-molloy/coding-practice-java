package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-09. */
class P367ValidPerfectSquareTest {

  private final P367ValidPerfectSquare p367 = new P367ValidPerfectSquare();

  @Test
  void example1() {
    assertThat(p367.isPerfectSquare(16)).isTrue();
  }

  @Test
  void example2() {
    assertThat(p367.isPerfectSquare(14)).isFalse();
  }

  @Test
  void one() {
    assertThat(p367.isPerfectSquare(1)).isTrue();
  }

  @Test
  void intMax() {
    assertThat(p367.isPerfectSquare(Integer.MAX_VALUE)).isFalse();
  }
}
