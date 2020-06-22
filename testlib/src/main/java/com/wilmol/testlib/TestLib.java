package com.wilmol.testlib;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

/** Created by wilmol on 2020-05-25. */
public final class TestLib {

  /**
   * Computes the cartesian product of arguments for use in parameterised tests.
   *
   * <p>E.g.
   *
   * <pre>{@code
   * cartesianProduct(
   *   List.of(Arguments.of(x), Arguments.of(y)),
   *   List.of(Arguments.of(a, b), Arguments.of(c, d))
   * );
   * }</pre>
   *
   * <p>returns a {@code Stream<Arguments>} containing four {@code Arguments} in the following
   * order:
   *
   * <ul>
   *   <li>{@code Arguments.of(x, a, b)}
   *   <li>{@code Arguments.of(x, c, d)}
   *   <li>{@code Arguments.of(y, a, b)}
   *   <li>{@code Arguments.of(y, c, d)}
   * </ul>
   *
   * @param lists argument sources
   * @return the cartesian product as a {@code Stream<Arguments>}
   * @see Lists#cartesianProduct
   */
  @SafeVarargs
  public static Stream<Arguments> cartesianProduct(List<Arguments>... lists) {
    return Lists.cartesianProduct(lists).stream()
        .map(cartesianList -> cartesianList.stream().map(Arguments::get).flatMap(Stream::of))
        .map(Stream::toArray)
        .map(Arguments::of);
  }

  private TestLib() {}
}
