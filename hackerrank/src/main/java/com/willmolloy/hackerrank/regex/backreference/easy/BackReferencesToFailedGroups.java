package com.willmolloy.hackerrank.regex.backreference.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/backreferences-to-failed-groups/problem>https://www.hackerrank.com/challenges/backreferences-to-failed-groups/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class BackReferencesToFailedGroups implements Regex {

  private static final Pattern PATTERN = Pattern.compile("^\\d{2}(-?)(\\d{2}\\1){2}\\d{2}$");

  /**
   * \1 will match either '-' or ''
   *
   * <p>i.e. only match '-' if it occurred previously (perfect use case for back reference)
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
