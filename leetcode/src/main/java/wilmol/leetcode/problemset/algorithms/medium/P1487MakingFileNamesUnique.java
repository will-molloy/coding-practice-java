package wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wilmol on 2020-06-21.
 *
 * <p><a
 * href=https://leetcode.com/problems/making-file-names-unique>https://leetcode.com/problems/making-file-names-unique/</a>
 *
 * <p>Runtime: O(n) (amortised analysis - start from most recent k so never repeat computation)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: When suffixing a name, must store its suffixed occurrence in map as well so it isn't
 * repeated. Also should use map to store k values so can start from most recent k (as opposed to a
 * set and always starting at 1).
 *
 * <p>Another thing, which wasn't very clear from the problem, is that a name is only ever suffixed
 * with a single "(k)".
 */
class P1487MakingFileNamesUnique {

  public String[] getFolderNames(String[] names) {
    Map<String, Integer> nameCounts = new HashMap<>();
    List<String> result = new ArrayList<>();

    for (String name : names) {
      if (nameCounts.containsKey(name)) {

        // name reserved, search for earliest k that can be used in suffix
        // start search from most recent k, otherwise the solution is O(n^2)

        // binary search isn't correct since there may be later suffixes used already
        // i.e. when checking if name is reserved, an earlier suffix may be free even if a later one
        // isn't, so the binary search may incorrectly assign a larger suffix

        int k = nameCounts.get(name);
        while (nameCounts.containsKey(name + "(" + k + ")")) {
          k++;
        }
        // update suffix value for name, so don't repeat search
        nameCounts.put(name, k + 1);
        // also store the suffixed name, as its being used
        nameCounts.put(name + "(" + k + ")", 1);
        result.add(name + "(" + k + ")");
      } else {
        nameCounts.put(name, 1);
        result.add(name);
      }
    }
    return result.toArray(new String[0]);
  }
}
