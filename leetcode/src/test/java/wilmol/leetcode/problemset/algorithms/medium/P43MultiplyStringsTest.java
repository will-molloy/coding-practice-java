package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-11-30. */
class P43MultiplyStringsTest {

  private final P43MultiplyStrings fun = new P43MultiplyStrings();

  @Test
  void example1() {
    assertThat(fun.multiply("2", "3")).isEqualTo("6");
  }

  @Test
  void example2() {
    assertThat(fun.multiply("123", "456")).isEqualTo("56088");
  }
}
