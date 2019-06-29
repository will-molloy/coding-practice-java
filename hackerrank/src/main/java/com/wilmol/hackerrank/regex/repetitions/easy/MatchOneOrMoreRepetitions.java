package com.wilmol.hackerrank.regex.repetitions.easy;

import com.wilmol.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-06 at 13:55
 *
 * <p>https://www.hackerrank.com/challenges/matching-one-or-more-repititions/problem
 */
class MatchOneOrMoreRepetitions implements Regex {

  private static final Pattern PATTERN = Pattern.compile("^\\d+[A-Z]+[a-z]+$");

  /** +, sequence with size at least one. */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
