package wilmol.hackerrank.interviewpreparationkit.warmup.easy;

/**
 * Created by Will on 24/03/2019.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup>https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup</a>
 *
 * <p>Print the minimum number of jumps needed to win the game. (It's always possible to win.) Can
 * jump on 0s but not 1s. Can jump either 1 or 2 clouds ahead.
 *
 * <p>Runtime: O(n)
 */
final class JumpingOnTheClouds {

  private JumpingOnTheClouds() {}

  static int jumpingOnClouds(int[] clouds) {
    int jumps = 0;
    int cloud = 0;

    while (cloud < clouds.length - 1) {
      // be greedy and always try to jump 2
      if (cloud < clouds.length - 2 && clouds[cloud + 2] != 1) {
        cloud += 2;
      } else {
        // assumed always possible to win, don't need to check for 1 or 0
        cloud += 1;
      }
      jumps += 1;
    }
    return jumps;
  }
}
