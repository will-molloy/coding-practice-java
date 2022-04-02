package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/number-of-longest-increasing-subsequence>https://leetcode.com/problems/number-of-longest-increasing-subsequence</a>
 *
 * @see P300LongestIncreasingSubsequence
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P673NumberOfLongestIncreasingSubsequence {

  int findNumberOfLis(int[] nums);

  /**
   * Dynamic programming solution.
   *
   * <p>Runtime: O(n<sup>2</sup>)
   *
   * <p>Space: O(n)
   *
   * <p>Key: Tracking 2 things in the dp (in this case length and count).
   *
   * @see <a href=https://www.youtube.com/watch?v=fV-TF4OvZpk>Back To Back SWE's video</a>
   */
  class Dp implements P673NumberOfLongestIncreasingSubsequence {

    @Override
    public int findNumberOfLis(int[] nums) {
      if (nums.length <= 1) {
        return nums.length;
      }

      // dp[i][0] = length of longest subsequence ending with nums[i]
      // dp[i][1] = count of longest subsequences ending with nums[i]
      // (emphasis on longest)
      int[][] dp = new int[nums.length][2];

      // base case
      // count all the singleton subsequences
      for (int i = 0; i < nums.length; i++) {
        dp[i][0] = 1;
        dp[i][1] = 1;
      }

      // recursive case
      // left to right test all nums[i] > nums[j] where i > j, building up the sequences
      for (int i = 1; i < nums.length; i++) {
        for (int j = 0; j < i; j++) {

          if (nums[i] > nums[j]) {
            // nums[i] extends all sequences ending in nums[j]

            if (dp[i][0] == dp[j][0] + 1) {
              // sequences ending with nums[i] and nums[j] are now equal in length
              // e.g. <1, 3, 5, 7> and <1, 3, 4> ++ <7> (nums[i]=7, nums[j]=4)
              // combine the counts
              dp[i][1] += dp[j][1];
            } else if (dp[i][0] < dp[j][0] + 1) {
              // sequences ending with nums[j] will now be longer than those ending with nums[i]
              // e.g. <1, 3, 7> and <1, 3, 5> ++ <7> (nums[i]=7, nums[j]=5)
              // update the length
              // override the count
              dp[i][0] = dp[j][0] + 1;
              dp[i][1] = dp[j][1];
            }
          }
        }
      }

      // count number of sequences with the max length
      int maxLength = 0;
      for (int[] x : dp) {
        maxLength = Math.max(maxLength, x[0]);
      }
      int count = 0;
      for (int[] x : dp) {
        if (x[0] == maxLength) {
          count += x[1];
        }
      }
      return count;
    }
  }

  /**
   * Segment tree solution.
   *
   * <p>Runtime: O(n log n)
   *
   * <p>Space: O(n)
   *
   * <p>Key: Understanding what information the tree is representing.
   *
   * @see <a href=https://leetcode.com/articles/number-of-longest-increasing-subsequence>Leetcode
   *     article</a>
   */
  class SegmentTree implements P673NumberOfLongestIncreasingSubsequence {

    @Override
    public int findNumberOfLis(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int num : nums) {
        min = Math.min(min, num);
        max = Math.max(max, num);
      }
      // segment tree will cover the range [min, max]
      // (will have leaf nodes for every integer : [min, max])
      // each node will hold length/count of the longest increasing subsequences in that range
      Node root = new Node(min, max);
      // for each num : nums (in order), query for the length/count of the greatest range below num
      // this will lead to 'count' additional sequences of length 'length + 1' (since num extends
      // those sequences) so we update the tree with that knowledge
      for (int num : nums) {
        Value v = query(root, num - 1);
        insert(root, num, new Value(v.length + 1, v.count));
      }
      // tree has been updated with knowledge of all nums in order, can return the final count
      return root.val.count;
    }

    // return the value for the range of the specified node, excluding anything above key
    // (we want the node of the greatest range below 'key')
    private Value query(Node node, int key) {
      if (node.end <= key) {
        // key after range, can return
        return node.val;
      } else if (node.start > key) {
        // key before range, return null node value
        return new Value(0, 1);
      } else {
        // key contained within range, query both halves and merge
        return merge(query(node.left(), key), query(node.right(), key));
      }
    }

    // repeatedly insert 'v' into the ranges containing 'key'
    private void insert(Node node, int key, Value v) {
      if (node.start == node.end) {
        // merge and bubble up (leaf node)
        node.val = merge(v, node.val);
      } else {
        if (key <= node.mid()) {
          // insert in left half
          insert(node.left(), key, v);
        } else {
          // insert in right half
          insert(node.right(), key, v);
        }
        // merge and bubble up
        node.val = merge(node.left().val, node.right().val);
      }
    }

    // merge values of adjacent ranges
    // (this how a segment tree works, each parent is a combination of the two children)
    // in this case merge the length/count pairs such that the longest length wins
    private Value merge(Value v1, Value v2) {
      if (v1.length == v2.length) {
        if (v1.length == 0) {
          // null node value
          return new Value(0, 1);
        } else {
          // same length, combine counts
          return new Value(v1.length, v1.count + v2.count);
        }
      }
      // choose the longer sequences
      return v1.length > v2.length ? v1 : v2;
    }

    private static final class Node {
      // [start, end]
      private final int start;
      private final int end;

      private Value val;

      private Node left;
      private Node right;

      Node(int start, int end) {
        this.start = start;
        this.end = end;
        // initially start with null node value (this node could represent a value not in the array,
        // and therefore never produces a sequence, therefore has length 0)
        val = new Value(0, 1);
      }

      int mid() {
        return start + (end - start) / 2;
      }

      // lazy init, also avoids overflow in ctr
      Node left() {
        if (left == null) {
          left = new Node(start, mid());
        }
        return left;
      }

      Node right() {
        if (right == null) {
          right = new Node(mid() + 1, end);
        }
        return right;
      }
    }

    private static final class Value {
      private final int length;
      private final int count;

      Value(int length, int count) {
        this.length = length;
        this.count = count;
      }
    }
  }
}
