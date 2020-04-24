package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-04-25.
 *
 * <p><a
 * href=https://leetcode.com/problems/reverse-string>https://leetcode.com/problems/reverse-string/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: Two pointers moving inwards.
 *
 * @see P541ReverseString2
 * @see P557ReverseWordsInAString3
 */
class P344ReverseString {

  public void reverseString(char[] s) {
    int l = 0;
    int r = s.length - 1;
    while (l < r) {
      swap(s, l, r);
      l++;
      r--;
    }
  }

  private void swap(char[] chars, int a, int b) {
    char temp = chars[a];
    chars[a] = chars[b];
    chars[b] = temp;
  }
}
