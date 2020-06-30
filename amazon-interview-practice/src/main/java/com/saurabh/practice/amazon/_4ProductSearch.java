package com.saurabh.practice.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Problem at https://leetcode.com/problems/search-suggestions-system/
public class _4ProductSearch {
  public static void main(String[] args) {
    _4ProductSearch obj = new _4ProductSearch();
    System.out.println(obj.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
  }

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Trie trie = new Trie();
    for (String product : products) {
      trie.insert(product); // Use just one trie
    }

    List<List<String>> allMatches = new ArrayList<>();
    for (int i = 1; i <= searchWord.toCharArray().length; i++) {
      List<String> matches = trie.getMatches(searchWord.substring(0, i));
      Collections.sort(matches);
      if (matches.size() > 3) {
        matches = matches.subList(0, 3);
      }
      allMatches.add(matches);
    }
    return allMatches;
  }
}

class Trie {
  private final TrieNode root = new TrieNode(); //Each trie always has a root node

  public void insert(String key) {
    TrieNode current = root;
    for (char ch : key.toCharArray()) {
      TrieNode child = current.children.get(ch);
      if (child == null) {
        child = new TrieNode();
        current.children.put(ch, child);
      }
      current = child;
    }
    current.isEndOfWord = true;
  }

  // Search the trie for the given prefix, and return all matching words
  public List<String> getMatches(String prefix) {
    List<String> matches = new ArrayList<>();
    StringBuilder matchSoFar = new StringBuilder();
    TrieNode current = root;
    for (char ch : prefix.toCharArray()) {
      TrieNode child = current.children.get(ch);
      if (child == null) {
        break;
      } else {
        matchSoFar.append(ch);
        if (current.isEndOfWord) {
          matches.add(matchSoFar.toString());
        }
      }
      current = child;
    }

    // traverse different branches of trie, adding words to matches list
    dfs(current, matches, matchSoFar.toString());
    return matches;
  }

  private void dfs(TrieNode current, List<String> matches, String prevSoFar) {
    if (current.isEndOfWord) {
      matches.add(prevSoFar);
    }

    for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
      dfs(entry.getValue(), matches, prevSoFar + entry.getKey());
    }
  }
}

class TrieNode {
  boolean isEndOfWord = false;
  final Map<Character, TrieNode> children = new HashMap<>();

  @Override
  public String toString() {
    return "isEndOfWord=" + isEndOfWord + ", children=" + children;
  }
}
