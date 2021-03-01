package com.wilmol.leetcode.problemset.algorithms.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-frequency-stack>https://leetcode.com/problems/maximum-frequency-stack/</a>
 *
 * <p>Runtime: O(1) for all operations
 *
 * <p>Extra memory: O(1) for each element pushed (O(n) for n elements pushed)
 *
 * <p>Key: Store stacks for each frequency. If an element has frequency of {@code n}, it also has
 * frequency of {@code n - 1}, so keep it in stacks mapped by each frequency. Then if its popped,
 * its still maintained in the lower frequency stacks.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P895MaximumFrequencyStack {

  /** FreqStack implementation. */
  static class FreqStack {

    private final HashMap<Integer, Integer> freqs;
    private final HashMap<Integer, Deque<Integer>> stacks;
    // initially used TreeMap for stacks map (maxFreq = stacks.lastKey())
    // but maintaining maxFreq variable is more efficient
    private int maxFreq;

    FreqStack() {
      freqs = new HashMap<>();
      stacks = new HashMap<>();
      maxFreq = 0;
    }

    public void push(int x) {
      int freq = freqs.merge(x, 1, Integer::sum);
      stacks.computeIfAbsent(freq, k -> new ArrayDeque<>()).push(x);
      maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
      Deque<Integer> maxFreqStack = stacks.get(maxFreq);
      int pop = maxFreqStack.pop();

      if (maxFreqStack.isEmpty()) {
        // free memory of 'maxFreq' stack mapping
        stacks.remove(maxFreq);
        // removed only 1 element so new maxFreq is just 1 fewer
        maxFreq--;
      }

      int freq = freqs.merge(pop, -1, Integer::sum);
      if (freq == 0) {
        // free memory of 'pop' freq mapping
        freqs.remove(pop);
      }

      return pop;
    }
  }
}
