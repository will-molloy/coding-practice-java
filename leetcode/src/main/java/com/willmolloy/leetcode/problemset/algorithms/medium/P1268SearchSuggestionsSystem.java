package com.willmolloy.leetcode.problemset.algorithms.medium;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/search-suggestions-system>https://leetcode.com/problems/search-suggestions-system/</a>
 *
 * <p>Runtime: O(c : {@code products}) (total number of characters in {@code products} - time to
 * create trie)
 *
 * <p>Extra memory: O(c : {@code products} + {@code searchWord}) (trie space and output is
 * proportional to size of {@code searchWord})
 *
 * <p>Key idea: Trie. When getting suggestions, traverse down to the prefix then do a DFS.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1268SearchSuggestionsSystem {

  @SuppressFBWarnings("SBSC_USE_STRINGBUFFER_CONCATENATION")
  List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Trie trie = new Trie();
    for (String product : products) {
      trie.insert(product);
    }

    List<List<String>> result = new ArrayList<>();
    String prefix = "";
    for (char c : searchWord.toCharArray()) {
      prefix += c;
      result.add(trie.wordsStartingWith(prefix));
    }
    return result;
  }

  private static final class Trie {
    private final Node root = new Node();

    void insert(String word) {
      Node node = root;
      for (char c : word.toCharArray()) {
        node = node.children.computeIfAbsent(c, k -> new Node());
      }
      node.word = word;
    }

    List<String> wordsStartingWith(String prefix) {
      Node node = root;

      // traverse to end of prefix
      for (char c : prefix.toCharArray()) {
        node = node.children.get(c);
        if (node == null) {
          return List.of();
        }
      }

      // run DFS from prefix
      List<String> result = new ArrayList<>();
      dfs(node, result);
      return result;
    }

    void dfs(Node node, List<String> result) {
      if (result.size() == 3) {
        return;
      }
      if (node.word != null) {
        result.add(node.word);
      }

      // run DFS on all possible paths in lexicographical order
      for (char c = 'a'; c <= 'z'; c++) {
        Node child = node.children.get(c);
        if (child != null) {
          dfs(child, result);
        }
      }
    }

    private static final class Node {
      private final Map<Character, Node> children = new HashMap<>();
      private String word;
    }
  }
}
