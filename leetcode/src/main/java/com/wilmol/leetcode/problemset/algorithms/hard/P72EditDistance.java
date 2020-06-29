package com.wilmol.leetcode.problemset.algorithms.hard;

/**
 * <a
 * href=https://leetcode.com/problems/edit-distance>https://leetcode.com/problems/edit-distance/</a>
 *
 * <p>Runtime: O(w1 * w2)
 *
 * <p>Extra space: O(w1 * w2)
 *
 * <p>Key: Not hard to code (top down vs bottom up etc.); tricky part is coming up with the
 * recurrence.
 *
 * <p>The key here is realising we have 3 choices: insert/delete/replace (and a 4th choice - 'do
 * nothing') and we want the cheapest one (one with the least operations to achieve that 'overall'
 * operation).
 *
 * <p>Drawing out the DP table helps; but knowing what is possible and where to start comes with
 * experience/practice as you gain intuition.
 *
 * @see <a href=https://youtu.be/MiqoA-yF-0M>Back To Back SWE's video</a>
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P72EditDistance {

  public int minDistance(String word1, String word2) {
    int w1 = word1.length();
    int w2 = word2.length();

    // dp[i][j] = answer considering word1[0, i) and word2[0, j)
    // i.e. min cost to convert first i characters of word1 to first j characters of word2
    int[][] dp = new int[w1 + 1][w2 + 1];

    // base case:
    // dp[0][0] = 0 (do nothing to convert empty string to empty string)
    // converting from empty string: can only insert characters
    for (int j = 1; j <= w2; j++) {
      // insert word2[j-1]
      dp[0][j] = dp[0][j - 1] + 1;
    }
    // converting to empty string: can only delete characters
    for (int i = 1; i <= w1; i++) {
      // delete word1[i-1]
      dp[i][0] = dp[i - 1][0] + 1;
    }

    // recursive case:
    for (int i = 1; i <= w1; i++) {
      for (int j = 1; j <= w2; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          // character matches, just bubble up previous result
          // (i.e. no operation needed, the answer is the same as ignoring this character)
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          // character doesn't match, pick cheapest operation

          // find edit distance from word1[0, i) to word2[0, j-1) and then insert word2[j-1]
          int insert = dp[i][j - 1];

          // find edit distance from word1[0, i-1) to word2[0, j) and then delete word1[i-1]
          int delete = dp[i - 1][j];

          // find edit distance from word1[0, i-1) to word2[0, j-1) and then delete word1[i-1] and
          // insert word2[j-1] (we do this as one 'replace' operation)
          int replace = dp[i - 1][j - 1];

          // the operations are made up of operations, so we add 1 to get the total cost of
          // performing an additional operation
          // basically, there are many ways to edit word1 such that it becomes word2, we just want
          // the cheapest way (i.e. the min edit distance)
          // so we take the answers of these 3 subproblems and build upon them by taking the min
          // (i.e. we exhibit optimal substructure)
          dp[i][j] = min(insert, delete, replace) + 1;
        }
      }
    }

    return dp[w1][w2];
  }

  private static int min(int a, int b, int c) {
    return Math.min(Math.min(a, b), c);
  }
}
