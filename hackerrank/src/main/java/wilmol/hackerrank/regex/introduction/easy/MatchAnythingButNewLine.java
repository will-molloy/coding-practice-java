package wilmol.hackerrank.regex.introduction.easy;

import java.util.regex.Pattern;
import wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-02 at 21:28.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/matching-anything-but-new-line/problem>https://www.hackerrank.com/challenges/matching-anything-but-new-line/problem</a>
 */
class MatchAnythingButNewLine implements Regex {

  private static final Pattern PATTERN = Pattern.compile("...\\....\\....\\....");

  /**
   * . -> anything but new line
   *
   * <p>\. -> escapes '.' (matches only exactly '.')
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
