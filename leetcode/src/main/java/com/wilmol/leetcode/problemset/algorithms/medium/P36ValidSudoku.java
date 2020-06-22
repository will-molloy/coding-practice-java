package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by wilmol on 2019-08-18.
 *
 * <p><a
 * href=https://leetcode.com/problems/valid-sudoku>https://leetcode.com/problems/valid-sudoku</a>
 *
 * <p>Runtime: O(1) - board is always same size (9x9)
 */
class P36ValidSudoku {

  public boolean isValidSudoku(char[][] board) {
    SudokuBoard sudokuBoard = new SudokuBoard(board);
    return isWithoutRepetition(sudokuBoard.rows())
        && isWithoutRepetition(sudokuBoard.columns())
        && isWithoutRepetition(sudokuBoard.subBoxes());
  }

  private boolean isWithoutRepetition(Stream<Stream<Character>> streamStream) {
    return streamStream.allMatch(
        stream -> {
          Set<Character> set = new HashSet<>();
          return stream.filter(c -> c != '.').allMatch(set::add);
        });
  }

  /** A Sudoku board. */
  private static final class SudokuBoard {

    /** The underlying board. */
    private final char[][] board;

    private SudokuBoard(char[][] board) {
      if (board.length != 9 && Arrays.stream(board).anyMatch(row -> row.length != 9)) {
        throw new IllegalArgumentException("Expected 9x9 board");
      }
      this.board = board;
    }

    /**
     * Get the boards rows.
     *
     * @return the boards 9 rows.
     */
    public Stream<Stream<Character>> rows() {
      return Arrays.stream(board).map(row -> IntStream.range(0, 9).mapToObj(col -> row[col]));
    }

    /**
     * Get the boards columns.
     *
     * @return the boards 9 columns.
     */
    public Stream<Stream<Character>> columns() {
      return IntStream.range(0, 9)
          .mapToObj(col -> IntStream.range(0, 9).mapToObj(row -> board[row][col]));
    }

    /**
     * Get the boards sub-boxes.
     *
     * @return the boards 9 sub-boxes. (Boxes are flattened, left to right, top to bottom.)
     */
    public Stream<Stream<Character>> subBoxes() {
      return Stream.of(0, 3, 6)
          .flatMap(rowStart -> Stream.of(0, 3, 6).map(colStart -> subBox(rowStart, colStart)));
    }

    private Stream<Character> subBox(int rowStart, int colStart) {
      return IntStream.range(rowStart, rowStart + 3)
          .boxed()
          .flatMap(row -> IntStream.range(colStart, colStart + 3).mapToObj(col -> board[row][col]));
    }
  }
}
