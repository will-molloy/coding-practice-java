package com.wilmol.hackerrank.regex.introduction.easy;

import com.wilmol.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-02 at 21:07
 *
 * <p>https://www.hackerrank.com/challenges/matching-specific-string/problem
 */
class MatchSpecificString implements Regex {

  private static final Pattern PATTERN = Pattern.compile("hackerrank");

  /** only match this word */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
