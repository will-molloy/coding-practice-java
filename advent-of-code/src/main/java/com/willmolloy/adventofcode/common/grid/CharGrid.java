package com.willmolloy.adventofcode.common.grid;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 2D char grid.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public class CharGrid implements BaseGrid<Character, CharGrid, MutableCharGrid> {
  private final char[][] array;

  public CharGrid(char[][] array) {
    this.array = checkNotNull(array);
  }

  @Override
  public int height() {
    return array.length;
  }

  @Override
  public int width() {
    return array[0].length;
  }

  @Override
  public int size() {
    return height() * width();
  }

  @Override
  public Stream<Point> points() {
    return IntStream.range(0, height())
        .mapToObj(y -> IntStream.range(0, width()).mapToObj(x -> new Point(x, y)))
        .flatMap(Function.identity());
  }

  @Override
  public boolean inbounds(Point point) {
    // check height before width, potential IOOB
    return point.y() >= 0 && point.y() < height() && point.x() >= 0 && point.x() < width();
  }

  @Override
  public MutableCharGrid toMutable() {
    char[][] clone = Arrays.stream(array).map(char[]::clone).toArray(char[][]::new);
    return new MutableCharGrid(clone);
  }

  /** Get value at a given point. */
  public char get(Point point) throws ArrayIndexOutOfBoundsException {
    return array[(int) point.y()][(int) point.x()];
  }

  @Override
  public final String toString() {
    return Arrays.stream(array).map(String::new).collect(Collectors.joining("\n"));
  }
}
