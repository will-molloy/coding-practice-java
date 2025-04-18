package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1346CheckIfNAndItsDoubleExistsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1346CheckIfNAndItsDoubleExistsTest {

  private final P1346CheckIfNAndItsDoubleExists p1346 = new P1346CheckIfNAndItsDoubleExists();

  @ParameterizedTest
  @MethodSource
  void examples(int[] arr, boolean expected) {
    assertThat(p1346.checkIfExist(arr)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {10, 2, 5, 3}, true),
        Arguments.of(new int[] {7, 1, 14, 11}, true),
        Arguments.of(new int[] {3, 1, 7, 11}, false));
  }

  @Test
  void indexMustBeDifferent() {
    assertThat(p1346.checkIfExist(new int[] {0})).isFalse();
  }
}
