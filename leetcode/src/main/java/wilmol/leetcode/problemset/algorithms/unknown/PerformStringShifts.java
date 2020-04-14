package wilmol.leetcode.problemset.algorithms.unknown;

// TODO categorise and change link when leetcode adds this as an official problem

/**
 * Created by wilmol on 2020-04-14.
 *
 * <p><a
 * href=https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299>https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299</a>
 *
 * <p>Runtime: O(s + shifts) (think {@link String#substring} runs in O(n)?)
 *
 * <p>Space: O(s) ({@link String#substring} creates {@code new} {@link String}s)
 *
 * <p>Key: Easier to combine {@code suffix + prefix} than do array rotation.
 */
class PerformStringShifts {

  public String stringShift(String s, int[][] shifts) {
    // collapse all the shifts into one operation
    // let left shift be negative, right positive
    int shift = 0;
    for (int[] x : shifts) {
      if (x[0] == 0) {
        shift -= x[1];
      } else {
        shift += x[1];
      }
    }

    // perform the shift
    boolean leftShift = shift < 0;
    shift = Math.abs(shift) % s.length();
    if (shift == 0) {
      return s;
    }
    if (leftShift) {
      // left shift, place prefix of size 'shift' at the end
      String prefix = s.substring(0, shift);
      String suffix = s.substring(shift);
      return suffix + prefix;
    } else {
      // right shift, place suffix of size 'shift' at the beginning
      String suffix = s.substring(s.length() - shift);
      String prefix = s.substring(0, s.length() - shift);
      return suffix + prefix;
    }
  }
}
