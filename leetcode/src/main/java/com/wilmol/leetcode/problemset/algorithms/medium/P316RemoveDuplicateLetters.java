package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/remove-duplicate-letters>https://leetcode.com/problems/remove-duplicate-letters/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Going left to right on {@code s}: remove character if it occurs in the string again later
 * and there is a smaller character after it.
 *
 * <p>Precomputing character frequencies to know if a character occurs in the string again later was
 * helpful.
 *
 * @see P1081SmallestSubsequenceOfDistinctCharacters
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P316RemoveDuplicateLetters {

  public String removeDuplicateLetters(String s) {
    // precompute char frequencies to know if a character occurs in the string again later
    // i.e. going to maintain frequency of remaining characters each iteration of the main loop
    int[] freq = new int[26];
    for (char c : s.toCharArray()) {
      freq[c - 'a']++;
    }

    // answer stack - contains the unique characters in encounter order
    Deque<Character> stack = new ArrayDeque<>();
    // set will contain same elements as stack - allows O(1) contains check for stack
    Set<Character> set = new HashSet<>();

    for (char c : s.toCharArray()) {
      // want to maintain frequency of remaining characters, so decrement frequency of c
      freq[c - 'a']--;

      if (set.contains(c)) {
        // c already in answer, want unique characters so stop iteration here
        continue;
      }

      // if c is smaller than the last character which occurs again later in the string remove it,
      // because we want the lexicographically smallest result (smallest characters as the bottom of
      // the stack) and that character will be added back later
      while (!stack.isEmpty() && c < stack.peek() && freq[stack.peek() - 'a'] > 0) {
        char remove = stack.pop();
        set.remove(remove);
      }
      stack.push(c);
      set.add(c);
    }

    // stack to string
    StringBuilder builder = new StringBuilder();
    while (!stack.isEmpty()) {
      builder.append(stack.pop());
    }
    return builder.reverse().toString();
  }
}
