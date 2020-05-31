package wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * Created by wilmol on 2020-05-31.
 *
 * <p><a
 * href=https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts>https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/</a>
 *
 * <p>Runtime: O(hn * log(hn) + vn * log(vn))
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Find the largest gaps between array elements (sort arrays first). Cast to {@code long} to
 * avoid integer overflow.
 */
class P1465MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

  private static final int MOD = 1000000007;

  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    int hn = horizontalCuts.length;
    int vn = verticalCuts.length;

    // find largest gaps

    // horizontal prepend 0, append h
    Arrays.sort(horizontalCuts);
    int maxY = Math.max(horizontalCuts[0], h - horizontalCuts[hn - 1]);
    for (int i = 0; i < hn - 1; i++) {
      maxY = Math.max(maxY, horizontalCuts[i + 1] - horizontalCuts[i]);
    }

    // vertical prepend 0, append w
    Arrays.sort(verticalCuts);
    int maxX = Math.max(verticalCuts[0], w - verticalCuts[vn - 1]);
    for (int i = 0; i < vn - 1; i++) {
      maxX = Math.max(maxX, verticalCuts[i + 1] - verticalCuts[i]);
    }

    return (int) ((long) maxX * maxY % MOD);
  }
}
