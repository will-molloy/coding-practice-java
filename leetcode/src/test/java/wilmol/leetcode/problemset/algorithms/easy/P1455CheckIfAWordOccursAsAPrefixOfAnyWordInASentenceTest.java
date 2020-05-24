package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-05-24. */
class P1455CheckIfAWordOccursAsAPrefixOfAnyWordInASentenceTest {

  private final P1455CheckIfAWordOccursAsAPrefixOfAnyWordInASentence p1455 =
      new P1455CheckIfAWordOccursAsAPrefixOfAnyWordInASentence();

  @ParameterizedTest
  @MethodSource
  void examples(String sentence, String searchWord, int expected) {
    assertThat(p1455.isPrefixOfWord(sentence, searchWord)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("i love eating burger", "burg", 4),
        Arguments.of("this problem is an easy problem", "pro", 2),
        Arguments.of("i am tired", "you", -1),
        Arguments.of("i use triple pillow", "pill", 4),
        Arguments.of("hello from the other side", "they", -1));
  }
}
