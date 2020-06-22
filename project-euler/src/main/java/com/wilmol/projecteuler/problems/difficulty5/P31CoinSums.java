package com.wilmol.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import com.wilmol.projecteuler.problems.difficulty30.P78CoinPartitions;

/**
 * Created by will on 2019-04-13 at 11:26 AM.
 *
 * <p><a href=https://projecteuler.net/problem=31>https://projecteuler.net/problem=31</a>
 *
 * <p>c - num coins, n - amount Runtime: O(c * n) Space: O(n)
 *
 * <p><a href=https://www.youtube.com/watch?v=DJ4a7cmjZY0>this problem, non optimal space
 * solution</a>
 *
 * <p><a href=https://www.youtube.com/watch?v=jgiZlGzXMBw>easier problem, minimum amount of
 * coins</a>
 *
 * @see P78CoinPartitions
 */
public final class P31CoinSums {

  private P31CoinSums() {}

  // note on bottom up approach: https://youtu.be/jgiZlGzXMBw?t=463
  // same as top down, but instead of a recursive call stack
  // an array is used to 'cache' the sub problems, starting from the base case
  // the 'thinking' is the same the 'approach' is different
  static int waysToCreateAmount(int amount, int[] coins) {
    Preconditions.checkArgument(amount >= 0);

    // dynamic programming bottom up solution
    int[] ways = new int[amount + 1];
    // base case, 1 way to create no amount, for any given set of coins
    ways[0] = 1;

    // essentially creating a 2d array
    // rows -> coins considered
    // cols -> amounts
    // e.g. for amount = 5 and the coins [1, 2, 5]:
    // ways[0, 1, 2, 3, 4, 5]
    // [] 1, 0, 0, 0, 0, 0
    // [1] 1, 1, 1, 1, 1, 1
    // [1, 2] 1, 1, 2, 2, 3, 3
    // [1, 2, 5] 1, 1, 2, 2, 3, 4

    // ways[row][col] = ways[row - 1][col] + ways[row][col - coins[row - 1]]
    // i.e. ways = (ways without coin) + (ways with coin)
    // ways without coin = go up row (lose coin), keep same amount
    // ways with coin = stay in row (keep coin), subtract coin from the amount (keep coin)

    // e.g.
    // ways[1][1] = ways[0][1] + ways[1][0] -> 0 + 1 -> 1
    // ways[2][5] = ways[1][5] + ways[2][3] -> 1 + 2 -> 3
    // ways[3][5] = ways[2][5] + ways[3][0] -> 3 + 1 -> 4

    // however, if we go coin by coin, can use 1d array to optimise space
    // the 1d array is the 'rows' in the 2d array above, will be **updated** to the next row during
    // each iteration.

    // loop each coin
    for (int coin : coins) {
      // loop each amount greater/equal than current coin (else get negative array indices)
      for (int i = coin; i <= amount; i++) {
        // **update** the ways for amount 'i':
        // ways(i) = ways(i without coin) + ways(i with coin)
        // since ways(i) = ways(i without coin) (before this iteration)
        // can just say, ways(i) += ways(i with coin)

        // only have to subtract the coin, already in the correct 'row' (only one row)
        int waysWithCoin = ways[i - coin];
        ways[i] += waysWithCoin;
      }
    }
    return ways[amount];
  }
}
