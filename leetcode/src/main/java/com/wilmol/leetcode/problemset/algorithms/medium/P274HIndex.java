package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * <a href=https://leetcode.com/problems/h-index>https://leetcode.com/problems/h-index/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: H index is number of papers, not a number of citations.
 *
 * @see P275HIndex2
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P274HIndex {

  public int hIndex(int[] citations) {
    int n = citations.length;

    // sort so can partition into 2 groups: those that are at most h and those that are at least h
    Arrays.sort(citations);

    // iterate in ascending order,
    // then first valid value found is the maximum (since h gets smaller each iteration)
    for (int i = 0; i < n; i++) {

      // [i, n)
      int h = n - i;

      // problem is a bit confusing...

      // want at least 'h' papers with 'h' citations and the other papers have at most 'h' citations
      // (i.e. h index is a number of papers)

      // h = number of papers with citations >= citations[i] (since array is sorted)
      // therefore if citations[i] >= h, we have 'h' papers with at least h citations
      // and n - h papers with at most h citations

      // e.g.
      // n = 5
      // h         =  5, 4,*3, 2, 1
      // citations = [0, 1, 3, 5, 6]
      // test      = [f, f, t, t, t]

      // e.g.2 (in this case only the first 3 '4's are in the <= group)
      // n = 7
      // h         =  7, 6, 5,*4, 3, 2, 1
      // citations = [4, 4, 4, 4, 4, 4, 5]
      // test      = [f, f, f, t, t, t, t]

      // e.g.3
      // n = 9
      // h         =  9, 8, 7,*6,  5,  4,  3,  2,  1
      // citations = [1, 3, 5, 7, 10, 20, 30, 40, 50]
      // test      = [f, f, f, t,  t,  t,  t,  t,  t]

      // just look at the examples and think about how the citations are put into 2 groups
      // (those <= h and those >= h) for each h value, going in reverse its true then false
      // i.e. its more than this if statement, but also the sorting

      if (citations[i] >= h) {
        return h;
      }
    }
    return 0;
  }
}
