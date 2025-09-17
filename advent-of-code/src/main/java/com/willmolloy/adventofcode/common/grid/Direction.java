package com.willmolloy.adventofcode.common.grid;

import java.util.List;

/**
 * 2D direction.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public enum Direction {
  UP,
  DOWN,
  LEFT,
  RIGHT,
  LEFT_UP,
  RIGHT_UP,
  LEFT_DOWN,
  RIGHT_DOWN;

  public static List<Direction> straight() {
    return List.of(UP, DOWN, LEFT, RIGHT);
  }

  public static List<Direction> straightAndDiagonal() {
    return List.of(Direction.values());
  }
}
