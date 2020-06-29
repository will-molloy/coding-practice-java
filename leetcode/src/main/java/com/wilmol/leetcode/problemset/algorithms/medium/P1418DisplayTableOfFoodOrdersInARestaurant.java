package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * <a
 * href=https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant>https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/</a>
 *
 * <p><a
 * href=https://leetcode.com/contest/weekly-contest-185/problems/display-table-of-food-orders-in-a-restaurant>https://leetcode.com/contest/weekly-contest-185/problems/display-table-of-food-orders-in-a-restaurant/</a>
 *
 * <p>Difficulty: Medium (4)
 *
 * <p>Time: 0:27:35 (0:16:14 excluding first problem)
 *
 * <p>Runtime: O(o * (log(t) + log(i)) + t * i * log(i)) (o = num orders, t = num tables, i = num
 * items)
 *
 * <p>Space: O(o)
 *
 * <p>Key: TreeMap/TreeSet to implicitly sort.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1418DisplayTableOfFoodOrdersInARestaurant {

  public List<List<String>> displayTable(List<List<String>> orders) {
    // process orders
    Map<String, Map<String, Integer>> allTableOrders =
        new TreeMap<>(Comparator.comparing(s -> Integer.valueOf(s)));
    Set<String> items = new TreeSet<>();
    // O(o)
    for (List<String> order : orders) {
      String tableNum = order.get(1);
      String item = order.get(2);
      // O(log i)
      items.add(item);
      Map<String, Integer> tableOrders = allTableOrders.getOrDefault(tableNum, new TreeMap<>());
      // O(log i)
      tableOrders.put(item, tableOrders.getOrDefault(item, 0) + 1);
      // O(log t)
      allTableOrders.put(tableNum, tableOrders);
    }

    // format orders into required output
    List<String> header = new ArrayList<>();
    header.add("Table");
    header.addAll(items);

    List<List<String>> result = new ArrayList<>();
    result.add(header);

    // O(t)
    for (Map.Entry<String, Map<String, Integer>> e : allTableOrders.entrySet()) {
      String tableNum = e.getKey();
      Map<String, Integer> tableOrders = e.getValue();
      List<String> tableOrdersAsList = new ArrayList<>();
      tableOrdersAsList.add(tableNum);
      // O(i)
      for (String item : items) {
        // O(log i)
        tableOrdersAsList.add(String.valueOf(tableOrders.getOrDefault(item, 0)));
      }
      result.add(tableOrdersAsList);
    }
    return result;
  }
}
