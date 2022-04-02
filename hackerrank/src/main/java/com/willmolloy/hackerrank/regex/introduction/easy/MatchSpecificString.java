package com.willmolloy.hackerrank.regex.introduction.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/matching-specific-string/problem>https://www.hackerrank.com/challenges/matching-specific-string/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class MatchSpecificString implements Regex {

  private static final Pattern PATTERN = Pattern.compile("hackerrank");

  /** only match this word. */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
