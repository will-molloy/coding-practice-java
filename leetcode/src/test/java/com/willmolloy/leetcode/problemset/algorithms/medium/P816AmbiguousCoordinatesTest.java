package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P816AmbiguousCoordinatesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P816AmbiguousCoordinatesTest {

  private final P816AmbiguousCoordinates p816AmbiguousCoordinates = new P816AmbiguousCoordinates();

  @ParameterizedTest
  @MethodSource
  void examples(String s, List<String> expected) {
    assertThat(p816AmbiguousCoordinates.ambiguousCoordinates(s))
        .containsExactlyElementsIn(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("(123)", List.of("(1, 2.3)", "(1, 23)", "(1.2, 3)", "(12, 3)")),
        Arguments.of(
            "(0123)",
            List.of("(0, 1.23)", "(0, 12.3)", "(0, 123)", "(0.1, 2.3)", "(0.1, 23)", "(0.12, 3)")),
        Arguments.of("(00011)", List.of("(0, 0.011)", "(0.001, 1)")),
        Arguments.of("(100)", List.of("(10, 0)")));
  }
}
