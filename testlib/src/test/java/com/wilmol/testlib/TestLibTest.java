package com.wilmol.testlib;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.truth.Correspondence;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

/** Created by wilmol on 2020-05-25. */
class TestLibTest {

  @Test
  void testCartesianProduct() {
    assertThat(
            TestLib.cartesianProduct(
                    List.of(Arguments.of("x"), Arguments.of("y")),
                    List.of(Arguments.of("a", "b"), Arguments.of("c", "d")))
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
