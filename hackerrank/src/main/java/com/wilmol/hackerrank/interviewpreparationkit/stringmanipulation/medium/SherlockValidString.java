package com.wilmol.hackerrank.interviewpreparationkit.stringmanipulation.medium;

import static java.util.Comparator.comparingLong;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;

/**
 * Created by Will on 30/03/2019.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings>https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings</a>
 *
 * <p>Runtime: O(n)
 */
final class SherlockValidString {

  private SherlockValidString() {}

  // valid if char counts are equal, OR they can be made equal with one deletion
  static boolean isValid(String s) {
    Map<Long, Long> charCountCounts =
        s.chars().mapToObj(c -> (char) c).collect(groupingBy(identity(), counting())).values()
            .stream()
            .collect(groupingBy(identity(), counting()));

    if (charCountCounts.size() == 0 || charCountCounts.size() == 1) {
      // condition is met without any deletions
      return true;
    }
    if (charCountCounts.size() > 2) {
      // more than 2 char counts, impossible to match counts with only one deletion
      return false;
    }

    // two different counts of characters occurred
    // Two cases can fix it:
    // 1: Difference between frequencies is ONE and larger frequency occurred ONCE (delete once from
    // larger freq)
    // e.g. aa bb ccc -> delete 1 c
    // 2: Smaller freq is ONE and occurred ONCE (remove the smaller freq)
    // e.g. aa bb c -> remove the c
    List<Map.Entry<Long, Long>> list =
        charCountCounts.entrySet().stream()
            .sorted(comparingLong(Map.Entry::getKey))
            .collect(toList());
    long smallerCount = list.get(0).getKey();
    long smallerCountCount = list.get(0).getValue();
    long largerCount = list.get(1).getKey();
    long largerCountCount = list.get(1).getValue();
    return (largerCount - smallerCount == 1 && largerCountCount == 1)
        || (smallerCount == 1 && smallerCountCount == 1);
  }
}
