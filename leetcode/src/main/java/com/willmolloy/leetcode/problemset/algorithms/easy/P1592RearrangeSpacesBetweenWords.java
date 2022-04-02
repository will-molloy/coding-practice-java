package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/rearrange-spaces-between-words>https://leetcode.com/problems/rearrange-spaces-between-words/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Count spaces per word and extra spaces and then reconstruct.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1592RearrangeSpacesBetweenWords {

  public String reorderSpaces(String text) {
    String[] words = text.trim().split(" +");
    int spacesCount = 0;
    for (char c : text.toCharArray()) {
      if (c == ' ') {
        spacesCount++;
      }
    }

    if (words.length == 1) {
      return words[0] + " ".repeat(spacesCount);
    }

    int per = spacesCount / (words.length - 1);
    int extra = spacesCount % (words.length - 1);
    return String.join(" ".repeat(per), words) + " ".repeat(extra);
  }
}
