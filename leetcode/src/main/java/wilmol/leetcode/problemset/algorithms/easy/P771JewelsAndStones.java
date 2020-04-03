package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-04-03.
 *
 * <p><a
 * href=https://leetcode.com/problems/jewels-and-stones>https://leetcode.com/problems/jewels-and-stones</a>
 *
 * <p>Runtime: O(j + s)
 *
 * <p>Space: O(1)
 *
 * <p>Key: lookup table
 */
class P771JewelsAndStones {

  public int numJewelsInStones(String j, String s) {
    // dump into array for O(1) contains
    // (will only have letters, so j matches "[a-zA-Z]*")
    boolean[] jewels = new boolean[56];
    for (char c : j.toCharArray()) {
      jewels[letterIndex(c)] = true;
    }

    // count
    int count = 0;
    for (char c : s.toCharArray()) {
      if (jewels[letterIndex(c)]) {
        count += 1;
      }
    }
    return count;
  }

  private int letterIndex(char c) {
    // returns index for an array of: [a, z] ++ [A, Z]
    return c > 'Z' ? c - 'a' : c - 'A' + 26;
  }
}
