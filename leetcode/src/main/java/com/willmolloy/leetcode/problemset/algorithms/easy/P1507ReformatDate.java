package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * <a
 * href=https://leetcode.com/problems/reformat-date>https://leetcode.com/problems/reformat-date/</a>
 *
 * <p>Runtime: O(1)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Remove {@code "(st|nd|rd|th)"} first. {@link DateTimeFormatter} with {@code "d"} formats
 * both 1 and 2 digit days.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1507ReformatDate {

  public String reformatDate(String date) {
    return LocalDate.parse(
            date.replaceAll("(st|nd|rd|th)", ""), DateTimeFormatter.ofPattern("d MMM uuuu"))
        .format(DateTimeFormatter.ofPattern("uuuu-MM-dd"));
  }
}
