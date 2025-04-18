package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P841KeysAndRoomsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P841KeysAndRoomsTest {

  private final P841KeysAndRooms p841KeysAndRooms = new P841KeysAndRooms();

  @ParameterizedTest
  @MethodSource
  void examples(List<List<Integer>> rooms, boolean expected) {
    assertThat(p841KeysAndRooms.canVisitAllRooms(rooms)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(List.of(List.of(1), List.of(2), List.of(3), List.of()), true),
        Arguments.of(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0)), false));
  }
}
