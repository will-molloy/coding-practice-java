package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-24. */
class P1309DecryptStringFromAlphabetToIntegerMappingTest {

  private final P1309DecryptStringFromAlphabetToIntegerMapping p1309 =
      new P1309DecryptStringFromAlphabetToIntegerMapping();

  @Test
  void example1() {
    assertThat(p1309.freqAlphabets("10#11#12")).isEqualTo("jkab");
  }

  @Test
  void example2() {
    assertThat(p1309.freqAlphabets("1326#")).isEqualTo("acz");
  }

  @Test
  void example3() {
    assertThat(p1309.freqAlphabets("25#")).isEqualTo("y");
  }

  @Test
  void example4() {
    assertThat(p1309.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"))
        .isEqualTo("abcdefghijklmnopqrstuvwxyz");
  }
}
