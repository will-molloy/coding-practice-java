package com.wilmol.hackerrank.interviewpreparationkit.hashtables.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class TwoStringsHasCommonSubStringTest {

  @Test
  void hasCommon() {
    assertThat(TwoStringsHasCommonSubString.hasCommonSubString("hello", "world")).isTrue();
  }

  @Test
  void doesNotHaveCommon() {
    assertThat(TwoStringsHasCommonSubString.hasCommonSubString("hi", "world")).isFalse();
  }
}