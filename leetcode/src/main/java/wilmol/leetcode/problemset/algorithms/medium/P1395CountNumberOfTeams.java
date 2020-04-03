package wilmol.leetcode.problemset.algorithms.medium;

import java.util.TreeSet;

/**
 * Created by wilmol on 2020-04-03.
 *
 * <p><a
 * href=https://leetcode.com/problems/count-number-of-teams>https://leetcode.com/problems/count-number-of-teams</a>
 *
 * <p>Key: figuring out how to compute a 'count' of something (will involve multiplication -
 * cartesian product), in this case number of teams for a given soldier
 */
interface P1395CountNumberOfTeams {

  int numTeams(int[] rating);

  /**
   * Brute force solution. Works on leetcode because maximum n is only 200.
   *
   * <p>Runtime: O(n<sup>3</sup>)
   *
   * <p>Space: O(1)
   */
  class Cubic implements P1395CountNumberOfTeams {

    @Override
    public int numTeams(int[] rating) {
      int count = 0;
      for (int i = 0; i < rating.length - 2; i++) {
        for (int j = i + 1; j < rating.length - 1; j++) {
          for (int k = j + 1; k < rating.length; k++) {
            if ((rating[i] < rating[j] && rating[j] < rating[k])
                || (rating[i] > rating[j] && rating[j] > rating[k])) {
              count += 1;
            }
          }
        }
      }
      return count;
    }
  }

  /**
   * Slightly more optimised solution, now computes team count rather than count all.
   *
   * <p>Runtime: O(n<sup>2</sup>)
   *
   * <p>Space: O(1)
   */
  class Quadratic implements P1395CountNumberOfTeams {

    @Override
    public int numTeams(int[] rating) {
      // rather than count all teams, now compute teams based on:
      // soldier can form n teams where n = lessLeft * greaterRight + greaterLeft * lessRight
      // so just need to count less and greater ratings for each (middle) soldier
      int count = 0;
      for (int i = 1; i < rating.length - 1; i++) {
        int lessLeft = 0;
        int lessRight = 0;
        int greaterLeft = 0;
        int greaterRight = 0;
        for (int j = 0; j < rating.length; j++) {
          if (rating[j] < rating[i]) {
            if (j < i) {
              lessLeft += 1;
            } else {
              lessRight += 1;
            }
          } else if (rating[j] > rating[i]) {
            if (j < i) {
              greaterLeft += 1;
            } else {
              greaterRight += 1;
            }
          }
        }
        int increase = lessLeft * greaterRight;
        int decrease = greaterLeft * lessRight;
        count += increase + decrease;
      }
      return count;
    }
  }

  /**
   * Even more optimised solution. Same idea as {@link Quadratic}, except use BST to more
   * efficiently count less/greater number on left/right side of some soldier.
   *
   * <p>Runtime: O(n log n)
   *
   * <p>Space: O(n)
   */
  class Linearithmic implements P1395CountNumberOfTeams {

    @Override
    public int numTeams(int[] ratings) {
      TreeSet<Integer> left = new TreeSet<>();
      TreeSet<Integer> right = new TreeSet<>();

      for (int rating : ratings) {
        // initially all are on the right (we'll iterate left to right)
        right.add(rating);
      }

      int count = 0;
      for (int rating : ratings) {
        // will not be on the right for the next iterations
        right.remove(rating);

        // TODO apparently the size() calls here are O(n)... but that's just Java's API
        int lessLeft = left.headSet(rating).size();
        int greaterRight = right.tailSet(rating).size();
        int greaterLeft = left.tailSet(rating).size();
        int lessRight = right.headSet(rating).size();

        int increase = lessLeft * greaterRight;
        int decrease = greaterLeft * lessRight;
        count += increase + decrease;

        // will be on the left for next iterations
        left.add(rating);
      }
      return count;
    }
  }
}
