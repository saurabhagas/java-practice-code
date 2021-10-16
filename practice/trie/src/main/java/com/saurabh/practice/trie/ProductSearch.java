package com.saurabh.practice.trie;

import java.util.ArrayList;
import java.util.List;

import com.saurabh.source.data_structures.Trie;

// Problem at https://leetcode.com/problems/search-suggestions-system/
public class ProductSearch {
  public static void main(String[] args) {
    ProductSearch obj = new ProductSearch();
    String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
    System.out.println(obj.suggestedProducts(products, "mouse"));
  }

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Trie trie = new Trie();
    for (String product : products) {
      trie.insert(product);
    }

    List<List<String>> allMatches = new ArrayList<>();
    for (int i = 1; i <= searchWord.toCharArray().length; i++) {
      List<String> matches = new ArrayList<>(trie.getAutoCompleteSuggestions(searchWord.substring(0, i)));
      if (matches.size() > 3) {
        matches = matches.subList(0, 3);
      }
      allMatches.add(matches);
    }
    return allMatches;
  }
}

