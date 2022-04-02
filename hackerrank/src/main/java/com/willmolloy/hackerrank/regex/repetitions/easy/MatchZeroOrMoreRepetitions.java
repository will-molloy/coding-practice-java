package com.willmolloy.hackerrank.regex.repetitions.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/matching-zero-or-more-repetitions/problem>https://www.hackerrank.com/challenges/matching-zero-or-more-repetitions/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class MatchZeroOrMoreRepetitions implements Regex {

  private static final Pattern PATTERN = Pattern.compile("^\\d{2,}[a-z]*[A-Z]*$");

  /** *, sequence of any size. */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
