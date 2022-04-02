package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <a
 * href=https://leetcode.com/problems/group-anagrams>https://leetcode.com/problems/group-anagrams/</a>
 *
 * <p>Runtime: O(n), memory trade-off made using hashmap.
 *
 * <p>Key: group -> grouping by -> indicates hashmap, just need to figure out the key.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P49GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    // ListMultimap of anagrams
    Map<AnagramKey, List<String>> anagrams = new HashMap<>();
    for (String str : strs) {
      // compute some key to determine anagrams (e.g. char counts or sorted chars)
      AnagramKey key = new AnagramKey(str);
      anagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }
    // return just the values
    return new ArrayList<>(anagrams.values());
  }

  private static final class AnagramKey {

    private final Map<Character, Integer> charCounts;

    private AnagramKey(String s) {
      Map<Character, Integer> map = new HashMap<>();
      char[] chars = s.toCharArray();
      for (char aChar : chars) {
        map.merge(aChar, 1, Integer::sum);
      }
      charCounts = Collections.unmodifiableMap(map);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      AnagramKey that = (AnagramKey) o;
      return Objects.equals(charCounts, that.charCounts);
    }

    @Override
    public int hashCode() {
      return Objects.hash(charCounts);
    }
  }
}
