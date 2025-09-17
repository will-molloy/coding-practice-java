package com.willmolloy.adventofcode.common;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link Day}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public abstract class DayTest {
  private final Day day;
  private final FileInput exampleInput;
  private final Optional<FileInput> realInput;

  protected DayTest(Day day) {
    this.day = day;
    this.exampleInput = FileInput.example(day);
    this.realInput = FileInput.real(day);
  }

  @Test
  void part1_exampleInput() {
    assertThat(day.part1(exampleInput)).isEqualTo(part1().example());
  }

  @Test
  void part1_realInput() {
    assumeTrue(realInput.isPresent());
    assertThat(day.part1(realInput.get())).isEqualTo(part1().real());
  }

  @Test
  void part2_exampleInput() {
    assertThat(day.part2(exampleInput)).isEqualTo(part2().example());
  }

  @Test
  void part2_realInput() {
    assumeTrue(realInput.isPresent());
    assertThat(day.part2(realInput.get())).isEqualTo(part2().real());
  }

  protected abstract Answer part1();

  protected abstract Answer part2();

  /**
   * Expected answer.
   *
   * @param example expected example answer
   * @param real expected real answer
   */
  public record Answer(Object example, Object real) {}
}
