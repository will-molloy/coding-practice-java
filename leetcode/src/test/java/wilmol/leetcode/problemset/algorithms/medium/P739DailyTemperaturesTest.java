package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-19. */
class P739DailyTemperaturesTest {

  private final P739DailyTemperatures p739 = new P739DailyTemperatures();

  @Test
  void example() {
    assertThat(p739.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73}))
        .asList()
        .containsExactly(1, 1, 4, 2, 1, 1, 0, 0)
        .inOrder();
  }

  @Test
  void tempMustBeLargerNotEqual() {
    assertThat(p739.dailyTemperatures(new int[] {89, 62, 70, 58, 47, 47, 46, 76, 100, 70}))
        .asList()
        .containsExactly(8, 1, 5, 4, 3, 2, 1, 1, 0, 0)
        .inOrder();
  }
}
