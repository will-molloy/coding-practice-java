package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/vowel-spellchecker>https://leetcode.com/problems/vowel-spellchecker/</a>
 *
 * <p>Runtime: O({@code wordList} + {@code queries})
 *
 * <p>Extra memory: O({@code wordList}) - excluding {@code result}
 *
 * <p>Key: Maintain a lookup table for each of the 3 cases:
 *
 * <ol>
 *   <li>When the query is an exact match (hash set of words)
 *   <li>When the query matches case insensitively (hash map of lower case words to original words
 *       in encounter order)
 *   <li>When the query matches case insensitively after replacing vowels (hash map of words with
 *       vowels removed to original words in encounter order)
 * </ol>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P966VowelSpellchecker {

  public String[] spellchecker(String[] wordlist, String[] queries) {
    List<String> result = new ArrayList<>();

    Set<String> wordSet = Arrays.stream(wordlist).collect(Collectors.toUnmodifiableSet());

    Map<String, String> wordSetNoCapitals =
        Arrays.stream(wordlist)
            .collect(
                Collectors.toUnmodifiableMap(
                    s -> s.toLowerCase(Locale.ROOT),
                    Function.identity(),
                    // map the first such match in 'wordList'
                    (first, second) -> first));

    Map<String, String> wordSetNoVowels =
        Arrays.stream(wordlist)
            .collect(
                Collectors.toUnmodifiableMap(
                    s -> removeVowels(s.toLowerCase(Locale.ROOT)),
                    Function.identity(),
                    // map the first such match in 'wordList'
                    (first, second) -> first));

    for (String query : queries) {
      if (wordSet.contains(query)) {
        result.add(query);
        continue;
      }

      String noCapitals = query.toLowerCase(Locale.ROOT);
      String noCapitalsMapping = wordSetNoCapitals.get(noCapitals);
      if (noCapitalsMapping != null) {
        result.add(noCapitalsMapping);
        continue;
      }

      String noVowels = removeVowels(noCapitals);
      String noVowelsMapping = wordSetNoVowels.get(noVowels);
      if (noVowelsMapping != null) {
        result.add(noVowelsMapping);
        continue;
      }

      result.add("");
    }
    return result.toArray(String[]::new);
  }

  private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

  private String removeVowels(String s) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (VOWELS.contains(chars[i])) {
        chars[i] = '.';
      }
    }
    return new String(chars);
  }
}
