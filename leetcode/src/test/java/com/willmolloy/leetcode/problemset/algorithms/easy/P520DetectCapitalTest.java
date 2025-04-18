package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P520DetectCapitalTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P520DetectCapitalTest {

  private final P520DetectCapital p520 = new P520DetectCapital();

  @Test
  void allUpper() {
    assertThat(p520.detectCapitalUse("USA")).isTrue();
  }

  @Test
  void allLower() {
    assertThat(p520.detectCapitalUse("leetcode")).isTrue();
  }

  @Test
  void firstUpper() {
    assertThat(p520.detectCapitalUse("Google")).isTrue();
  }

  @Test
  void wrongUse() {
    assertThat(p520.detectCapitalUse("FlaG")).isFalse();
  }
}
