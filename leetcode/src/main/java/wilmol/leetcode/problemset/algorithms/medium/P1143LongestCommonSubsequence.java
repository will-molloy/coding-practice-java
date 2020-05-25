package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-04-21.
 *
 * <p><a
 * href=https://leetcode.com/problems/longest-common-subsequence>https://leetcode.com/problems/longest-common-subsequence/</a>
 *
 * <p>Difficulty: Medium.
 *
 * <p>Runtime: O(text1 * text2)
 *
 * <p>Space: O(text1 * text2) TODO can use O(min(text1, text2)) space
 *
 * <p>Key: Need to loop to {@link String#length} because empty string is covered by i/j = 0, so we
 * are always off (ahead) by 1.
 *
 * <p>See also: Page 390 of "Introduction to Algorithms" (CLRS, 3rd edition)
 *
 * @see P1035UncrossedLines
 * @see wilmol.leetcode.problemset.algorithms.hard.P1458MaxDotProductOfTwoSubsequences
 */
class P1143LongestCommonSubsequence {

  public int longestCommonSubsequence(String text1, String text2) {
    // dp[i][j] = length of LCS for text1[0, i) and text2[0, j)
    int[][] dp = new int[text1.length() + 1][text2.length() + 1];

    // base case is dp[i][0] = 0 and dp[0][j] = 0
    // (no CS when one string is empty)

    // bottom up dp
    for (int i = 1; i <= text1.length(); i++) {
      for (int j = 1; j <= text2.length(); j++) {
        // i - 1 and j - 1 is just because we are using i = 0 and j = 0 for empty string case
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          // can extend LCS
          // i.e. the one represented by dp[i - 1][j - 1] (one character previous)
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          // unable to extend LCS, take previous max
          // this covers the case text1[0, i) is an LCS or text2[0, j) is an LCS
          // or neither are (the dp table would just hold an even older max)
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[text1.length()][text2.length()];
  }
}
