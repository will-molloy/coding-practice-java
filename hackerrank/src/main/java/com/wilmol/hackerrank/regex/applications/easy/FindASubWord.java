package com.wilmol.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Will on 2019-04-07 at 13:18.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/find-substring/problem>https://www.hackerrank.com/challenges/find-substring/problem</a>
 *
 * <p>Runtime: O(nq) (n - num sentences, q - num queries)
 */
final class FindASubWord {

  private FindASubWord() {}

  static List<Long> occurrences(List<String> sentences, List<String> subWords) {
    return subWords.stream()
        .map(subWord -> occurrences(sentences, subWord))
        .collect(Collectors.toList());
  }

  private static long occurrences(List<String> sentences, String subWord) {
    // words occurring within another word
    Pattern p = Pattern.compile("\\w+" + subWord + "\\w+");
    return sentences.stream()
        .mapToInt(
            sentence -> {
              Matcher m = p.matcher(sentence);
              int sentenceCount = 0;
              while (m.find()) {
                sentenceCount += 1;
              }
              return sentenceCount;
            })
        .sum();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

    List<String> sentences = new ArrayList<>();
    List<String> subWords = new ArrayList<>();

    int numSentences = Integer.parseInt(reader.readLine());
    for (int i = 0; i < numSentences; i++) {
      sentences.add(reader.readLine());
    }

    int numQueries = Integer.parseInt(reader.readLine());
    for (int i = 0; i < numQueries; i++) {
      subWords.add(reader.readLine());
    }

    occurrences(sentences, subWords).forEach(System.out::println);
  }
}
