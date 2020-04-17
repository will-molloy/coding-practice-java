package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-04-17.
 *
 * <p><a
 * href=https://leetcode.com/problems/1-bit-and-2-bit-characters>https://leetcode.com/problems/1-bit-and-2-bit-characters</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: The two bit character always starts with a 1 (and the one bit character has no 1s) so can
 * just move forward two units when seeing a 1.
 */
class P717OneBitAndTwoBitCharacters {

  public boolean isOneBitCharacter(int[] bits) {
    int i = 0;
    boolean lastIsOneBit = false;
    while (i < bits.length) {
      if (bits[i] == 1) {
        // two bit
        i += 2;
        lastIsOneBit = false;
      } else {
        // one bit
        i += 1;
        lastIsOneBit = true;
      }
    }
    return lastIsOneBit;
  }
}
