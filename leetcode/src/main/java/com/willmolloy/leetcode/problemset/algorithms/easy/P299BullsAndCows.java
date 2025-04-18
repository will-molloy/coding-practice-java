package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/bulls-and-cows>https://leetcode.com/problems/bulls-and-cows/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Compute secret freqs so cow check is constant. Also count bulls before cows so don't
 * count bulls as cows (i.e. don't include bulls in freq).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P299BullsAndCows {

  public String getHint(String secret, String guess) {
    int[] secretFreqs = new int[10];
    int bull = 0;
    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        bull++;
      } else {
        secretFreqs[secret.charAt(i) - '0']++;
      }
    }

    int cow = 0;
    for (int i = 0; i < guess.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        // already counted bulls
        continue;
      }
      if (secretFreqs[guess.charAt(i) - '0']-- > 0) {
        cow++;
      }
    }

    return bull + "A" + cow + "B";
  }
}
