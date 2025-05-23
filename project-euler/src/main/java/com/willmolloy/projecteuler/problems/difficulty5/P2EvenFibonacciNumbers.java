package com.willmolloy.projecteuler.problems.difficulty5;

/**
 * <a href=https://projecteuler.net/problem=2>https://projecteuler.net/problem=2</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P2EvenFibonacciNumbers {

  public int apply(int below) {
    int evenFibSum = 0;

    int a = 1;
    int b = 2;
    while (b < below) {
      if (b % 2 == 0) {
        evenFibSum += b;
      }
      int temp = b;
      b = a + b;
      a = temp;
    }
    return evenFibSum;
  }
}
