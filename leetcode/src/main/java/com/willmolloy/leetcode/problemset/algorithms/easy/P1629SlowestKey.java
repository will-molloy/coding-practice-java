package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a href=https://leetcode.com/problems/slowest-key>https://leetcode.com/problems/slowest-key/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Track max distance and char associated with that max distance.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1629SlowestKey {

  public char slowestKey(int[] releaseTimes, String keysPressed) {
    int n = releaseTimes.length;

    int maxDuration = releaseTimes[0];
    char maxKey = keysPressed.charAt(0);

    for (int i = 1; i < n; i++) {
      int duration = releaseTimes[i] - releaseTimes[i - 1];
      if (duration >= maxDuration) {
        if (duration > maxDuration || keysPressed.charAt(i) > maxKey) {
          maxKey = keysPressed.charAt(i);
        }
        maxDuration = duration;
      }
    }
    return maxKey;
  }
}
