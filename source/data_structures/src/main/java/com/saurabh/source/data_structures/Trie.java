package com.saurabh.source.data_structures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Case-insensitive Trie implementation for the English alphabet
 */
public class Trie {
  private static final int ALPHABET_SIZE = 26;
  private static final int MAX_WORD_LENGTH = 20;
  private TrieNode root = new TrieNode();

  public boolean insert(String key) {
    Objects.requireNonNull(key);
    if (key.length() > MAX_WORD_LENGTH) {
      throw new IllegalArgumentException("Maximum permissible word length is: " + MAX_WORD_LENGTH);
    }

    int allocations = 0;
    char[] keyChars = key.toLowerCase().toCharArray();
    TrieNode current = root;
    for (char keyChar : keyChars) {
      int index = getIndex(keyChar);
      TrieNode rightfulPosition = current.children[index];
      if (rightfulPosition == null) {
        current.children[index] = new TrieNode();
        allocations++;
      }
      current = current.children[index];
    }

    current.endOfWord = true;
    return allocations != 0;
  }

  public void clear() {
    for (int i = 0; i < ALPHABET_SIZE; i++) {
      root.children[i] = null;
    }
  }

  public boolean remove(String key) {
    Objects.requireNonNull(key);

    char[] keyChars = key.toLowerCase().toCharArray();
    TrieNode current = root;
    TrieNode foundAt = null;
    int foundAtIndex = -1;
    for (char keyChar : keyChars) {
      int index = getIndex(keyChar);
      TrieNode rightfulPosition = current.children[index];
      if (rightfulPosition == null) {
        return false;
      }

      if (foundAt == null || rightfulPosition.endOfWord) {
        foundAt = current; // Update foundAt if words are found along the way
        foundAtIndex = index;
      }
      current = rightfulPosition;
    }

    if (!current.endOfWord) {
      return false; //Exact word not found, nothing to delete
    } else {
      if (current.hasChildren()) {
        current.endOfWord = false; //Current node has children, simply mark node as non-end-of-word and return
      } else {
        foundAt.children[foundAtIndex] = null;
      }
      return true;
    }
  }

  public boolean startsWith(String prefix) {
    Objects.requireNonNull(prefix);
    LinkedHashMap<TrieNode, Integer> foundNodeMap = searchInternal(prefix);
    return foundNodeMap.size() == prefix.length();
  }

  public boolean search(String key) {
    Objects.requireNonNull(key);
    LinkedHashMap<TrieNode, Integer> foundNodeMap = searchInternal(key);
    return foundNodeMap.size() == key.length() &&
        foundNodeMap.keySet().stream().skip(foundNodeMap.keySet().size() - 1).anyMatch(trieNode -> trieNode.endOfWord); // The last entry should have endOfWord set
  }

  /**
   * Finds the longest common prefix for elements present in the Trie
   *
   * @return the longest common prefix
   */
  public String longestCommonPrefix() {
    long parallelBranches = Arrays.stream(root.children).filter(Objects::nonNull).count();
    if (parallelBranches != 1) {
      return "";
    }

    StringBuilder stringBuilder = new StringBuilder();
    TrieNode current = root;
    while (current != null && !current.endOfWord) {
      int index = -1;
      int count = 0;

      TrieNode[] children = current.children;
      for (int i = 0; i < children.length; i++) {
        TrieNode child = children[i];
        if (child != null) {
          count++;
          if (index == -1) {
            index = i;
          } else {
            break;
          }
        }
      }

      if (count == 1) {
        stringBuilder.append(getChar(index));
        current = current.children[index];
      } else {
        break;
      }
    }
    return stringBuilder.toString();
  }

  /**
   * Gets prefixes (sorted in increasing order of length) common between the key and the Trie.
   *
   * @param key
   * @return all common prefixes
   */
  public List<String> allCommonPrefixes(String key) {
    Map<TrieNode, Integer> foundNodeMap = searchInternal(key);
    List<String> prefixes = new ArrayList<>();
    foundNodeMap.values().stream().map(this::getChar).forEach(character -> prefixes.add(character.toString()));
    for (int i = 1; i < prefixes.size(); i++) {
      String previous = prefixes.get(i - 1);
      prefixes.set(i, previous + prefixes.get(i));
    }
    return prefixes;
  }

  public int getWordCount() {
    Deque<TrieNode> stack = new ArrayDeque<>();
    stack.push(root);
    int wordCount = 0;
    while (!stack.isEmpty()) {
      Trie.TrieNode poppedItem = stack.pop();
      if (poppedItem.endOfWord) {
        wordCount++;
      }

      for (Trie.TrieNode child : poppedItem.children) {
        if (child != null) {
          stack.push(child);
        }
      }
    }
    return wordCount;
  }

  /**
   * Gets the words in the Trie, in alphabetically sorted order.
   *
   * @return alphabetically sorted words from the Trie
   */
  public Collection<String> getWords() {
    List<String> list = new ArrayList<>();
    getWordsInternal(root, list, new char[MAX_WORD_LENGTH], 0);
    return list;
  }

  public Collection<String> getAutoCompleteSuggestions(String base) {
    Map<TrieNode, Integer> foundNodeMap = searchInternal(base);

    if (foundNodeMap.isEmpty()) {
      return Collections.emptyList();
    } else {
      List<String> list = new ArrayList<>();
      char[] word = getBaseWordArray(base);
      Optional<TrieNode> nodeForBaseWord = foundNodeMap.keySet().stream().skip(foundNodeMap.size() - 1).findFirst();
      getWordsInternal(nodeForBaseWord.orElseThrow(IllegalStateException::new), list, word, base.length());
      return list;
    }
  }

  private char[] getBaseWordArray(String base) {
    char[] word = new char[MAX_WORD_LENGTH];
    char[] charArray = base.toCharArray();
    System.arraycopy(charArray, 0, word, 0, charArray.length);
    return word;
  }

  private void getWordsInternal(TrieNode root, List<String> wordList, char[] word, int level) {
    if (root == null) {
      return;
    }

    if (root.endOfWord) {
      wordList.add(new String(word).substring(0, level));
    }

    for (int i = 0; i < ALPHABET_SIZE; i++) {
      if (root.children[i] != null) {
        word[level] = getChar(i);
        getWordsInternal(root.children[i], wordList, word, level + 1);
      }
    }
  }

  private LinkedHashMap<TrieNode, Integer> searchInternal(String key) {
    LinkedHashMap<TrieNode, Integer> allFoundItems = new LinkedHashMap<>();
    char[] keyChars = key.toLowerCase().toCharArray();
    TrieNode current = root;

    for (char keyChar : keyChars) {
      int index = getIndex(keyChar);
      TrieNode rightfulPosition = current.children[index];
      if (rightfulPosition == null) {
        break;
      }
      current = rightfulPosition;
      allFoundItems.put(current, index);
    }

    return allFoundItems;
  }

  private char getChar(int index) {
    return (char) (index + 'a');
  }

  private int getIndex(char keyChar) {
    return keyChar - 'a';
  }

  private static class TrieNode {
    private boolean endOfWord;
    private final TrieNode[] children = new TrieNode[ALPHABET_SIZE];

    private boolean hasChildren() {
      return Arrays.stream(children).anyMatch(Objects::nonNull);
    }
  }
}
