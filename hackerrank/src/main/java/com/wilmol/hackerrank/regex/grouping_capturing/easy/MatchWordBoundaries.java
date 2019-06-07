package com.wilmol.hackerrank.regex.grouping_capturing.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-06 at 14:08
 * <p>
 * https://www.hackerrank.com/challenges/matching-word-boundaries/problem
 */
class MatchWordBoundaries
    implements
    Regex
{
  @Override
  public String regex()
  {
    // \b -> word boundary
    // contains any word between the boundaries in the string (use Matcher.contains() NOT matcher.matches())
    // Can be located:
    // 1. Before first char in string (if it's a word char)
    // 2. After last char in string (if it's a word char)
    // 3. Between two chars in the string (if one is a word char, and one isn't)
    return "\\b[aeiouAEIOU][a-zA-Z]*\\b";
  }
}
