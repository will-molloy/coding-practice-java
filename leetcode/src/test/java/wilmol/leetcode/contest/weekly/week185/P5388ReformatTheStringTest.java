package wilmol.leetcode.contest.weekly.week185;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-19. */
class P5388ReformatTheStringTest {

  private final P5388ReformatTheString a = new P5388ReformatTheString();

  @Test
  void example1() {
    assertThat(a.reformat("a0b1c2")).isEqualTo("0a1b2c");
  }

  @Test
  void example2() {
    assertThat(a.reformat("leetcode")).isEmpty();
  }

  @Test
  void example3() {
    assertThat(a.reformat("1229857369")).isEmpty();
  }

  @Test
  void example4() {
    assertThat(a.reformat("covid2019")).isEqualTo("c2o0v1i9d");
  }

  @Test
  void example5() {
    assertThat(a.reformat("ab123")).isEqualTo("1a2b3");
  }

  @Test
  void singleLetter() {
    assertThat(a.reformat("a")).isEqualTo("a");
  }

  @Test
  void singleNumber() {
    assertThat(a.reformat("1")).isEqualTo("1");
  }

  @Test
  void emptyString() {
    assertThat(a.reformat("")).isEqualTo("");
  }
}
