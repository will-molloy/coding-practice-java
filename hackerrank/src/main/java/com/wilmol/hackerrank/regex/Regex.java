package com.wilmol.hackerrank.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Wraps a {@link java.util.regex} {@link Pattern} and {@link Matcher} for convenience.
 *
 * <p>Interface so lambda can be used.
 *
 * <p>Created by Will on 2019-04-02 at 21:10
 *
 * <p>https://regex101.com/
 */
@FunctionalInterface
public interface Regex {

  /**
   * Return the compiled regex pattern.
   *
   * <p>Recommend delegating to a static final field.
   *
   * <p>Note Java requires \\ instead of \ for escaping.
   *
   * @return the regex.
   */
  Pattern pattern();

  private Matcher matcher(String string) {
    return pattern().matcher(string);
  }

  default boolean matches(String string) {
    return pattern().asMatchPredicate().test(string);
  }

  default boolean contains(String string) {
    return pattern().asPredicate().test(string);
  }

  default long matchCount(String string) {
    Matcher m = matcher(string);
    return IntStream.iterate(0, n -> n + 1).takeWhile(n -> m.find()).count();
  }
}
