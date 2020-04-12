package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-12. */
class P204CountPrimesTest {

  private final P204CountPrimes fun = new P204CountPrimes();

  @Test
  void n10() {
    assertThat(fun.countPrimes(10)).isEqualTo(4);
  }

  @Test
  void n121() {
    assertThat(fun.countPrimes(121)).isEqualTo(30);
  }

  @Test
  void n2() {
    assertThat(fun.countPrimes(2)).isEqualTo(0);
  }

  @Test
  void n1() {
    assertThat(fun.countPrimes(1)).isEqualTo(0);
  }

  @Test
  void n0() {
    assertThat(fun.countPrimes(0)).isEqualTo(0);
  }

  @Test
  void n499979() {
    assertThat(fun.countPrimes(499979)).isEqualTo(41537);
  }
}
