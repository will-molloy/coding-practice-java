package wilmol.hackerrank.regex.groupingcapturing.easy;

import java.util.regex.Pattern;
import wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-06 at 15:22.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/alternative-matching/problem>https://www.hackerrank.com/challenges/alternative-matching/problem</a>
 */
class AlternativeMatching implements Regex {

  private static final Pattern PATTERN = Pattern.compile("^(M(r(|s)|s)|[DE]r)\\.[a-zA-Z]+$");

  /** | in capturing group -> match single item out of the possibilities. */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
