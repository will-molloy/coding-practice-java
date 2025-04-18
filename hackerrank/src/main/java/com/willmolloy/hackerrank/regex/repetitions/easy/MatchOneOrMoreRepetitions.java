package com.willmolloy.hackerrank.regex.repetitions.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/matching-one-or-more-repititions/problem>https://www.hackerrank.com/challenges/matching-one-or-more-repititions/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MatchOneOrMoreRepetitions implements Regex {

  private static final Pattern PATTERN = Pattern.compile("^\\d+[A-Z]+[a-z]+$");

  /** +, sequence with size at least one. */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
