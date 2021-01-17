package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/boats-to-save-people>https://leetcode.com/problems/boats-to-save-people/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Greedy. Try pair heaviest person with lightest person, otherwise heaviest person must
 * take their own boat.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P881BoatsToSavePeople {

  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);

    int boats = 0;

    int start = 0;
    int end = people.length - 1;

    while (start <= end) {
      boats++;
      // at most 2 per boat
      // try pair lightest with heaviest (best chance heavy shares a boat)
      if (people[start] + people[end] <= limit) {
        start++;
        end--;
      } else {
        // heavy person must get own boat
        // (save light person to try pair with next heavy)
        end--;
      }
    }
    return boats;
  }
}
