package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-02-21. */
class P146LruCacheTest {

  @Test
  void example() {
    P146LruCache cache = new P146LruCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    assertThat(cache.get(1)).isEqualTo(1);
    cache.put(3, 3); // evicts key 2
    assertThat(cache.get(2)).isEqualTo(-1);
    cache.put(4, 4); // evicts key 1
    assertThat(cache.get(1)).isEqualTo(-1);
    assertThat(cache.get(3)).isEqualTo(3);
    assertThat(cache.get(4)).isEqualTo(4);
  }

  @Test
  void putSameKeyDoesntEvict() {
    P146LruCache cache = new P146LruCache(2);
    assertThat(cache.get(2)).isEqualTo(-1);
    cache.put(2, 6);
    assertThat(cache.get(1)).isEqualTo(-1);
    cache.put(1, 5);
    cache.put(1, 2);
    assertThat(cache.get(1)).isEqualTo(2);
    assertThat(cache.get(2)).isEqualTo(6);
  }

  @Test
  void invalidCapacity() {
    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> new P146LruCache(0));
    assertThat(thrown).hasMessageThat().isEqualTo("Invalid capacity: 0");
  }
}
