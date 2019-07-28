package wilmol.hackerrank.regex.repetitions.easy;

import java.util.regex.Pattern;
import wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-06 at 13:55.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/matching-one-or-more-repititions/problem>https://www.hackerrank.com/challenges/matching-one-or-more-repititions/problem</a>
 */
class MatchOneOrMoreRepetitions implements Regex {

  private static final Pattern PATTERN = Pattern.compile("^\\d+[A-Z]+[a-z]+$");

  /** +, sequence with size at least one. */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
