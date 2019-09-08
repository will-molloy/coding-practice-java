package wilmol.hackerrank.interviewpreparationkit.dictionarieshashmaps.easy;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Will on 24/03/2019
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps>https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps</a>
 *
 * <p>Determine if the strings have a common substring.
 *
 * <p>Runtime: O(s1 + s2) -> O(n)
 */
final class TwoStringsHasCommonSubString {

  private TwoStringsHasCommonSubString() {}

  static boolean hasCommonSubString(String s1, String s2) {
    // just need to check at least one character is common
    Set<Integer> s1Chars = s1.chars().boxed().collect(Collectors.toSet());
    return s2.chars().anyMatch(s1Chars::contains);
  }
}
