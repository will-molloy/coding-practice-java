package com.wilmol.hackerrank.interview_preparation_kit.warmup.easy;

/**
 * Created by Will on 24/03/2019
 * <p>
 * Print a single integer denoting the number of letter a's in the first n letters of the infinite string created by
 * repeating s infinitely many times.
 * <p>
 * Runtime: O(s) - use multiplication and division to save time
 */
class RepeatedString
{

  static long repeatedString(String string, long n)
  {
    long numStringsInN = n / string.length();
    long numLowerCaseAsInString = countLowerCaseAs(string);

    // remainder, i.e. size of prefix string
    int remainder = (int) (n % string.length());
    String prefixString = string.substring(0, remainder);
    // could make more efficient by doing loop and counting from prefix at the same time as the overall string
    long numLowerCaseAsInPrefixString = countLowerCaseAs(prefixString);

    return numLowerCaseAsInString * numStringsInN + numLowerCaseAsInPrefixString;
  }

  private static long countLowerCaseAs(String string)
  {
    return string.chars().filter(c -> c == 'a').count();
  }

}
