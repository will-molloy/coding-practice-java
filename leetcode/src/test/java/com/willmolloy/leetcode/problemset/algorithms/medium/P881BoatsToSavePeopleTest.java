package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P881BoatsToSavePeopleTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P881BoatsToSavePeopleTest {

  private final P881BoatsToSavePeople p881BoatsToSavePeople = new P881BoatsToSavePeople();

  @ParameterizedTest
  @MethodSource
  void examples(int[] people, int limit, int expected) {
    assertThat(p881BoatsToSavePeople.numRescueBoats(people, limit)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 2}, 3, 1),
        Arguments.of(new int[] {3, 2, 2, 1}, 3, 3),
        Arguments.of(new int[] {3, 5, 3, 4}, 5, 4));
  }

  @Test
  void wa1() {
    assertThat(p881BoatsToSavePeople.numRescueBoats(new int[] {5, 1, 4, 2}, 6)).isEqualTo(2);
  }
}
