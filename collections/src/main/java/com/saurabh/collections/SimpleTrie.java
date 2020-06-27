package com.saurabh.collections;

import java.util.LinkedHashMap;

/**
 * Case-sensitive Trie implementation for the entire ascii range
 */
public class SimpleTrie {
  private static final int ALPHABET_SIZE = 128;
  private final TrieNode root;

  public SimpleTrie(String key) {
    this.root = insert(key);
  }

  private static TrieNode insert(String key) {
    char[] keyChars = key.toCharArray();
    TrieNode root = new TrieNode();
    TrieNode current = root;
    for (char keyChar : keyChars) {
      TrieNode rightfulPosition = current.children[(int) keyChar];
      if (rightfulPosition == null) {
        current.children[(int) keyChar] = new TrieNode();
      }
      current = current.children[(int) keyChar];
    }

    current.endOfWord = true;
    return root;
  }

  public boolean startsWith(String key) {
    return searchInternal(key, false);
  }

  public boolean search(String key) {
    return searchInternal(key, true);
  }

  private boolean searchInternal(String key, boolean strict) {
    LinkedHashMap<TrieNode, Integer> allFoundItems = new LinkedHashMap<>();
    char[] keyChars = key.toCharArray();
    TrieNode current = root;

    for (char keyChar : keyChars) {
      TrieNode rightfulPosition = current.children[(int) keyChar];
      if (rightfulPosition == null) {
        break;
      }
      current = rightfulPosition;
      allFoundItems.put(current, (int) keyChar);
    }

    boolean mandatoryCondition = allFoundItems.size() == key.length();
    if (strict) {
      // The last entry should have endOfWord set
      return mandatoryCondition && allFoundItems.keySet().stream().skip(allFoundItems.keySet().size() - 1).anyMatch(trieNode -> trieNode.endOfWord);
    } else {
      return mandatoryCondition;
    }
  }

  private static class TrieNode {
    private boolean endOfWord;
    private final TrieNode[] children = new TrieNode[ALPHABET_SIZE];
  }
}
