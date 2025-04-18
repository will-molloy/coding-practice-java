package com.willmolloy.leetcode.problemset.algorithms.hard;

/**
 * <a href=https://leetcode.com/problems/poor-pigs>https://leetcode.com/problems/poor-pigs/</a>
 *
 * <p>TODO Runtime: O()
 *
 * <p>TODO Extra memory: O()
 *
 * <p>Key idea: Each pig can help with {@code minutesToTest / minutesToDie + 1} tests. By arranging
 * buckets into a square/cube etc we can eliminate several per test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P458PoorPigs {

  // want to find the bucket which has poison (exactly one does)
  // after drinking, within 'minutesToDie' a pig is either alive or dead
  // a pig can drink from any number of buckets simultaneously

  // using 1 pig doesn't always work:
  // drink all buckets at once, it dies - we don't know which bucket it is
  // drink buckets one by one - we possibly run out of time

  // using n pigs does work:
  // each drinks from one - one that died must be that bucket
  // BUT this is not the minimum number of pigs

  // we can bring this 'n' down by eliminating entire rows/cols of buckets
  // e.g. 25 buckets, 15 mins to die, 60 mins to test
  // can fit 4 (60/15) tests per pig
  // actually 5 tests, if pig survives 4 tests remaining must contain poison
  // (clearly want to maximise this 'tests per pig', 1 test per pig puts us back at n pigs)
  // so arrange the 25 buckets in 5x5 grid
  // using 2 pigs: 1 drinks row by row, other col by col
  // if a pig dies we know its that row and same for col
  // (and if the pig(s) survive it must be the remaining row/col)

  // can extend this 'square' to a 'cube' etc

  // therefore answer is minimum x such that (T+1)^x >= N
  // where T (tests per pig) = minutesToTest / minutesToDie + 1

  public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
    int pigs = 0;
    while (Math.pow(minutesToTest / minutesToDie + 1, pigs) < buckets) {
      pigs++;
    }
    return pigs;
  }
}
