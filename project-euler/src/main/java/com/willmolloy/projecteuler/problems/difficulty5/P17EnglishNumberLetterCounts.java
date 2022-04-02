package com.willmolloy.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=17>https://projecteuler.net/problem=17</a>
 *
 * <p>Runtime: O(to - from)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P17EnglishNumberLetterCounts {

  public int apply(int from, int to) {
    Preconditions.checkArgument(to >= from);

    return IntStream.rangeClosed(from, to)
        .mapToObj(this::toEnglish)
        .map(s -> s.replaceAll("[-\\s++]", ""))
        .mapToInt(String::length)
        .sum();
  }

  private String toEnglish(final int n) {
    Preconditions.checkArgument(n >= 1 && n <= 1000);
    final String s = String.valueOf(n);
    final int head = Character.getNumericValue(s.charAt(0));
    final int tail = s.length() > 1 ? Integer.parseInt(s.substring(1)) : -1;

    if (n == 1000) {
      return "one thousand";
    }
    if (n > 99) {
      return toEnglish(head) + " hundred " + hundredsExtra(tail);
    }
    if (n > 19) {
      if (head > 5 && head != 8) {
        return toEnglish(head) + nonTeensTensExtra(tail);
      }
      switch (head) {
        case 8:
          return "eigh" + nonTeensTensExtra(tail);
        case 5:
          return "fif" + nonTeensTensExtra(tail);
        case 4:
          return "for" + nonTeensTensExtra(tail);
        case 3:
          return "thir" + nonTeensTensExtra(tail);
        case 2:
          return "twen" + nonTeensTensExtra(tail);
        default:
          throw new AssertionError();
      }
    }
    if (n > 13 && n != 15 && n != 18) {
      return toEnglish(tail) + "teen";
    }
    switch (n) {
      case 18:
        return "eighteen";
      case 15:
        return "fifteen";
      case 13:
        return "thirteen";
      case 12:
        return "twelve";
      case 11:
        return "eleven";
      case 10:
        return "ten";
      case 9:
        return "nine";
      case 8:
        return "eight";
      case 7:
        return "seven";
      case 6:
        return "six";
      case 5:
        return "five";
      case 4:
        return "four";
      case 3:
        return "three";
      case 2:
        return "two";
      case 1:
        return "one";
      default:
        return "";
    }
  }

  private String hundredsExtra(int tail) {
    return tail > 0 ? " and " + toEnglish(tail) : "";
  }

  private String nonTeensTensExtra(int tail) {
    return "ty" + (tail > 0 ? "-" + toEnglish(tail) : "");
  }
}
