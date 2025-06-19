package com.willmolloy.projecteuler.common;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Common string functions.
 *
 * @see java.lang.String
 * @see com.google.common.base.Strings
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public final class Strings {

  private Strings() {}

  /** Reverses a string. */
  public static String reverse(String oldString) {
    StringBuilder newString = new StringBuilder();
    for (int i = oldString.length() - 1; i >= 0; i--) {
      newString.append(oldString.charAt(i));
    }
    return newString.toString();
  }

  /** Compute all permutations of a string (O(n!)). */
  public static List<String> permutations(String string) {
    List<Character> chars = string.chars().mapToObj(c -> (char) c).toList();

    return Collections.permutations(chars)
        .map(list -> list.stream().map(String::valueOf).collect(Collectors.joining()))
        .toList();
  }

  /** Return true if the given string is a palindrome. */
  public static boolean isPalindrome(String n) {
    return IntStream.rangeClosed(0, n.length() / 2)
        .allMatch(i -> n.charAt(i) == n.charAt(n.length() - 1 - i));
  }
}
