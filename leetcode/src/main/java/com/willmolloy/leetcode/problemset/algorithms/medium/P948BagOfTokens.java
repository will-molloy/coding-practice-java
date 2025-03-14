package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/bag-of-tokens>https://leetcode.com/problems/bag-of-tokens/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Spend power on smallest tokens, gain power on largest tokens. Prioritise spending
 * power (as this gains score). (Greedy.)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P948BagOfTokens {

  public int bagOfTokensScore(int[] tokens, int p) {
    int n = tokens.length;

    Arrays.sort(tokens);

    // tracks smallest tokens
    int i = 0;
    // tracks largest tokens
    int j = n - 1;

    int score = 0;
    int maxScore = 0;

    // loop until pointers meet (as we can only play each token at most once)
    while (i <= j) {
      // spend power if possible
      if (p >= tokens[i]) {
        p -= tokens[i];
        score++;
        i++;
      } else {
        if (score == 0) {
          // no power to spend, and no way to gain power, exit
          break;
        }
        p += tokens[j];
        score--;
        j--;
      }
      // need to track max score somehow, as we may end on gaining power (which lost score)
      maxScore = Math.max(maxScore, score);
    }
    return maxScore;
  }
}
