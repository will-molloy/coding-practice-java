package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/find-common-characters>https://leetcode.com/problems/find-common-characters/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key idea: Compute minimum character frequency.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
sealed interface P1002FindCommonCharacters {

  List<String> commonChars(String[] a);

  /** Solution which uses arrays to store character frequencies and loops to compute them. */
  final class ArraysAndLoops implements P1002FindCommonCharacters {

    @Override
    public List<String> commonChars(String[] a) {
      int n = a.length;

      // count chars in every string
      int[][] freqss = new int[n][26];
      for (int i = 0; i < n; i++) {
        for (char c : a[i].toCharArray()) {
          freqss[i][c - 'a']++;
        }
      }

      // compute the minimum count for each char
      int[] minFreqs = new int[26];
      Arrays.fill(minFreqs, Integer.MAX_VALUE);
      for (int[] freqs : freqss) {
        for (int i = 0; i < 26; i++) {
          minFreqs[i] = Math.min(minFreqs[i], freqs[i]);
        }
      }

      // convert to required output
      List<String> result = new ArrayList<>();
      for (char c = 'a'; c <= 'z'; c++) {
        for (int i = 0; i < minFreqs[c - 'a']; i++) {
          result.add(Character.toString(c));
        }
      }
      return result;
    }
  }

  /**
   * Solution which uses maps to store character frequencies and streams to compute them.
   *
   * <p>Unfortunately there is no {@code CharStream} so have to use a loop to get the character
   * range [a, z].
   */
  final class MapsAndStreams implements P1002FindCommonCharacters {

    @Override
    public List<String> commonChars(String[] a) {
      Map<Character, Long> identityFreqs = new HashMap<>();
      for (char c = 'a'; c <= 'z'; c++) {
        identityFreqs.put(c, Long.MAX_VALUE);
      }
      return Arrays.stream(a)
          // count chars in every string
          .map(
              s ->
                  s.chars()
                      .mapToObj(c -> (char) c)
                      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())))
          // compute the minimum count for each char
          .reduce(
              identityFreqs,
              (freqsA, freqsB) -> {
                Map<Character, Long> mergedFreqs = new HashMap<>();
                for (char c = 'a'; c <= 'z'; c++) {
                  mergedFreqs.put(
                      c, Math.min(freqsA.getOrDefault(c, 0L), freqsB.getOrDefault(c, 0L)));
                }
                return mergedFreqs;
              })
          // convert to required output
          .entrySet()
          .stream()
          .flatMap(
              e -> IntStream.range(0, e.getValue().intValue()).mapToObj(i -> e.getKey().toString()))
          .collect(Collectors.toList());
    }
  }
}
