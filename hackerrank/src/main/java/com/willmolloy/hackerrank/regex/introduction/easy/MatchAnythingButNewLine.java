package com.willmolloy.hackerrank.regex.introduction.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/matching-anything-but-new-line/problem>https://www.hackerrank.com/challenges/matching-anything-but-new-line/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class MatchAnythingButNewLine implements Regex {

  private static final Pattern PATTERN = Pattern.compile("...\\....\\....\\....");

  /**
   * . -> anything but new line
   *
   * <p>\. -> escapes '.' (matches only exactly '.')
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
