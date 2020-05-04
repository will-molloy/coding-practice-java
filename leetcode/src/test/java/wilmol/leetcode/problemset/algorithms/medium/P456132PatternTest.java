package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-04. */
class P456132PatternTest {

  private final P456132Pattern p456 = new P456132Pattern();

  @Test
  void example1() {
    assertThat(p456.find132pattern(new int[] {1, 2, 3, 4})).isFalse();
  }

  @Test
  void example2() {
    assertThat(p456.find132pattern(new int[] {3, 1, 4, 2})).isTrue();
  }

  @Test
  void example3() {
    assertThat(p456.find132pattern(new int[] {-1, 3, 2, 0})).isTrue();
  }

  @Test
  void akBetweenAiAndAjButAiIsLargerThanAj() {
    // -3 is in [-4, 1]
    assertThat(p456.find132pattern(new int[] {1, 0, 1, -4, -3})).isFalse();
  }
}
