package com.willmolloy.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * FindASubWordTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class FindASubWordTest {

  @Test
  void countSubWordsSingleSentenceAndQuery() {
    List<String> sentences = List.of("existing pessimist optimist this is");
    List<String> queries = List.of("is");
    assertThat(FindASubWord.occurrences(sentences, queries)).isEqualTo(List.of(3L));
  }

  @Test
  void onlyCountSubWordsWithinAWord() {
    List<String> sentences =
        List.of("revision rrevision rrevisionn", "gold revision, golden, ggolden", "ggoldd");
    List<String> queries = List.of("revision", "gold");
    assertThat(FindASubWord.occurrences(sentences, queries)).isEqualTo(List.of(1L, 2L));
  }
}
