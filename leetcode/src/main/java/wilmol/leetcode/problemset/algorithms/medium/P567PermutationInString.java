package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-05-18.
 *
 * <p><a
 * href=https://leetcode.com/problems/permutation-in-string>https://leetcode.com/problems/permutation-in-string/</a>
 *
 * <p>Runtime: O(s1 + s2)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Sliding window. Same idea as {@link P438FindAllAnagramsInAString}.
 *
 * @see wilmol.leetcode.problemset.algorithms.hard.P76MinimumWindowSubstring
 * @see P438FindAllAnagramsInAString
 */
class P567PermutationInString {

  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }

    int[] chars = new int[26];
    // overall balance, when a character goes in/out of balance then decrement/increment this
    // avoids need to constantly check the array sums to 0
    int balance = 0;

    // initial window
    int window = s1.length();
    for (int i = 0; i < window; i++) {
      chars[charIndex(s1, i)]++;
      if (chars[charIndex(s1, i)] == 1) {
        // out of balance
        balance++;
      }
    }
    for (int i = 0; i < window; i++) {
      chars[charIndex(s2, i)]--;
      if (chars[charIndex(s2, i)] == 0) {
        // in balance
        balance--;
      }
    }
    if (balance == 0) {
      return true;
    }

    // sliding window
    for (int i = window; i < s2.length(); i++) {
      // remove start of window
      chars[charIndex(s2, i - window)]++;
      if (chars[charIndex(s2, i - window)] == 1) {
        balance++;
      }
      // add new end of window
      chars[charIndex(s2, i)]--;
      if (chars[charIndex(s2, i)] == 0) {
        balance--;
      }
      if (balance == 0) {
        return true;
      }
    }

    return false;
  }

  private static int charIndex(String s, int i) {
    return s.charAt(i) - 'a';
  }
}
