package wilmol.leetcode.contest.weekly.week185;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-19. */
class P5390MinimumNumberOfFrogsCroakingTest {

  private final P5390MinimumNumberOfFrogsCroaking c = new P5390MinimumNumberOfFrogsCroaking();

  @Test
  void example1() {
    assertThat(c.minNumberOfFrogs("croakcroak")).isEqualTo(1);
  }

  @Test
  void example2() {
    assertThat(c.minNumberOfFrogs("crcoakroak")).isEqualTo(2);
  }

  @Test
  void example3() {
    assertThat(c.minNumberOfFrogs("croakcrook")).isEqualTo(-1);
  }

  @Test
  void example4() {
    assertThat(c.minNumberOfFrogs("croakcroa")).isEqualTo(-1);
  }

  @Test
  void wrongAnswer1() {
    assertThat(c.minNumberOfFrogs("crocracokrakoak")).isEqualTo(3);
  }

  @Test
  void emptyString() {
    assertThat(c.minNumberOfFrogs("")).isEqualTo(-1);
  }
}
