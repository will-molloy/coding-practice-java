package com.willmolloy.hackerrank.regex.applications.easy;

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
 * href=https://www.hackerrank.com/challenges/uk-and-us/problem>https://www.hackerrank.com/challenges/uk-and-us/problem</a>
 *
 * <p>Runtime: O(s + w)
 *
 * <p>Key: hashmap to preprocess, and key selection (use what'll be looked up).
 *
 * @see com.willmolloy.hackerrank.regex.applications.medium.FindAWord
 * @see UkAndUsPart2
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class TheBritishAndAmericanStyleOfSpelling {

  private static final Pattern WORD_PATTERN = Pattern.compile("(\\w+?[sz]e)");

  static List<Integer> process(List<String> lines) {
    int numSentences = Integer.parseInt(lines.get(0));
    List<String> sentences = lines.subList(1, numSentences + 1);
    List<String> words = lines.subList(numSentences + 2, lines.size());
    return countWords(sentences, words);
  }

  private static List<Integer> countWords(List<String> sentences, List<String> words) {
    // count potential words into map (use american spelling, since that's whats in words list)
    // O(s)
    Map<String, Integer> map = new HashMap<>();
    for (String sentence : sentences) {
      Matcher wordMatcher = WORD_PATTERN.matcher(sentence);
      while (wordMatcher.find()) {
        String word = wordMatcher.group(1);
        String americanWord = word.substring(0, word.length() - 2) + "ze";
        map.merge(americanWord, 1, Integer::sum);
      }
    }

    // count each word using the O(1) map lookup
    // O(w)
    return words.stream().map(word -> map.getOrDefault(word, 0)).collect(Collectors.toList());
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
      List<String> lines = reader.lines().collect(Collectors.toList());
      List<Integer> wordCounts = process(lines);
      // CHECKSTYLE IGNORE Regexp FOR NEXT 1 LINES
      wordCounts.forEach(System.out::println);
    }
  }

  private TheBritishAndAmericanStyleOfSpelling() {}
}
