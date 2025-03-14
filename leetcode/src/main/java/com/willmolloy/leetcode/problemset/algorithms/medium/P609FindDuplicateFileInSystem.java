package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://leetcode.com/problems/find-duplicate-file-in-system>https://leetcode.com/problems/find-duplicate-file-in-system/</a>
 *
 * <p>Runtime: O(p)
 *
 * <p>Extra memory: O(p)
 *
 * <p>Key idea: Map of [file contents -> file names].
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P609FindDuplicateFileInSystem {

  public List<List<String>> findDuplicate(String[] paths) {
    // map of [file contents -> file names]
    Map<String, Set<String>> map = new HashMap<>();

    Pattern filePattern = Pattern.compile("(.*?)\\((.*?)\\)");

    for (String path : paths) {
      String[] split = path.split(" ");
      String directoryName = split[0];
      for (int i = 1; i < split.length; i++) {
        Matcher m = filePattern.matcher(split[i]);
        m.matches();
        String fileName = m.group(1);
        String contents = m.group(2);
        map.computeIfAbsent(contents, k -> new HashSet<>()).add(directoryName + "/" + fileName);
      }
    }

    List<List<String>> result = new ArrayList<>();
    for (Set<String> c : map.values()) {
      // filter for duplicate files
      if (c.size() > 1) {
        result.add(List.copyOf(c));
      }
    }
    return result;
  }
}
