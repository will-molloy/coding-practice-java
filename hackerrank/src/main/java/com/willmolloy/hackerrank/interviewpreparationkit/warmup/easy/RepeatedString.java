package com.willmolloy.hackerrank.interviewpreparationkit.warmup.easy;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup>https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup</a>
 *
 * <p>Print a single integer denoting the number of letter a's in the first n letters of the
 * infinite string created by repeating s infinitely many times.
 *
 * <p>Runtime: O(s) - use multiplication and division to save time
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class RepeatedString {

  private RepeatedString() {}

  static long repeatedString(String string, long n) {
    long numStringsInN = n / string.length();
    long numLowerCaseAsInString = countLowerCaseAs(string);

    // remainder, i.e. size of prefix string
    int remainder = (int) (n % string.length());
    String prefixString = string.substring(0, remainder);
    // could make more efficient by doing loop and counting from prefix at the same time as the
    // overall string
    long numLowerCaseAsInPrefixString = countLowerCaseAs(prefixString);

    return numLowerCaseAsInString * numStringsInN + numLowerCaseAsInPrefixString;
  }

  private static long countLowerCaseAs(String string) {
    return string.chars().filter(c -> c == 'a').count();
  }
}
