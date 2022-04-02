package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/destination-city>https://leetcode.com/problems/destination-city/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Answer is set difference of all cities - origin cities. Guaranteed to be single
 * destination city. (I.e. no need to simulate the process of traversing some graph.)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1436DestinationCity {

  public String destCity(List<List<String>> paths) {
    Set<String> origins = new HashSet<>();
    for (List<String> path : paths) {
      // path is size 2: [origin, destination]
      origins.add(path.get(0));
    }

    // only destination = all cities - origin cities (which may be origins and destinations)
    // i.e. only destination which isn't an origin
    for (List<String> path : paths) {
      if (!origins.contains(path.get(1))) {
        return path.get(1);
      }
    }
    throw new IllegalStateException();
  }
}
