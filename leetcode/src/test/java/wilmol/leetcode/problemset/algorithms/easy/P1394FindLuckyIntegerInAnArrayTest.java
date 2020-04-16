package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-17. */
class P1394FindLuckyIntegerInAnArrayTest {
  private final P1394FindLuckyIntegerInAnArray p1394 = new P1394FindLuckyIntegerInAnArray();

  @Test
  void example1() {
    assertThat(p1394.findLucky(new int[] {2, 2, 3, 4})).isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(p1394.findLucky(new int[] {1, 2, 2, 3, 3, 3})).isEqualTo(3);
  }

  @Test
  void example3() {
    assertThat(p1394.findLucky(new int[] {2, 2, 2, 3, 3})).isEqualTo(-1);
  }

  @Test
  void example4() {
    assertThat(p1394.findLucky(new int[] {5})).isEqualTo(-1);
  }

  @Test
  void example5() {
    assertThat(p1394.findLucky(new int[] {7, 7, 7, 7, 7, 7, 7})).isEqualTo(7);
  }

  @Test
  void maxLuckyOccursPrior() {
    assertThat(p1394.findLucky(new int[] {1, 3, 3, 3, 2, 2})).isEqualTo(3);
  }
}
