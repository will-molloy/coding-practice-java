package wilmol.leetcode.problemset.algorithms.unknown;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-14. */
class CountingElementsTest {

  private final CountingElements fun = new CountingElements();

  @Test
  void example1() {
    assertThat(fun.countElements(new int[] {1, 2, 3})).isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(fun.countElements(new int[] {1, 1, 3, 3, 5, 5, 7, 7})).isEqualTo(0);
  }

  @Test
  void example3() {
    assertThat(fun.countElements(new int[] {1, 3, 2, 3, 5, 0})).isEqualTo(3);
  }

  @Test
  void example4() {
    assertThat(fun.countElements(new int[] {1, 1, 2, 2})).isEqualTo(2);
  }
}
