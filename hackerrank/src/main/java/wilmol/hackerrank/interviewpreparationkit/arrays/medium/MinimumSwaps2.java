package wilmol.hackerrank.interviewpreparationkit.arrays.medium;

/**
 * Created by Will on 2019-03-30 at 20:36.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays>https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays</a>
 *
 * <p>Minimum swaps to sort the array (array has heavy constraints)
 *
 * <p>Runtime: O(n)
 */
final class MinimumSwaps2 {

  private MinimumSwaps2() {}

  // given the elements (e1, ..., en) fit 1 <= e <= n and no duplicates, the sorted array will be
  // [1, 2, 3, ..., n]
  static int minimumSwaps(int[] a) {
    boolean[] visited = new boolean[a.length];
    int numSwaps = 0;
    // the unsorted elements form cycles
    // min number of swaps to fix a cycle the length of the cycle -1 (-1 since last swap fixes two
    // elements)
    // so contains the cycles and sum their sizes
    for (int i = 0; i < a.length; i++) {
      if (visited[i] || a[i] == i + 1) {
        continue;
      }
      int cycleLength = 0;
      int next = i + 1;
      while (!visited[next - 1]) {
        visited[next - 1] = true;
        next = a[next - 1];
        cycleLength += 1;
      }
      numSwaps += cycleLength - 1;
    }
    return numSwaps;
  }
}
