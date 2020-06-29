package com.wilmol.hackerrank.interviewpreparationkit.dictionarieshashmaps.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps>https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Key: Second HashMap to track the frequency counts. Since frequencies are stored as values and
 * value check is O(n) (on maps); this allows O(1) lookup on the values too, allowing O(n) overall
 * to avoid TLE.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class FrequencyQueries {

  private FrequencyQueries() {}

  // modified boilerplate, otherwise get TLE
  static List<Integer> freqQuery(List<int[]> queries) {
    List<Integer> output = new ArrayList<>();

    // track count of values
    Map<Integer, Integer> valueCounts = new HashMap<>();
    // track count of frequencies
    // (count rather than boolean since one value may lose a freq but another retain it)
    Map<Integer, Integer> freqCounts = new HashMap<>();

    for (int[] query : queries) {
      int op = query[0];
      int value = query[1];
      assert value >= 1;

      switch (op) {
        case 1: // insert
          int currentFreq = valueCounts.getOrDefault(value, 0);
          int newFreq = currentFreq + 1;
          valueCounts.put(value, newFreq);
          // don't worry about 0 it's never tested
          freqCounts.put(currentFreq, freqCounts.getOrDefault(currentFreq, 0) - 1);
          freqCounts.put(newFreq, freqCounts.getOrDefault(newFreq, 0) + 1);
          break;
        case 2: // delete (if present)
          currentFreq = valueCounts.getOrDefault(value, 0);
          if (currentFreq > 0) {
            newFreq = currentFreq - 1;
            valueCounts.put(value, valueCounts.get(value) - 1);
            // don't worry about 0 it's never tested
            freqCounts.put(currentFreq, freqCounts.getOrDefault(currentFreq, 0) - 1);
            freqCounts.put(newFreq, freqCounts.getOrDefault(newFreq, 0) + 1);
          }
          break;
        case 3: // check
          if (freqCounts.getOrDefault(value, 0) > 0) {
            output.add(1);
          } else {
            output.add(0);
          }
          break;
        default:
          throw new IllegalArgumentException("Invalid op: " + op);
      }
    }
    return output;
  }
}
