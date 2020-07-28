package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P621TaskSchedulerTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P621TaskSchedulerTest {

  private final P621TaskScheduler p621 = new P621TaskScheduler();

  @ParameterizedTest
  @MethodSource
  void examples(char[] tasks, int n, int expected) {
    assertThat(p621.leastInterval(tasks, n)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2, 8),
        Arguments.of(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 0, 6),
        Arguments.of(
            new char[] {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2, 16));
  }

  @Test
  void wa1() {
    assertThat(
            p621.leastInterval(
                new char[] {
                  'A', 'A', 'A', 'B', 'B', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'
                },
                7))
        .isEqualTo(18);
  }
}
