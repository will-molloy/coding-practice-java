package com.willmolloy.leetcode.problemset.algorithms.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/substring-with-concatenation-of-all-words>https://leetcode.com/problems/substring-with-concatenation-of-all-words</a>
 *
 * <p>Runtime: O(s.length * words.length) TODO can be O(s.length)... but quite complex, see leetcode
 * discussions
 *
 * <p>Space: O(s.length)
 *
 * <p>Key idea: map to track required count, and map to track seen count for each starting index
 *
 * @see P76MinimumWindowSubstring
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P30SubstringWithConcatenationOfAllWords {

  // based off:
  // https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13658/Easy-Two-Map-Solution-(C%2B%2BJava)

  // words are all of the same length, so finding a substring of size words[0].length * words.length

  public List<Integer> findSubstring(String s, String[] words) {
    if (words.length == 0 || s.isEmpty()) {
      return Collections.emptyList();
    }

    Map<String, Integer> required =
        Arrays.stream(words)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(x -> 1)));

    List<Integer> indices = new ArrayList<>();
    int wordLength = words[0].length();

    // outer loop is O(s.length)
    for (int i = 0; i <= s.length() - words.length * wordLength; i++) {
      Map<String, Integer> seen = new HashMap<>();
      // inner loop is O(words.length)
      int j;
      for (j = 0; j < words.length; j++) {
        String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
        Integer requiredCount = required.get(word);
        if (requiredCount != null) {
          Integer seenCount = seen.getOrDefault(word, 0) + 1;
          seen.put(word, seenCount);
          if (seenCount > requiredCount) {
            // sequence broke, saw word more times than required
            break;
          }
        } else {
          // sequence broke, saw a word not in required set
          break;
        }
      }
      if (j == words.length) {
        // saw all words, in sequence, with nothing in between
        indices.add(i);
      }
    }
    return indices;
  }
}
