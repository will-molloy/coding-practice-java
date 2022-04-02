package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/robot-bounded-in-circle>https://leetcode.com/problems/robot-bounded-in-circle/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: If the robot is facing a new direction it will reach the origin again in another 1-3
 * iterations and is therefore looping.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1041RobotBoundedInCircle {

  public boolean isRobotBounded(String instructions) {
    Move move = Move.NORTH;
    int x = 0;
    int y = 0;
    for (char c : instructions.toCharArray()) {
      switch (c) {
        case 'G':
          x += move.x;
          y += move.y;
          break;
        case 'L':
          move = move.left();
          break;
        case 'R':
          move = move.right();
          break;
        default:
          throw new IllegalArgumentException(
              String.format("Expected 'G', 'L', or 'R' but was %s", instructions));
      }
    }
    // two cases where the robot keeps looping:
    // 1. back at origin
    // 2. not facing North - it will reach the origin again in another 1-3 iterations
    return x == 0 && y == 0 || move != Move.NORTH;
  }

  private enum Move {
    NORTH(0, -1),
    EAST(1, 0),
    SOUTH(0, 1),
    WEST(-1, 0);

    int x;
    int y;

    Move(int x, int y) {
      this.x = x;
      this.y = y;
    }

    Move left() {
      Move[] values = Move.values();
      return values[(ordinal() + 1) % values.length];
    }

    Move right() {
      Move[] values = Move.values();
      return values[(ordinal() + values.length - 1) % values.length];
    }
  }
}
