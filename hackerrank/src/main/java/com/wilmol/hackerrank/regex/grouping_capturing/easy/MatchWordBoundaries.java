package com.wilmol.hackerrank.regex.grouping_capturing.easy;

import com.wilmol.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-06 at 14:08
 *
 * <p>https://www.hackerrank.com/challenges/matching-word-boundaries/problem
 */
class MatchWordBoundaries implements Regex {

  private static final Pattern PATTERN = Pattern.compile("\\b[aeiouAEIOU][a-zA-Z]*\\b");

  /**
   * \b -> word boundary
   *
   * <p>contains any word between the boundaries in the string (use Matcher.contains() NOT
   * matcher.matches())
   *
   * <p>Can be located:
   *
   * <p>1. Before first char in string (if it's a word char)
   *
   * <p>2. After last char in string (if it's a word char)
   *
   * <p>3. Between two chars in the string (if one is a word char, and one isn't)
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
