package com.wilmol.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-10-20. */
class UkAndUsPart2Test {

  @Test
  void testCase0() {
    assertThat(
            UkAndUsPart2.process(
                ImmutableList.of(
                    "2",
                    "the odour coming out of the leftover food was intolerable",
                    "ammonia has a very pungent odor",
                    "1",
                    "odour")))
        .containsExactly(2);
  }

  @Test
  void wordEndsWithOr() {
    assertThat(UkAndUsPart2.process(ImmutableList.of("1", "color colour", "1", "colour")))
        .containsExactly(2);
  }

  @Test
  void wordContainsOr() {
    assertThat(UkAndUsPart2.process(ImmutableList.of("1", "favorite favourite", "1", "favourite")))
        .containsExactly(2);
  }
}
