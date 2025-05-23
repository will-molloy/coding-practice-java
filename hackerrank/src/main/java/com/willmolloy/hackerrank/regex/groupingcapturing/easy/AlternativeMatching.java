package com.willmolloy.hackerrank.regex.groupingcapturing.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/alternative-matching/problem>https://www.hackerrank.com/challenges/alternative-matching/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class AlternativeMatching implements Regex {

  private static final Pattern PATTERN = Pattern.compile("^(M(r(|s)|s)|[DE]r)\\.[a-zA-Z]+$");

  /** | in capturing group -> match single item out of the possibilities. */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
