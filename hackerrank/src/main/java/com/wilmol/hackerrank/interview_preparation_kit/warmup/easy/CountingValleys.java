package com.wilmol.hackerrank.interview_preparation_kit.warmup.easy;

/**
 * Created by Will on 24/03/2019
 * <p>
 * Print a single integer that denotes the number of valleys Gary walked through during his hike. Enter valley when
 * going below sea level, exit valley when returning to sea level. Count must be of complete valleys.
 * <p>
 * Runtime: O(n)
 */
class CountingValleys
{

  private static final int SEA_LEVEL = 0;

  static int countingValleys(String s)
  {
    int completedValleyCount = 0;
    boolean inValley = false;
    int level = 0;

    for (char c : s.toCharArray())
    {
      level += c == 'U' ? 1 : -1;
      if (enteringValley(level, inValley))
      {
        inValley = true;
      }
      if (exitingValley(level, inValley))
      {
        inValley = false;
        completedValleyCount += 1;
      }
    }
    return completedValleyCount;
  }

  private static boolean enteringValley(int level, boolean inValley)
  {
    return level < SEA_LEVEL && !inValley;
  }

  private static boolean exitingValley(int level, boolean inValley)
  {
    return level >= SEA_LEVEL && inValley;
  }

}
