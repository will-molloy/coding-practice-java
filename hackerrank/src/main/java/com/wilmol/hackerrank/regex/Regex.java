package com.wilmol.hackerrank.regex;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Wraps a {@link java.util.regex} {@link Pattern} and {@link Matcher} for convenience.
 * <p>
 * Interface so lambda can be used.
 * <p>
 * Created by Will on 2019-04-02 at 21:10
 * <p>
 * https://regex101.com/
 */
@FunctionalInterface
public interface Regex
{

  /**
   * @return the regex. Note Java requires \\ instead of \ for escaping.
   */
  String regex();

  private Pattern pattern()
  {
    RegexCache.LOG.debug("Pattern cache size: {}", RegexCache.PATTERN_CACHE.size());
    return RegexCache.PATTERN_CACHE.computeIfAbsent(regex(), Pattern::compile);
  }

  private Matcher matcher(String string)
  {
    Pattern p = pattern();
    return p.matcher(string);
  }

  default boolean matches(String string)
  {
    return pattern().asMatchPredicate()
        .test(string);
  }

  default boolean contains(String string)
  {
    return pattern().asPredicate()
        .test(string);
  }

  default long matchCount(String string)
  {
    Matcher m = matcher(string);
    return IntStream.iterate(0, n -> n + 1)
        .takeWhile(n -> m.find())
        .count();
  }

  final class RegexCache
  {

    private static final Logger LOG = LogManager.getLogger();

    private static final Map<String, Pattern> PATTERN_CACHE = new ConcurrentHashMap<>();

    private RegexCache()
    {
    }
  }

}
