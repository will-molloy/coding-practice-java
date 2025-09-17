package com.willmolloy.adventofcode.common.grid;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit tests for {@link CharGrid}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class CharGridTest {
  private final CharGrid grid =
      new CharGrid(
          new char[][] {
            {'a', 'x'},
            {'b', 'y'},
            {'c', 'z'}
          });

  @Test
  void testHeight() {
    assertThat(grid.height()).isEqualTo(3);
  }

  @Test
  void testWidth() {
    assertThat(grid.width()).isEqualTo(2);
  }

  @Test
  void testSize() {
    assertThat(grid.size()).isEqualTo(6);
  }

  @Test
  void testPoints() {
    assertThat(grid.points())
        .containsExactly(
            new Point(0, 0), new Point(1, 0),
            new Point(0, 1), new Point(1, 1),
            new Point(0, 2), new Point(1, 2))
        .inOrder();
  }

  @Test
  void testIterator() {
    assertThat(grid).containsExactlyElementsIn(grid.points().toList());
  }

  @ParameterizedTest
  @MethodSource
  void testInbounds(Point point, boolean expected) {
    assertThat(grid.inbounds(point)).isEqualTo(expected);
  }

  static Stream<Arguments> testInbounds() {
    return Stream.of(
        Arguments.of(new Point(0, 0), true),
        Arguments.of(new Point(1, 0), true),
        Arguments.of(new Point(0, 1), true),
        Arguments.of(new Point(1, 1), true),
        Arguments.of(new Point(0, 2), true),
        Arguments.of(new Point(1, 2), true),
        // OOB
        Arguments.of(new Point(-1, 0), false),
        Arguments.of(new Point(0, -1), false),
        Arguments.of(new Point(2, 0), false),
        Arguments.of(new Point(0, 3), false));
  }

  @Test
  void testInbounds_emptyGrid() {
    CharGrid grid = new CharGrid(new char[0][0]);
    assertThat(grid.inbounds(new Point(0, 0))).isFalse();
  }

  @Test
  void testToMutable_doesNotMutateOriginalGrid() {
    MutableCharGrid mutableGrid = grid.toMutable();
    Point point = new Point(1, 2);

    mutableGrid.set(point, '.');

    assertThat(grid.get(point)).isEqualTo('z');
    assertThat(mutableGrid.get(point)).isEqualTo('.');
  }

  @ParameterizedTest
  @MethodSource
  void testGet(Point point, char expected) {
    assertThat(grid.get(point)).isEqualTo(expected);
  }

  static Stream<Arguments> testGet() {
    return Stream.of(
        Arguments.of(new Point(0, 0), 'a'),
        Arguments.of(new Point(0, 1), 'b'),
        Arguments.of(new Point(0, 2), 'c'),
        Arguments.of(new Point(1, 0), 'x'),
        Arguments.of(new Point(1, 1), 'y'),
        Arguments.of(new Point(1, 2), 'z'));
  }

  @Test
  void testToString() {
    assertThat(grid.toString()).isEqualTo("ax\nby\ncz");
  }
}
