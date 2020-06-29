package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P287FindTheDuplicateNumberTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P287FindTheDuplicateNumberTest {

  private final P287FindTheDuplicateNumber p287 = new P287FindTheDuplicateNumber();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int expected) {
    assertThat(p287.findDuplicate(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 3, 4, 2, 2}, 2), Arguments.of(new int[] {3, 1, 3, 4, 2}, 3));
  }

  @Test
  void oneUniqueNum() {
    assertThat(p287.findDuplicate(new int[] {1, 1})).isEqualTo(1);
  }
}
