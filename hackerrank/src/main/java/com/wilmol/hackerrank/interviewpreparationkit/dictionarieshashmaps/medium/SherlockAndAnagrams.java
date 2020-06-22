package com.wilmol.hackerrank.interviewpreparationkit.dictionarieshashmaps.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Will on 24/03/2019.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps>https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps</a>
 *
 * <p>Count the number of anagram pairs in a string
 *
 * <p>Runtime: O(n ^ 2)
 */
final class SherlockAndAnagrams {

  private SherlockAndAnagrams() {}

  static int sherlockAndAnagrams(String s) {
    Map<String, Set<Integer>> map = new HashMap<>();
    // iterate all substrings
    for (int windowSize = 1; windowSize <= s.length(); windowSize++) {
      for (int startIndex = 0; startIndex <= s.length() - windowSize; startIndex++) {
        String subString = s.substring(startIndex, startIndex + windowSize);
        // sort substring to create unique key per anagram
        String sortedSubString = sortString(subString);
        // use set of start indices to avoid duplicates (only want to count a pair if coordinates
        // are different)
        Set<Integer> sortedSubStringStartCount = map.getOrDefault(sortedSubString, new HashSet<>());
        sortedSubStringStartCount.add(startIndex);
        map.put(sortedSubString, sortedSubStringStartCount);
      }
    }
    // count the number of anagram pair combinations
    // i.e. 'n choose 2' for each anagram substring, where n is the number of unique start indices
    return map.values().stream()
        .filter(
            set -> set.size() > 1) // cannot choose 2 from set of size 1 (i.e. no pairing possible)
        .mapToInt(Set::size)
        .map(SherlockAndAnagrams::chooseTwo)
        .sum();
  }

  private static String sortString(String subString) {
    return subString
        .chars()
        .sorted()
        .mapToObj(c -> (char) (c))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  private static int chooseTwo(int n) {
    return chooseK(n, 2);
  }

  private static int chooseK(int n, int k) {
    // recursively to avoid overflows with factorial function
    if (k == 0) {
      return 1;
    }
    return n * chooseK(n - 1, k - 1) / k;
  }
}
