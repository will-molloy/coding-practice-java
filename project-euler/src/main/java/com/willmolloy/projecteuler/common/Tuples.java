package com.willmolloy.projecteuler.common;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Extensions to {@link org.apache.commons.lang3.tuple}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public final class Tuples {

  private Tuples() {}

  public static <A, B, C> Function<Pair<A, B>, C> function(BiFunction<A, B, C> f) {
    return pair -> f.apply(pair.getLeft(), pair.getRight());
  }

  public static <A, B> Predicate<Pair<A, B>> predicate(BiPredicate<A, B> p) {
    return pair -> p.test(pair.getLeft(), pair.getRight());
  }

  public static <A, B> Consumer<Pair<A, B>> consumer(BiConsumer<A, B> c) {
    return pair -> c.accept(pair.getLeft(), pair.getRight());
  }
}
