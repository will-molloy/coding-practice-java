package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-04-22.
 *
 * <p><a
 * href=https://leetcode.com/problems/longest-word-in-dictionary>https://leetcode.com/problems/longest-word-in-dictionary/</a>
 *
 * <p>Difficulty: Medium
 *
 * <p>Runtime: O(sum(w: words)) i.e. time to build and traverse trie
 *
 * <p>Space: O(sum(w : words)) i.e. dominated by space of trie
 *
 * <p>Key: Storing word represented by leaf nodes. This serves two purposes, (1) if that node is a
 * leaf and therefore if we can continue with the traversal and (2) what word is represented by that
 * leaf, so can return it directly rather than rebuilding words for each root to leaf path.
 */
class P720LongestWordInDictionary {

  /** Trie root node. */
  private final Node root = new Node();

  public String longestWord(String[] words) {
    // insert all words into the trie
    for (String word : words) {
      insert(word);
    }

    // traverse trie to determine the longest word (which can be built one character at a time)
    return longest(root, "");
  }

  // DFS traversal of trie
  private String longest(Node node, String longest) {
    for (char c = 'a'; c <= 'z'; c++) {
      Node child = node.children[c - 'a'];
      // want word which can be built one character at a time
      // therefore only advance if there is a next character and next character represents a word
      if (child != null && child.word != null) {
        String candidate = longest(child, child.word);
        // want the lexicographically smallest word if there are ties in length
        // therefore only update if longer (we traverse the trie in lexicographical order)
        if (candidate.length() > longest.length()) {
          longest = candidate;
        }
      }
    }
    return longest;
  }

  private void insert(String word) {
    // build path in Trie for "word" starting from root
    Node node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null) {
        node.children[c - 'a'] = new Node();
      }
      node = node.children[c - 'a'];
    }
    // save word (in given words array) represented by this leaf node
    node.word = word;
  }

  /** Trie node. */
  private static class Node {

    /** Pointers to next characters ([a, z]). */
    private final Node[] children = new Node[26];

    /** Word in words array represented by this node (could be null). */
    private String word;
  }
}
