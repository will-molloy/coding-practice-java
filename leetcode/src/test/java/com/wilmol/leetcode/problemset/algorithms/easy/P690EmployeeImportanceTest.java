package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import com.wilmol.leetcode.problemset.algorithms.easy.P690EmployeeImportance.Employee;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P690EmployeeImportanceTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P690EmployeeImportanceTest {

  private final P690EmployeeImportance p690 = new P690EmployeeImportance();

  @ParameterizedTest
  @MethodSource
  void examples(List<Employee> employees, int id, int expected) {
    assertThat(p690.getImportance(employees, id)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            ImmutableList.of(
                new Employee(1, 5, ImmutableList.of(2, 3)),
                new Employee(2, 3, ImmutableList.of()),
                new Employee(3, 3, ImmutableList.of())),
            1,
            11),
        Arguments.of(
            ImmutableList.of(
                new Employee(1, 2, ImmutableList.of(2)), new Employee(2, 3, ImmutableList.of())),
            2,
            3));
  }
}
