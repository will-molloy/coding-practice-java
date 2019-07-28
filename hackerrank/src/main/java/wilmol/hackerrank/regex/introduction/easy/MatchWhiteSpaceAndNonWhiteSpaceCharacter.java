package wilmol.hackerrank.regex.introduction.easy;

import java.util.regex.Pattern;
import wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-04 at 20:09.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/matching-whitespace-non-whitespace-character/problem>https://www.hackerrank.com/challenges/matching-whitespace-non-whitespace-character/problem</a>
 */
class MatchWhiteSpaceAndNonWhiteSpaceCharacter implements Regex {

  private static final Pattern PATTERN = Pattern.compile("(\\S{2}\\s){2}\\S{2}");

  /**
   * \s -> whitespace [\r\n\t\f].
   *
   * <p>\S -> non whitespace.
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
