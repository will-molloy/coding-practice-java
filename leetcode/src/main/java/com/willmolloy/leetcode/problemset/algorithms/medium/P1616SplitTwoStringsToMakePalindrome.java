package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/split-two-strings-to-make-palindrome>https://leetcode.com/problems/split-two-strings-to-make-palindrome/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Get largest common prefix/suffix and test the middle of either string is palindrome
 * (greedy).
 *
 * <p>This works because if a middle creates a palindrome, a smaller middle would also create a
 * palindrome (and with higher probability), so by getting the largest prefix/suffix we only test
 * the smallest middle, improving runtime to O(n) from O(n<sup>2</sup>).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1616SplitTwoStringsToMakePalindrome {

  public boolean checkPalindromeFormation(String a, String b) {
    return check(a, b) || check(b, a);
  }

  // only tests aPrefix + bSuffix so need to call twice
  private boolean check(String a, String b) {
    int n = a.length();

    int ai = 0;
    int bi = n - 1;

    // get largest common aPrefix and bSuffix (greedy) (i.e. aPrefix + bSuffix form a palindrome)
    while (ai < bi && a.charAt(ai) == b.charAt(bi)) {
      ai++;
      bi--;
    }

    // aPrefix a[0, ai] and bSuffix b[bi, n) no longer common
    // test middle of either string (ai, bi) is palindrome to simulate cutting at end of aPrefix and
    // start of bSuffix

    // NOTE (ai, bi) is now [ai, bi] because final while loop iteration moved both pointers

    // cut at ai+1
    // i.e. a[0, ai] + b(ai, bi) + b[bi, n) => a[0, ai] + b(ai, n)
    // we know a[0, ai] + b[bi, n) form a palindrome, just need to test b(ai, bi)
    if (isPalindrome(b, ai, bi)) {
      return true;
    }
    // cut at bi-1
    // i.e. a[0, ai] + a(ai, bi) + b[bi, n) => a[0, bi) + b[bi, n)
    // we know a[0, ai] + b[bi, n) form a palindrome, just need to test a(ai, bi)
    if (isPalindrome(a, ai, bi)) {
      return true;
    }
    return false;
  }

  private boolean isPalindrome(String s, int l, int r) {
    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }
}
