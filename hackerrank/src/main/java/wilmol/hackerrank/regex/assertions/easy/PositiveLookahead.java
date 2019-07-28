package wilmol.hackerrank.regex.assertions.easy;

import java.util.regex.Pattern;
import wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-06 at 20:49.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/positive-lookahead/problem>https://www.hackerrank.com/challenges/positive-lookahead/problem</a>
 */
class PositiveLookahead implements Regex {

  private static final Pattern PATTERN = Pattern.compile("o(?=oo)");

  /**
   * regex_1(?=regex_2) -> only match regex_1 if it is immediately followed by regex_2.
   *
   * <p>(does not return matches of regex_2).
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
