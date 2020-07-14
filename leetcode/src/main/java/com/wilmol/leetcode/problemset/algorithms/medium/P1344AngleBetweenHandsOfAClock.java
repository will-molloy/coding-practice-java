package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/angle-between-hands-of-a-clock>https://leetcode.com/problems/angle-between-hands-of-a-clock/</a>
 *
 * <p>Runtime: O(1)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Getting angles for minute/hour separately, then taking the difference.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1344AngleBetweenHandsOfAClock {

  public double angleClock(int hour, int minutes) {
    // angles from start
    double minuteAngle = minutes * (360 / 60);
    double hourAngle = ((hour % 12) + (minuteAngle / 360)) * (360 / 12);

    double diff = Math.abs(minuteAngle - hourAngle);

    // want the smaller angle
    return diff > 180 ? 360 - diff : diff;
  }
}
