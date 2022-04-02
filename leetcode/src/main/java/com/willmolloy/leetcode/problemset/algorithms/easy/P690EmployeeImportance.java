package com.willmolloy.leetcode.problemset.algorithms.easy;

import static java.util.Objects.requireNonNull;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * <a
 * href=https://leetcode.com/problems/employee-importance>https://leetcode.com/problems/employee-importance/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Hashmap to make the graph traversal more efficient.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P690EmployeeImportance {

  public int getImportance(List<Employee> employees, int id) {
    // just a graph

    Map<Integer, Employee> employeesAsMap = new HashMap<>();
    for (Employee e : employees) {
      employeesAsMap.put(e.id, e);
    }

    // traverse graph somehow
    // BFS
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(id);

    int ans = 0;

    while (!queue.isEmpty()) {
      int eId = queue.remove();
      Employee e = employeesAsMap.get(eId);
      ans += e.importance;
      // don't need to check if already seen as employees have at most one direct leader
      // (indegree <= 1)
      queue.addAll(e.subordinates);
    }
    return ans;
  }

  /** Employee. */
  static final class Employee {
    private final int id;
    private final int importance;
    private final List<Integer> subordinates;

    Employee(int id, int importance, List<Integer> subordinates) {
      this.id = id;
      this.importance = importance;
      this.subordinates = requireNonNull(subordinates);
    }
  }
}
