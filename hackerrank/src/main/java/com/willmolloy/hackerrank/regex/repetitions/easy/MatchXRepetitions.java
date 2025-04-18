package com.willmolloy.hackerrank.regex.repetitions.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/matching-x-repetitions/problem>https://www.hackerrank.com/challenges/matching-x-repetitions/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MatchXRepetitions implements Regex {

  private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z02468]{40}[13579\\s]{5}$");

  /** {x}, sequence with size x. */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
