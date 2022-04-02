package com.willmolloy.projecteuler.common;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.stream.IntStream.range;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Streams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Common collection functions.
 *
 * @see java.util
 * @see com.google.common.collect
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public final class Collections {

  private Collections() {}

  /**
   * Creates a sequence of 'sliding' windows from the given sequence.
   *
   * <p>TODO make return type {@code Stream<Stream<T>>}
   */
  public static <T> List<List<T>> sliding(List<T> seq, int size) {
    checkNotNull(seq);
    checkArgument(size > 0 && seq.size() >= size);

    return IntStream.rangeClosed(0, seq.size() - size)
        .mapToObj(i -> seq.subList(i, i + size))
        .collect(ImmutableList.toImmutableList());
  }

  /** Creates the transpose of the given matrix. */
  public static <T> List<List<T>> transpose(List<? extends List<? extends T>> matrix) {
    checkNotNull(matrix);
    checkArgument(
        matrix.isEmpty() || matrix.stream().allMatch(row -> row.size() == matrix.get(0).size()));

    ImmutableList.Builder<List<T>> matrixBuilder = ImmutableList.builder();
    for (int i = 0; i < matrix.size(); i++) {
      ImmutableList.Builder<T> rowBuilder = ImmutableList.builder();
      for (int j = 0; j < matrix.get(0).size(); j++) {
        rowBuilder.add(matrix.get(j).get(i));
      }
      matrixBuilder.add(rowBuilder.build());
    }
    return matrixBuilder.build();
  }

  /** Returns the diagonal forward slopes (sloping up) of the given matrix. */
  public static <T> List<List<T>> diagonalForwardSlopes(List<List<T>> matrix) {
    checkNotNull(matrix);
    checkArgument(
        matrix.isEmpty() || matrix.stream().allMatch(row -> row.size() == matrix.get(0).size()));

    Stream<Pair<Integer, Integer>> startingFromFirstColumn =
        range(0, matrix.size()).mapToObj(i -> Pair.of(i, 0));

    // Start at 1 to avoid duplicate diagonal
    Stream<Pair<Integer, Integer>> startingFromLastRow =
        range(1, matrix.size()).mapToObj(i -> Pair.of(matrix.size() - 1, i));

    Stream<Pair<Integer, Integer>> startingCoordinates =
        Stream.concat(startingFromFirstColumn, startingFromLastRow);

    return startingCoordinates
        .map(
            Tuples.function(
                (i, j) ->
                    range(0, matrix.size() - Math.max(matrix.size() - 1 - i, j))
                        .mapToObj(k -> matrix.get(i - k).get(j + k))
                        .collect(ImmutableList.toImmutableList())))
        .collect(ImmutableList.toImmutableList());
  }

  /** Returns the diagonal backward slopes (sloping down) of the given matrix. */
  public static <T> List<List<T>> diagonalBackwardSlopes(List<List<T>> matrix) {
    checkNotNull(matrix);
    checkArgument(
        matrix.isEmpty() || matrix.stream().allMatch(row -> row.size() == matrix.get(0).size()));

    Stream<Pair<Integer, Integer>> startingFromFirstColumn =
        range(0, matrix.size())
            .map(i -> matrix.size() - 1 - i) // reverse order
            .mapToObj(i -> Pair.of(i, 0));

    // Start at 1 to avoid duplicate diagonal
    Stream<Pair<Integer, Integer>> startingFromFirstRow =
        range(1, matrix.size()).mapToObj(i -> Pair.of(0, i));

    Stream<Pair<Integer, Integer>> startingCoordinates =
        Stream.concat(startingFromFirstColumn, startingFromFirstRow);

    return startingCoordinates
        .map(
            Tuples.function(
                (i, j) ->
                    range(0, matrix.size() - Math.max(i, j))
                        .mapToObj(k -> matrix.get(i + k).get(j + k))
                        .collect(ImmutableList.toImmutableList())))
        .collect(ImmutableList.toImmutableList());
  }

  /**
   * Pairs the elements of the given stream with their indices.
   *
   * @deprecated use {@link com.google.common.collect.Streams#mapWithIndex(Stream,
   *     Streams.FunctionWithIndex)}
   */
  @Deprecated
  public static <T> Stream<Pair<T, Integer>> zipWithIndex(Stream<T> seq) {
    checkNotNull(seq);

    Iterator<T> iterator = seq.iterator();
    int i = 0;
    Stream.Builder<Pair<T, Integer>> builder = Stream.builder();
    // TODO make lazy
    while (iterator.hasNext()) {
      builder.add(Pair.of(iterator.next(), i));
      i++;
    }
    return builder.build();
  }

  /**
   * Zips the two sequences (pairwise) into a Stream of pairs.
   *
   * @deprecated use {@link com.google.common.collect.Streams#zip(Stream, Stream, BiFunction)}
   */
  @Deprecated
  public static <T, U> Stream<Pair<T, U>> zip(List<T> seqA, List<U> seqB) {
    checkNotNull(seqA);
    checkNotNull(seqB);
    checkArgument(seqA.size() == seqB.size(), "Sequences must be of same size for zipping.");

    return IntStream.range(0, seqA.size()).mapToObj(i -> Pair.of(seqA.get(i), seqB.get(i)));
  }

  /**
   * Generates and returns all the permutations of the given sequence in lexicographical order as a
   * lazy stream.
   *
   * <p>TODO don't use recursion? Still slow. Ideally want to provide efficient parallel stream!
   * Provide a 'next permutation method' or random access 'nth permutation method'.
   */
  public static <T> Stream<List<T>> permutations(List<T> list) {
    checkNotNull(list);

    final long size = Maths.factorial(list.size()).longValue();

    // Use Iterator interface to construct a stream of permutations
    Iterator<List<T>> permutationIterator =
        new Iterator<>() {
          private int current;

          @Override
          public boolean hasNext() {
            return current < size;
          }

          @Override
          public List<T> next() {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            current += 1;
            return get(current - 1, list);
          }

          /** Get the 'index' element in the permutation sequence. */
          private List<T> get(final long index, final List<T> list) {
            if (list.isEmpty()) {
              return list;
            } else {
              long max = Maths.factorial(list.size()).longValue();
              long divisor = max / list.size();
              int i = (int) (index / divisor);

              List<T> nextPartial = new ArrayList<>(list.size());
              nextPartial.addAll(list);
              T e = nextPartial.remove(i);

              List<T> next = new ArrayList<>();
              next.add(e);
              next.addAll(get(index - divisor * i, nextPartial));
              return next;
            }
          }
        };

    return StreamSupport.stream(
        Spliterators.spliterator(
            permutationIterator,
            size,
            Spliterator.ORDERED
                | Spliterator.SIZED
                | Spliterator.SORTED
                | Spliterator.CONCURRENT
                | Spliterator.NONNULL
                | Spliterator.IMMUTABLE),
        false);
  }
}
