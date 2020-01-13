package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-01-13.
 *
 * <p><a href=https://leetcode.com/problems/add-binary>https://leetcode.com/problems/add-binary</a>
 *
 * <p>Runtime: O(max(a, b))
 *
 * <p>Space: O(max(a, b))
 *
 * <p>Key: double pointer, one for each string, then step by step merge (very similar to merge sort)
 */
class P67AddBinary {

  public String addBinary(String a, String b) {
    StringBuilder result = new StringBuilder();
    int ai = a.length() - 1;
    int bi = b.length() - 1;
    int carry = 0;

    // similar idea to merge sort

    // exhaust first string
    while (ai > -1 && bi > -1) {
      char aChar = a.charAt(ai);
      char bChar = b.charAt(bi);
      if (aChar == '1' && bChar == '1') {
        if (carry == 1) {
          // 1 + 1 + 1 = 11
          carry = 1;
          result.insert(0, '1');
        } else {
          // 0 + 1 + 1 = 10
          carry = 1;
          result.insert(0, '0');
        }
      } else if (aChar == '1' || bChar == '1') {
        if (carry == 1) {
          // 1 + 1 + 0 = 10
          carry = 1;
          result.insert(0, '0');
        } else {
          // 0 + 1 + 0 = 01
          carry = 0;
          result.insert(0, '1');
        }
      } else {
        if (carry == 1) {
          // 0 + 0 + 1 = 01
          carry = 0;
          result.insert(0, '1');
        } else {
          // 0 + 0 + 0 = 00
          carry = 0;
          result.insert(0, '0');
        }
      }
      ai--;
      bi--;
    }

    // exhaust remaining string
    while (ai > -1) {
      char aChar = a.charAt(ai);
      if (aChar == '1') {
        if (carry == 1) {
          // 1 + 1 = 10
          carry = 1;
          result.insert(0, '0');
        } else {
          // 0 + 1 = 01
          carry = 0;
          result.insert(0, '1');
        }
      } else {
        if (carry == 1) {
          // 1 + 0 = 01
          carry = 0;
          result.insert(0, '1');
        } else {
          // 0 + 0 = 00
          carry = 0;
          result.insert(0, '0');
        }
      }
      ai--;
    }
    while (bi > -1) {
      char bChar = b.charAt(bi);
      if (bChar == '1') {
        if (carry == 1) {
          // 1 + 1 = 10
          carry = 1;
          result.insert(0, '0');
        } else {
          // 0 + 1 = 01
          carry = 0;
          result.insert(0, '1');
        }
      } else {
        if (carry == 1) {
          // 1 + 0 = 01
          carry = 0;
          result.insert(0, '1');
        } else {
          // 0 + 0 = 00
          carry = 0;
          result.insert(0, '0');
        }
      }
      bi--;
    }

    // consider leading carry
    if (carry == 1) {
      result.insert(0, '1');
    }

    return result.toString();
  }
}
