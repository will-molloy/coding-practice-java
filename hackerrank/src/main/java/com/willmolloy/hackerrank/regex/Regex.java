package com.willmolloy.hackerrank.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Wraps a {@link java.util.regex} {@link Pattern} and {@link Matcher} for convenience.
 *
 * <p>Interface so lambda can be used.
 *
 * <p><a href=https://regex101.com>https://regex101.com</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
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

  /**
   * Determines if the given String matches this Regex.
   *
   * @param string string to test
   * @return {@code true} if the string matches this regex otherwise {@code false}
   * @see Matcher#matches()
   */
  default boolean matches(String string) {
    return pattern().matcher(string).matches();
  }

  /**
   * Determines if any substring in the given String matches this Regex.
   *
   * @param string string to test
   * @return {@code true} if any substring in the string matches this regex otherwise {@code false}
   * @see Matcher#find()
   */
  default boolean contains(String string) {
    return pattern().matcher(string).find();
  }

  /**
   * Counts the number of substrings in the given String which match this Regex.
   *
   * @param string string to test
   * @return count of how many substrings in the given string match this regex
   * @see Matcher#find()
   */
  default long containsCount(String string) {
    Matcher m = pattern().matcher(string);
    int count = 0;
    while (m.find()) {
      count++;
    }
    return count;
  }
}
