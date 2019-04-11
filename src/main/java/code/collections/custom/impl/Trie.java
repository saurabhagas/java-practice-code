package code.collections.custom.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

/**
 * Case-insensitive Trie implementation for the English alphabet
 */
public class Trie {
  private static final int ALPHABET_SIZE = 26;
  private TrieNode root = new TrieNode();

  public boolean insert(String key) {
    Objects.requireNonNull(key);
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

  public boolean search(String key) {
    Objects.requireNonNull(key);

    char[] keyChars = key.toLowerCase().toCharArray();
    TrieNode current = root;
    for (char keyChar : keyChars) {
      int index = getIndex(keyChar);
      TrieNode rightfulPosition = current.children[index];
      if (rightfulPosition == null) {
        return false;
      }
      current = rightfulPosition;
    }

    return current.endOfWord;
  }

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

  public List<String> getWords() {
    List<String> list = new ArrayList<>();
    getWordsInternal(root, list, new char[20], 0);
    return list;
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

  private char getChar(int index) {
    return (char) (index + 'a');
  }

  private int getIndex(char keyChar) {
    return keyChar - 'a';
  }

  private class TrieNode {
    private boolean endOfWord;
    private TrieNode[] children = new TrieNode[ALPHABET_SIZE];

    private boolean hasChildren() {
      return Arrays.stream(children).anyMatch(Objects::nonNull);
    }
  }
}
