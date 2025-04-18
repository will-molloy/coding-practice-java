package com.willmolloy.hackerrank.interviewpreparationkit.dictionarieshashmaps.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * TwoStringsHasCommonSubStringTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class TwoStringsHasCommonSubStringTest {

  @Test
  void hasCommon() {
    assertThat(TwoStringsHasCommonSubString.hasCommonSubString("hello", "world")).isTrue();
  }

  @Test
  void doesNotHaveCommon() {
    assertThat(TwoStringsHasCommonSubString.hasCommonSubString("hi", "world")).isFalse();
  }
}
