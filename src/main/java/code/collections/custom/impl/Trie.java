package code.collections.custom.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Trie implementation for the English alphabet
 */
public class Trie {
  private TrieNode root = new TrieNode();

  public static void main(String[] args) {
    String[] keys = {"the", "a", "there", "answer", "any", "any", "by", "bye", "the", "their", "abc"};
    Trie trie = new Trie();

    System.out.println("####Inserting keys####");
    for (String key : keys) {
      System.out.println("Inserting key: '" + key + "'. Insert successful? " + trie.insert(key));
    }

    System.out.println(System.lineSeparator() + "####Searching the inserted keys####");
    for (String key : keys) {
      System.out.println("Searching key: '" + key + "'. Search successful? " + trie.search(key));
    }
    System.out.println(System.lineSeparator() + "####Searching non-existent keys####");
    String[] nonExistentKeys = {"foo", "bar", "therefore", "answered", "an", "ab"};
    for (String key : nonExistentKeys) {
      System.out.println("Searching non-existent key: '" + key + "'. Search successful? " + trie.search(key));
    }

    System.out.println(System.lineSeparator() + "####Deleting existing keys####");
    String[] toDelete = {"the", "a", "by"};
    for (String key : toDelete) {
      System.out.println("Deleting key: '" + key + "'. Delete successful? " + trie.remove(key));
    }
    System.out.println(System.lineSeparator() + "####Deleting non-existent keys####");
    for (String key : nonExistentKeys) {
      System.out.println("Deleting non-existent key: '" + key + "'. Delete successful? " + trie.remove(key));
    }

    System.out.println(System.lineSeparator() + "####Verifiying state####");
    List<String> survived = new ArrayList<>(Arrays.asList(keys));
    survived.removeAll(Arrays.asList(toDelete));
    trie.searchAndThrow(toDelete, false);
    trie.searchAndThrow(survived.toArray(new String[0]), true);
    System.out.println("####Verification successful####");

    System.out.println(System.lineSeparator() + "####Deleting rest of the keys now####");
    toDelete = new String[]{"there", "answer", "any", "bye", "their", "abc"};
    for (String key : toDelete) {
      System.out.println("Deleting key: '" + key + "'. Delete successful? " + trie.remove(key));
    }

    System.out.println(System.lineSeparator() + "####Verifiying state####");
    survived.removeAll(Arrays.asList(toDelete));
    trie.searchAndThrow(toDelete, false);
    assert survived.size() == 0;
    System.out.println("####Verification successful####");
  }

  private void searchAndThrow(String[] toDelete, boolean expectToFind) {
    for (String s : toDelete) {
      if (search(s) != expectToFind) {
        throw new AssertionError("Expected to find key '" + s + "': " + expectToFind + ", but search resulted in: " + search(s));
      }
    }
  }

  public boolean insert(String key) {
    int allocations = 0;
    if (key == null) {
      throw new NullPointerException("Keys can't be null");
    }

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

  public boolean remove(String key) {
    if (key == null) {
      throw new NullPointerException("Keys can't be null");
    }

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
    if (key == null) {
      throw new NullPointerException("Keys can't be null");
    }

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

  private int getIndex(char keyChar) {
    return keyChar - 'a';
  }

  private class TrieNode {
    private boolean endOfWord;
    private TrieNode[] children = new TrieNode[26];

    private boolean hasChildren() {
      return Arrays.stream(children).anyMatch(Objects::nonNull);
    }
  }
}
