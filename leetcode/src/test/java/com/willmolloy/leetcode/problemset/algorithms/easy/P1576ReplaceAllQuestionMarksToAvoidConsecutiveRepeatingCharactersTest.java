package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1576ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharactersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1576ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharactersTest {

  private final P1576ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters p1576 =
      new P1576ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters();

  @ParameterizedTest
  @MethodSource
  void examples(String s, String expected) {
    // yes, expected could be many different things, infeasible to provide all without keeping the
    // test simple
    assertThat(p1576.modifyString(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("?zs", "azs"),
        Arguments.of("ubv?w", "ubvaw"),
        Arguments.of("j?qg??b", "jaqgacb"),
        Arguments.of("??yw?ipkj?", "abywaipkja"));
  }
}
