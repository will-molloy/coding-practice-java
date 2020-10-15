package com.wilmol.testlib;

import static java.util.stream.Collectors.toList;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

/**
 * TestLib.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
public final class TestLib {

  /**
   * Computes the cartesian product of arguments for use in parameterised tests.
   *
   * <p>Nested {@link Arguments} instances will be treated as tuples.
   *
   * <p>E.g.
   *
   * <pre>{@code
   * cartesianProduct(
   *   Stream.of(x, y),
   *   Stream.of(Arguments.of(a, b), Arguments.of(c, d))
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
   * @param arguments argument sources
   * @return the cartesian product as a {@code Stream<Arguments>}
   * @see Lists#cartesianProduct
   */
  public static Stream<Arguments> cartesianProduct(Stream<?>... arguments) {
    List<List<?>> argumentsAsLists =
        Arrays.stream(arguments).map(s -> s.collect(toList())).collect(toList());
    List<List<Object>> cartesianProduct = Lists.cartesianProduct(argumentsAsLists);

    return cartesianProduct.stream()
        .map(
            l ->
                l.stream()
                    .flatMap(
                        o ->
                            o instanceof Arguments
                                ? Stream.of(((Arguments) o).get())
                                : Stream.of(o)))
        .map(Stream::toArray)
        .map(Arguments::of);
  }

  private TestLib() {}
}
