package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <a href=https://leetcode.com/problems/goat-latin>https://leetcode.com/problems/goat-latin/</a>
 *
 * <p>Runtime: average O(n), worst O(n<sup>2</sup>), let average word length = w, then there are k =
 * n/w words, complexity is O(n + k<sup>2</sup>), worst case k = n (when w = 1), just see <a
 * href=https://leetcode.com/problems/goat-latin/solution>https://leetcode.com/problems/goat-latin/solution/</a>
 *
 * <p>Extra memory: O(1) (including return value, average O(n), worst O(n<sup>2</sup>), same as time
 * complexity)
 *
 * <p>Key: Transform words one by one.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P824GoatLatin {

  public String toGoatLatin(String s) {
    Pattern vowel = Pattern.compile("[aeiou].*", Pattern.CASE_INSENSITIVE);
    String[] suffix = {"a"};

    return Arrays.stream(s.split(" "))
        .map(
            word -> {
              String newWord;
              if (vowel.matcher(word).matches()) {
                newWord = word;
              } else {
                newWord = word.substring(1) + word.substring(0, 1);
              }
              newWord += "ma" + suffix[0];
              suffix[0] += "a";
              return newWord;
            })
        .collect(Collectors.joining(" "));
  }
}
