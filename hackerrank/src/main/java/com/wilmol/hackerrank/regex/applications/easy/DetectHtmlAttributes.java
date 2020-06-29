package com.wilmol.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/html-attributes/problem>https://www.hackerrank.com/challenges/html-attributes/problem</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Key: capturing groups to extract entire opening tag, then capturing group to extract
 * attributes using {@code find()}.
 *
 * @see DetectHtmlTags
 * @see com.wilmol.hackerrank.regex.applications.medium.DetectHtmlLinks
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class DetectHtmlAttributes {

  private DetectHtmlAttributes() {}

  // TODO is \\w correct? Should be [a-z\\d] ????

  private static final Pattern TAG_PATTERN = Pattern.compile("<([\\w]+).*?>");

  private static final Pattern ATTRIBUTE_PATTERN = Pattern.compile("([\\w]+)=([\"'])");

  static List<String> extractTags(Stream<String> lines) {
    // use set multimap to inherently filter duplicates
    Map<String, Set<String>> setMultiMap = new HashMap<>();

    lines
        // extract all tags from the line
        .map(TAG_PATTERN::matcher)
        .forEach(
            tagMatcher -> {
              while (tagMatcher.find()) {
                String tag = tagMatcher.group(1);
                String tagAndAttributes = tagMatcher.group(0);
                Set<String> tagAttributes = setMultiMap.computeIfAbsent(tag, k -> new HashSet<>());
                // extract all attributes from the tag
                // (between opening < and >, no attributes in closing tag and may not even be one!)
                Matcher attributeMatcher = ATTRIBUTE_PATTERN.matcher(tagAndAttributes);
                while (attributeMatcher.find()) {
                  String attribute = attributeMatcher.group(1);
                  tagAttributes.add(attribute);
                }
              }
            });
    return sortAndFormat(setMultiMap);
  }

  private static List<String> sortAndFormat(Map<String, Set<String>> setMultiMap) {
    return setMultiMap.entrySet().stream()
        // sort tags lexicographically
        .sorted(Comparator.comparing(Map.Entry::getKey))
        .map(
            e -> {
              String tag = e.getKey();
              Set<String> attributes = e.getValue();
              // sort attributes lexicographically
              return tag + ":" + attributes.stream().sorted().collect(Collectors.joining(","));
            })
        .collect(Collectors.toList());
  }

  private static void printTags(List<String> tags, PrintStream out) {
    tags.forEach(out::println);
  }

  public static void main(String... args) throws IOException {
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
      // initial line won't have any html, don't worry about it
      Stream<String> lines = reader.lines();
      List<String> extractedTagsAndAttributes = extractTags(lines);
      // CHECKSTYLE IGNORE Regexp FOR NEXT 1 LINES
      printTags(extractedTagsAndAttributes, System.out);
    }
  }
}
