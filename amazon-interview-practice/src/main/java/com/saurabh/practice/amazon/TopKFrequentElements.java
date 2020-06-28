package com.saurabh.practice.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
  public static void main(String[] args) {
    TopKFrequentElements obj = new TopKFrequentElements();
    System.out.println(obj.topKFrequentUsingBubbleSort(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
  }

  public List<String> topKFrequentUsingHashMap(String[] words, int k) {
    Map<String, Integer> wordCounts = new HashMap<>();
    for (String word : words) {
      wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
    }

    List<String> sortedElements = new ArrayList<>(wordCounts.keySet());
    Collections.sort(sortedElements, (o1, o2) -> {
      int freqDiff = wordCounts.get(o2) - wordCounts.get(o1);
      return freqDiff != 0 ? freqDiff : o1.compareTo(o2);
    });
    return sortedElements.subList(0, k);
  }

  public List<String> topKFrequentUsingHeap(String[] words, int k) {
    Map<String, Integer> wordCounts = new HashMap<>();
    for (String word : words) {
      wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
    }

    // Min heap of size k
    PriorityQueue<String> heap = new PriorityQueue<>((o1, o2) -> {
      int freqDiff = wordCounts.get(o1) - wordCounts.get(o2);
      return freqDiff != 0 ? freqDiff : o2.compareTo(o1);
    });

    // Read from wordCounts keyset and insert (to avoid key duplication in heap)
    for (String word : wordCounts.keySet()) {
      heap.offer(word);
      if (heap.size() > k) heap.poll();
    }

    List<String> topK = new ArrayList<>();
    while (!heap.isEmpty()) topK.add(heap.poll());
    Collections.reverse(topK);
    return topK;
  }

  public List<String> topKFrequentUsingBubbleSort(String[] words, int k) {
    Map<String, Integer> wordCounts = new HashMap<>();
    for (String word : words) {
      wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
    }

    ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCounts.entrySet());
    System.out.println(entries);
    for (int i = 0; i < entries.size(); i++) {
      for (int j = 0; j < entries.size() - i - 1; j++) {
        if (entries.get(j).getValue() < entries.get(j + 1).getValue() ||
            (entries.get(j).getValue().equals(entries.get(j + 1).getValue()) && entries.get(j).getKey().compareTo(entries.get(j + 1).getKey()) < 0)) {
          Collections.swap(entries, j + 1, j);
        }
      }
    }
    System.out.println("k-sorted entries: " + entries);
    List<String> topK = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      topK.add(entries.get(i).getKey());
    }
    return topK;
  }
}