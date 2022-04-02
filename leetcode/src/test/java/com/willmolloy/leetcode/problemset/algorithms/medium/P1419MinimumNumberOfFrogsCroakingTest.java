package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1419MinimumNumberOfFrogsCroakingTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1419MinimumNumberOfFrogsCroakingTest {

  private final P1419MinimumNumberOfFrogsCroaking c = new P1419MinimumNumberOfFrogsCroaking();

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
