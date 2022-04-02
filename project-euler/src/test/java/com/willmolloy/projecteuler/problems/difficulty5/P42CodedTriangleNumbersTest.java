package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import org.junit.jupiter.api.Test;

/**
 * P42CodedTriangleNumbersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P42CodedTriangleNumbersTest {

  @Test
  void testSingleWord() {
    assertThat(P42CodedTriangleNumbers.countTriangleWords("SKY")).isEqualTo(1L);
  }

  @Test
  void test2000WordsTxtFile() throws IOException {
    BufferedReader reader =
        new BufferedReader(
            new FileReader(
                "src/test/resources/problem_042/p042_words.txt", Charset.defaultCharset()));
    String[] words = reader.lines().iterator().next().replaceAll("\"", "").split(",");
    reader.close();
    assertThat(P42CodedTriangleNumbers.countTriangleWords(words)).isEqualTo(162L);
  }
}
