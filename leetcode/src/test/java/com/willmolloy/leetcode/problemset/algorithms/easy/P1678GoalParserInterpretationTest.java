package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1678GoalParserInterpretationTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1678GoalParserInterpretationTest {

  private final P1678GoalParserInterpretation p1678 = new P1678GoalParserInterpretation();

  @ParameterizedTest
  @MethodSource
  void examples(String command, String expected) {
    assertThat(p1678.interpret(command)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("G()(al)", "Goal"),
        Arguments.of("G()()()()(al)", "Gooooal"),
        Arguments.of("(al)G(al)()()G", "alGalooG"));
  }
}
