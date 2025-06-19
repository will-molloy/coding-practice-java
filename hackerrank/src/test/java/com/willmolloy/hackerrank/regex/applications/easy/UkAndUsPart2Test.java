package com.willmolloy.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * UkAndUsPart2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class UkAndUsPart2Test {

  @Test
  void testCase0() {
    assertThat(
            UkAndUsPart2.process(
                List.of(
                    "2",
                    "the odour coming out of the leftover food was intolerable",
                    "ammonia has a very pungent odor",
                    "1",
                    "odour")))
        .containsExactly(2);
  }

  @Test
  void wordEndsWithOr() {
    assertThat(UkAndUsPart2.process(List.of("1", "color colour", "1", "colour")))
        .containsExactly(2);
  }

  @Test
  void wordContainsOr() {
    assertThat(UkAndUsPart2.process(List.of("1", "favorite favourite", "1", "favourite")))
        .containsExactly(2);
  }
}
