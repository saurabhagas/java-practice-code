package com.saurabh.practice.array;

import java.util.*;

public class OptimizeMemoryUsage {
  public static void main(String[] args) {
    OptimizeMemoryUsage s = new OptimizeMemoryUsage();
    List<int[]> output = s.optimizeMemoryUsage(new int[]{6, 6, 6}, new int[]{1}, 7);
    output.forEach(e -> System.out.println("[" + e[0] + ", " + e[1] + "]"));
  }

  public List<int[]> optimizeMemoryUsage(int[] foregroundTasks, int[] backgroundTasks, int K) {
    List<Integer> ans = new ArrayList<Integer>();
    Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
    for (int i = 0; i < foregroundTasks.length; i++) {
      for (int j = 0; j < backgroundTasks.length; j++) {
        List<int[]> list = map.getOrDefault(foregroundTasks[i] + backgroundTasks[j], new ArrayList<int[]>());
        list.add(new int[]{i, j});
        map.put(foregroundTasks[i] + backgroundTasks[j], list);
      }
    }

    for (int i = 0; i < foregroundTasks.length; i++) {
      if (foregroundTasks[i] <= K) {
        List<int[]> list = map.getOrDefault(foregroundTasks[i], new ArrayList<int[]>());
        list.add(new int[]{i, -1});
        map.put(foregroundTasks[i], list);
      }
    }

    for (int i = 0; i < backgroundTasks.length; i++) {
      if (backgroundTasks[i] <= K) {
        List<int[]> list = map.getOrDefault(backgroundTasks[i], new ArrayList<int[]>());
        list.add(new int[]{-1, i});
        map.put(backgroundTasks[i], list);
      }
    }

    for (Map.Entry<Integer, List<int[]>> en : map.entrySet()) {
      if (en.getKey() == K) {
        return en.getValue();
      } else if (en.getKey() <= K) {
        ans.add(en.getKey());
      }
    }

    if (ans.size() == 0) {
      return new ArrayList<int[]>() {{
        add(new int[]{-1, -1});
      }};
    }

    return map.get(Collections.max(ans));

  }


}
