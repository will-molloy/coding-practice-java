package com.willmolloy.hackerrank.regex.applications.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/find-a-word/problem>https://www.hackerrank.com/challenges/find-a-word/problem</a>
 *
 * <p>Runtime: O(s + w)
 *
 * <p>Key: preprocessing using hashmap, and a simple capturing group.
 *
 * @see com.willmolloy.hackerrank.regex.applications.easy.TheBritishAndAmericanStyleOfSpelling
 * @see com.willmolloy.hackerrank.regex.applications.easy.UkAndUsPart2
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class FindAWord {

  private FindAWord() {}

  private static final Pattern WORD_PATTERN = Pattern.compile("(\\w+)");

  static List<Integer> process(List<String> lines) {
    int numSentences = Integer.parseInt(lines.get(0));
    List<String> sentences = lines.subList(1, numSentences + 1);
    List<String> words = lines.subList(numSentences + 2, lines.size());
    return countWords(sentences, words);
  }

  private static List<Integer> countWords(List<String> sentences, List<String> words) {
    // count all the sentences words into a hashmap, then iterate the words list
    // (this way only process sentences and words once, classic memory trade off)
    // i.e. get O(s + w) rather than O(sw)

    Map<String, Integer> allWordCounts = new HashMap<>();
    for (String sentence : sentences) {
      Matcher wordMatcher = WORD_PATTERN.matcher(sentence);
      while (wordMatcher.find()) {
        String word = wordMatcher.group(1);
        allWordCounts.merge(word, 1, Integer::sum);
      }
    }

    return words.stream()
        .map(word -> allWordCounts.getOrDefault(word, 0))
        .collect(Collectors.toList());
  }

  public static void main(String... args) throws IOException {
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
      List<String> lines = reader.lines().collect(Collectors.toList());
      List<Integer> wordCounts = process(lines);
      // CHECKSTYLE IGNORE Regexp FOR NEXT 1 LINES
      wordCounts.forEach(System.out::println);
    }
  }
}
