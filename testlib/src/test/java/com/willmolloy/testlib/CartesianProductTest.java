package com.willmolloy.testlib;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.truth.Correspondence;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

/**
 * TestLibTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class CartesianProductTest {

  @Test
  void testCartesianProduct() {
    assertThat(
            CartesianProduct.cartesianProduct(
                    Stream.of("x", "y"), Stream.of(Arguments.of("a", "b"), Arguments.of("c", "d")))
                // TODO remove when StreamSubject supports comparingElementsUsing
                .collect(Collectors.toList()))
        .comparingElementsUsing(argumentsCorrespondence())
        .containsExactly(
            Arguments.of("x", "a", "b"),
            Arguments.of("x", "c", "d"),
            Arguments.of("y", "a", "b"),
            Arguments.of("y", "c", "d"))
        .inOrder();
  }

  private static Correspondence<Arguments, Arguments> argumentsCorrespondence() {
    return Correspondence.from(
        (actual, expected) -> Arrays.equals(actual.get(), expected.get()), "equals");
  }
}
