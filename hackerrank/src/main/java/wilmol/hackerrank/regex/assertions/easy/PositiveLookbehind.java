package wilmol.hackerrank.regex.assertions.easy;

import java.util.regex.Pattern;
import wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-06 at 21:06.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/positive-lookbehind/problem>https://www.hackerrank.com/challenges/positive-lookbehind/problem</a>
 */
class PositiveLookbehind implements Regex {

  private static final Pattern PATTERN = Pattern.compile("(?<=[13579]\\d)");

  /**
   * (?<=regex_2)regex_1 -> only match regex_1 if it is immediately preceded by regex_2.
   *
   * <p>match digits immediately preceded by odd digits.
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
