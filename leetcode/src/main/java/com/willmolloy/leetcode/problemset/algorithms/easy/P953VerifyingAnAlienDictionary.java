package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/verifying-an-alien-dictionary>https://leetcode.com/problems/verifying-an-alien-dictionary/</a>
 *
 * <p>Runtime: O({@code order} + sum(word : {@code words})
 *
 * <p>Extra memory: O({@code order})
 *
 * <p>Key idea: Create {@code Map<Character, Integer>} to encode the alien order. Then its a
 * standard 'isSorted' algorithm - check adjacent elements are in order.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P953VerifyingAnAlienDictionary {

  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < order.length(); i++) {
      map.put(order.charAt(i), i);
    }

    Comparator<String> comparator =
        (a, b) -> {
          for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) != b.charAt(i)) {
              return Integer.compare(map.get(a.charAt(i)), map.get(b.charAt(i)));
            }
          }
          return Integer.compare(a.length(), b.length());
        };
    for (int i = 0; i < words.length - 1; i++) {
      if (comparator.compare(words[i], words[i + 1]) > 0) {
        return false;
      }
    }
    return true;
  }
}
