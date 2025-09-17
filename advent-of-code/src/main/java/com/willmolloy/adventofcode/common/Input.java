package com.willmolloy.adventofcode.common;

import com.willmolloy.adventofcode.common.grid.CharGrid;
import java.util.List;

/**
 * Helper for reading the various inputs.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public interface Input {

  /** Read input lines. */
  List<String> lines();

  /** Read input num lines. */
  List<long[]> numLines();

  /** Read input string. */
  String string();

  /** Read input nums. */
  long[] nums();

  /** Read input {@link CharGrid}. */
  CharGrid charGrid();
}
