package com.wilmol.hackerrank.interview_preparation_kit.hashtables.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Will on 24/03/2019
 * <p>
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 * Determine if the note can be built from the words in the magazine.
 * <p>
 * Runtime:
 */
class RansomNote
{

  static boolean checkMagazine(String[] magazine, String[] note)
  {
    Map<String, Long> wordCountsMagazine = countWords(magazine);
    Map<String, Long> wordCountsNote = countWords(note);
    return wordCountsNote.entrySet().stream()
        .allMatch(e -> wordCountsMagazine.containsKey(e.getKey()) && wordCountsMagazine.get(e.getKey()) >= e.getValue());
  }

  private static Map<String, Long> countWords(String[] magazine)
  {
    return Arrays.stream(magazine)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

}
