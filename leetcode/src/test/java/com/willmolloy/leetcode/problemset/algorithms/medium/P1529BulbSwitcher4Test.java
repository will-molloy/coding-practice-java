package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1529BulbSwitcher4Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1529BulbSwitcher4Test {

  private final P1529BulbSwitcher4 p1529 = new P1529BulbSwitcher4();

  @ParameterizedTest
  @MethodSource
  void examples(String target, int expected) {
    assertThat(p1529.minFlips(target)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("10111", 3),
        Arguments.of("101", 3),
        Arguments.of("00000", 0),
        Arguments.of("001011101", 5));
  }

  @Test
  void beginsWith1() {
    assertThat(p1529.minFlips("101")).isEqualTo(3);
  }
}
