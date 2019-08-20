package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-08-20. */
class P38CountAndSayTest {

  private final P38CountAndSay fun = new P38CountAndSay();

  @Test
  void first() {
    assertThat(fun.countAndSay(1)).isEqualTo("1");
  }

  @Test
  void second() {
    assertThat(fun.countAndSay(2)).isEqualTo("11");
  }

  @Test
  void third() {
    assertThat(fun.countAndSay(3)).isEqualTo("21");
  }

  @Test
  void fourth() {
    assertThat(fun.countAndSay(4)).isEqualTo("1211");
  }

  @Test
  void fifth() {
    assertThat(fun.countAndSay(5)).isEqualTo("111221");
  }
}
