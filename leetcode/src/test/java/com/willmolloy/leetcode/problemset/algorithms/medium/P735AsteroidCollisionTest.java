package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P735AsteroidCollisionTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P735AsteroidCollisionTest {

  private final P735AsteroidCollision p735 = new P735AsteroidCollision();

  @ParameterizedTest
  @MethodSource
  void examples(int[] asteroids, List<Integer> expected) {
    assertThat(p735.asteroidCollision(asteroids))
        .asList()
        .containsExactlyElementsIn(expected)
        .inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {5, 10, -5}, List.of(5, 10)),
        Arguments.of(new int[] {8, -8}, List.of()),
        Arguments.of(new int[] {10, 2, -5}, List.of(10)),
        Arguments.of(new int[] {-2, -1, 1, 2}, List.of(-2, -1, 1, 2)));
  }
}
