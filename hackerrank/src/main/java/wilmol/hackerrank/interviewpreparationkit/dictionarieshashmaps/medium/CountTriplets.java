package wilmol.hackerrank.interviewpreparationkit.dictionarieshashmaps.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wilmol on 2019-09-22.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps>https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Key: read the problem statement (i < j < k) implies single pass without sorting (to maintain
 * the indices).
 *
 * <p>Also using multiple maps of COUNTS not actual results. (Again, read the problem statement,
 * asks for COUNT of triplets not the actual triplets (HINT HINT HINT).)
 */
interface CountTriplets {

  long countTriplets(List<Long> arr, long ratio);

  /** O(n^3) solution, gets TLE. */
  class NaiveSolution implements CountTriplets {

    @Override
    public long countTriplets(List<Long> arr, long ratio) {
      // dont sort to maintain index

      int triplets = 0;

      // O(n^3), test every combination (with i < j < k)
      for (int i = 0; i < arr.size(); i++) {
        long firstValue = arr.get(i);
        for (int j = i + 1; j < arr.size(); j++) {
          long secondValue = arr.get(j);
          for (int k = j + 1; k < arr.size(); k++) {
            long thirdValue = arr.get(k);
            if (firstValue * ratio == secondValue && secondValue * ratio == thirdValue) {
              triplets += 1;
            }
          }
        }
      }
      return triplets;
    }
  }

  /** O(n) single pass solution using 2 maps to track potential pairs and potential triplets. */
  class LinearSolution implements CountTriplets {

    @Override
    public long countTriplets(List<Long> arr, long ratio) {
      // O(n), single pass, no special cases, no sorting (since i < j < k requirement)

      // key = value needed for 2nd value in triplet (searching a * r)
      // i.e. count of singular values
      Map<Long, Long> potentialPair = new HashMap<>();
      // key = value needed for 3rd value in triplet (searching a * r * r)
      // i.e. count of pairs
      Map<Long, Long> potentialTriplet = new HashMap<>();

      long result = 0;
      for (long value : arr) {
        // update result with number of triplets completed by 'value'
        result += potentialTriplet.getOrDefault(value, 0L);

        // update potentialTriplet count (if 'value' creates a pair)
        if (potentialPair.containsKey(value)) {
          // the number of pairs already formed
          long existingPairCount = potentialTriplet.getOrDefault(value * ratio, 0L);
          // the number of new pairs formed
          long pairCount = potentialPair.get(value);
          potentialTriplet.put(value * ratio, existingPairCount + pairCount);
        }

        // update potentialPair count (always, any value can start a triplet)
        // i.e. simply counting how many triplets could be started by 'value'
        // must do this last, otherwise may form triplet with duplicates
        potentialPair.put(value * ratio, potentialPair.getOrDefault(value * ratio, 0L) + 1);
      }
      return result;
    }
  }
}
