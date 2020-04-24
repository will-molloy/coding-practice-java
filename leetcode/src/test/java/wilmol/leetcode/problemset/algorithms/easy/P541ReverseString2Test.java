package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-25. */
class P541ReverseString2Test {

  private final P541ReverseString2 p541 = new P541ReverseString2();

  @Test
  void example() {
    assertThat(p541.reverseStr("abcdefg", 2)).isEqualTo("bacdfeg");
  }

  @Test
  void k3() {
    assertThat(p541.reverseStr("abcdefg", 3)).isEqualTo("cbadefg");
  }
}
