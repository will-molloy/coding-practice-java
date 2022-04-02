package com.willmolloy.hackerrank.interviewpreparationkit.warmup.easy;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup>https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup</a>
 *
 * <p>Print a single integer that denotes the number of valleys Gary walked through during his hike.
 * Enter valley when going below sea level, exit valley when returning to sea level. Count must be
 * of complete valleys.
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class CountingValleys {

  private CountingValleys() {}

  private static final int SEA_LEVEL = 0;

  static int countingValleys(String s) {
    int completedValleyCount = 0;
    boolean inValley = false;
    int level = 0;

    for (char c : s.toCharArray()) {
      level += c == 'U' ? 1 : -1;
      if (enteringValley(level, inValley)) {
        inValley = true;
      }
      if (exitingValley(level, inValley)) {
        inValley = false;
        completedValleyCount += 1;
      }
    }
    return completedValleyCount;
  }

  private static boolean enteringValley(int level, boolean inValley) {
    return level < SEA_LEVEL && !inValley;
  }

  private static boolean exitingValley(int level, boolean inValley) {
    return level >= SEA_LEVEL && inValley;
  }
}
