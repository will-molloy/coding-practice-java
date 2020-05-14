package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-14. */
class P507PerfectNumberTest {

  private final P507PerfectNumber p507 = new P507PerfectNumber();

  @Test
  void example() {
    assertThat(p507.checkPerfectNumber(28)).isTrue();
  }

  @Test
  void oneIsNotPerfect() {
    assertThat(p507.checkPerfectNumber(1)).isFalse();
  }

  @Test
  void two() {
    assertThat(p507.checkPerfectNumber(2)).isFalse();
  }

  @Test
  void six() {
    assertThat(p507.checkPerfectNumber(6)).isTrue();
  }
}
