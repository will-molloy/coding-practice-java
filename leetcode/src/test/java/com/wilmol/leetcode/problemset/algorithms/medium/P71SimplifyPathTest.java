package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P71SimplifyPathTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P71SimplifyPathTest {

  private final P71SimplifyPath p71SimplifyPath = new P71SimplifyPath();

  @ParameterizedTest
  @MethodSource
  void examples(String path, String expected) {
    assertThat(p71SimplifyPath.simplifyPath(path)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("/home/", "/home"),
        Arguments.of("/../", "/"),
        Arguments.of("/home//foo/", "/home/foo"),
        Arguments.of("/a/./b/../../c/", "/c"));
  }
}
