package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-17. */
class P1447SimplifiedFractionsTest {

  private final P1447SimplifiedFractions p1447 = new P1447SimplifiedFractions();

  @Test
  void example1() {
    assertThat(p1447.simplifiedFractions(2)).containsExactly("1/2");
  }

  @Test
  void example3() {
    assertThat(p1447.simplifiedFractions(3)).containsExactly("1/2", "1/3", "2/3");
  }

  @Test
  void example4() {
    assertThat(p1447.simplifiedFractions(4)).containsExactly("1/2", "1/3", "1/4", "2/3", "3/4");
  }

  @Test
  void example5() {
    assertThat(p1447.simplifiedFractions(1)).isEmpty();
  }
}
