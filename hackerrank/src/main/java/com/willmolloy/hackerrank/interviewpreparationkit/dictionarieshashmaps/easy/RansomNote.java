package com.willmolloy.hackerrank.interviewpreparationkit.dictionarieshashmaps.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps>https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps</a>
 *
 * <p>Determine if the note can be built from the words in the magazine.
 *
 * <p>Runtime:
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class RansomNote {

  private RansomNote() {}

  static boolean checkMagazine(String[] magazine, String[] note) {
    Map<String, Long> wordCountsMagazine = countWords(magazine);
    Map<String, Long> wordCountsNote = countWords(note);
    return wordCountsNote.entrySet().stream()
        .allMatch(
            e ->
                wordCountsMagazine.containsKey(e.getKey())
                    && wordCountsMagazine.get(e.getKey()) >= e.getValue());
  }

  private static Map<String, Long> countWords(String[] magazine) {
    return Arrays.stream(magazine)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }
}
