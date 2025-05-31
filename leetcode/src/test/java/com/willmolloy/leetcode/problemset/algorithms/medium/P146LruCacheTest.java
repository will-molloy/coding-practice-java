package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P146LruCacheTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P146LruCacheTest {

  static Stream<Function<Integer, P146LruCache>> solutions() {
    return Stream.of(
        P146LruCache.CustomLinkedList::new,
        P146LruCache.BuiltInLinkedList::new,
        P146LruCache.LinkedHashMapDelegate::new);
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void example(Function<Integer, P146LruCache> lruFactory) {
    P146LruCache lru = lruFactory.apply(2);
    lru.put(1, 1);
    lru.put(2, 2);
    assertThat(lru.get(1)).isEqualTo(1);
    lru.put(3, 3); // evicts key 2
    assertThat(lru.get(2)).isEqualTo(-1);
    lru.put(4, 4); // evicts key 1
    assertThat(lru.get(1)).isEqualTo(-1);
    assertThat(lru.get(3)).isEqualTo(3);
    assertThat(lru.get(4)).isEqualTo(4);
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void putSameKeyDoesntEvict(Function<Integer, P146LruCache> lruFactory) {
    P146LruCache lru = lruFactory.apply(2);
    assertThat(lru.get(2)).isEqualTo(-1);
    lru.put(2, 6);
    assertThat(lru.get(1)).isEqualTo(-1);
    lru.put(1, 5);
    lru.put(1, 2);
    assertThat(lru.get(1)).isEqualTo(2);
    assertThat(lru.get(2)).isEqualTo(6);
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void invalidCapacity(Function<Integer, P146LruCache> lruFactory) {
    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> lruFactory.apply(0));
    assertThat(thrown).hasMessageThat().isEqualTo("Invalid capacity: 0");
  }
}
