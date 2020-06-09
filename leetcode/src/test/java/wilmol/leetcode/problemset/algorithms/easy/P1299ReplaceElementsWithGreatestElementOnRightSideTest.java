package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-06-09. */
class P1299ReplaceElementsWithGreatestElementOnRightSideTest {

  private final P1299ReplaceElementsWithGreatestElementOnRightSide p1299 =
      new P1299ReplaceElementsWithGreatestElementOnRightSide();

  @Test
  void example() {
    assertThat(p1299.replaceElements(new int[] {17, 18, 5, 4, 6, 1}))
        .asList()
        .containsExactly(18, 6, 6, 6, 1, -1)
        .inOrder();
  }
}
