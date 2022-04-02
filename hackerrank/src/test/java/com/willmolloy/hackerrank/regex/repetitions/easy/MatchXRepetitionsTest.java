package com.willmolloy.hackerrank.regex.repetitions.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MatchXRepetitionsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class MatchXRepetitionsTest {

  @Test
  void testMatches() {
    assertThat(new MatchXRepetitions().matches("2222222222aaaaaaaaaa2222222222aaaaaaaaaa13 57"))
        .isTrue();
    assertThat(new MatchXRepetitions().matches("x4202v2A22A8a6aaaaaa2G2222m222qwertyYuIo13957"))
        .isTrue();
    assertThat(new MatchXRepetitions().matches("x4202v2A22A8a6aaaaaa2G2222m222qwertyYuIo139\t7"))
        .isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new MatchXRepetitions().matches("x4202v2A22A8a6aaaaaa2G2222m222qwertyYuIo1395779"))
        .isFalse();
  }
}
