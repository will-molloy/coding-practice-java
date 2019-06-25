package com.wilmol.hackerrank.interview_preparation_kit.string_manipulation.easy;

import static java.util.function.Predicate.not;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Will on 30/03/2019
 *
 * <p>https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 *
 * <p>Count number of character deletions required to make the strings anagrams of each other.
 *
 * <p>Runtime: O(n) (~3 passes)
 */
class MakingAnagrams {

  static int makeAnagram(String a, String b) {
    Map<Character, Long> aCharCounts = countChars(a);
    Map<Character, Long> bCharCounts = countChars(b);
    Map<Character, Long> absCharDifferences = new HashMap<>();

    aCharCounts.forEach(
        (key, value) -> charCountDifference(bCharCounts, absCharDifferences).accept(key, value));

    bCharCounts.entrySet().stream()
        // already processed those in String a
        .filter(not(e -> aCharCounts.containsKey(e.getKey())))
        .forEach(
            e ->
                charCountDifference(aCharCounts, absCharDifferences)
                    .accept(e.getKey(), e.getValue()));

    return absCharDifferences.values().stream().mapToInt(Long::intValue).sum();
  }

  private static Map<Character, Long> countChars(String s) {
    return s.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  private static BiConsumer<Character, Long> charCountDifference(
      Map<Character, Long> thatMap, Map<Character, Long> aggregator) {
    return (charInThis, countInThis) -> {
      long countInThat = thatMap.getOrDefault(charInThis, 0L);
      aggregator.put(charInThis, Math.abs(countInThis - countInThat));
    };
  }
}
