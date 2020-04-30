package wilmol.leetcode.problemset.algorithms.unknown;

// TODO categorise and change link when leetcode adds this as an official problem

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by wilmol on 2020-04-30.
 *
 * <p><a
 * href=https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313>https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/</a>
 *
 * <p>TODO Difficulty: Easy?
 *
 * <p>Runtime: O(1) ({@link java.util.HashMap} add, remove, contains, and iterator to get head)
 *
 * <p>Space: O(n)
 *
 * <p>Key: Second set {@code removed} otherwise end up including elements that are added 3 times.
 *
 * @see wilmol.leetcode.problemset.algorithms.medium.P146LruCache
 */
class FirstUnique {

  private final LinkedHashSet<Integer> set = new LinkedHashSet<>();

  private final HashSet<Integer> removed = new HashSet<>();

  FirstUnique(int[] nums) {
    for (int num : nums) {
      add(num);
    }
  }

  public int showFirstUnique() {
    Iterator<Integer> iterator = set.iterator();
    if (iterator.hasNext()) {
      return iterator.next();
    }
    return -1;
  }

  public void add(int value) {
    // no remove operation, so if its added again can just remove
    if (set.contains(value)) {
      set.remove(value);
      removed.add(value);
    } else if (!removed.contains(value)) {
      set.add(value);
    }
  }
}
